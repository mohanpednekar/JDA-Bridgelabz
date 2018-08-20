package com.jda.user.service;

import com.jda.user.util.EmailUtil;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	private String password = System.getenv("mail.smtp.password");

	@Override
	public void sendEmail(SimpleMailMessage email) {

		final String fromEmail = email.getFrom(); //requires valid gmail id
		final String[] toEmail = email.getTo(); // can be any email id

		System.out.println("SSL Email Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password.trim());
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		EmailUtil.sendEmail(session, toEmail[0], email.getSubject(), email.getText());

	}
}

