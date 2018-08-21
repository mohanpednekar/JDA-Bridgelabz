package com.jda.user.controller;

import com.jda.user.model.Login;
import com.jda.user.model.User;
import com.jda.user.service.EmailService;
import com.jda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

@Controller
public class LoginController {
	@Autowired
	UserService userService;

	@Autowired
	EmailService emailService;

//	private static final Logger logger = Logger.getLogger(LoginController.class);

	@GetMapping("/login")
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	                                 @ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		if (null != user) {
			mav = new ModelAndView("redirect:/welcome");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
//			mav.addObject("firstname", user.getFirstname());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

	@GetMapping("/forgot")
	public ModelAndView showForget(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("forgotpassword");
	}

	@PostMapping("/forgotPasswordProcess")
	public ModelAndView forgotPasswordProcess(HttpServletRequest request, HttpServletResponse response, @RequestParam("email") String email) throws Exception {
		User user = userService.findUserByEmail(email);
		if (user == null) {
			Exception userNotFoundException = new Exception("User not found");
//			logger.error("User not found", userNotFoundException.getCause());
			userNotFoundException.printStackTrace();
			throw userNotFoundException;
		}

		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);
		String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

		// Email message
		SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
		passwordResetEmail.setFrom("pednekar.mohan@gmail.com");
		passwordResetEmail.setTo(user.getEmail());
		passwordResetEmail.setSubject("Password Reset Request");
		passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
				+ "/resetpassword?token=" + token);

		emailService.sendEmail(passwordResetEmail);

		ModelAndView mav = new ModelAndView("redirect:/resetEmailSent");
		// Add success message to view
		mav.addObject("successMessage", "A password reset link has been sent to " + user.getEmail());

		return mav;

	}

	@GetMapping("/resetpassword")
	public ModelAndView forgotPasswordProcess(ModelAndView modelAndView, @RequestParam("token") String token) {
		if (token == null) {
			System.out.println("Token is null");
		}

		User user = userService.findUserByResetToken(token);

		if (user != null) { // Token found in DB
			modelAndView.addObject("resetToken", token);
		} else { // Token not found in DB
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
		}
		modelAndView.setViewName("resetpassword");
		return modelAndView;
	}

	@PostMapping("resetPasswordProcess")
	public ModelAndView resetPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
		String resetToken = requestParams.get("resetToken");
		System.out.println("resetPasswordProcess: " + resetToken);
		// Find the user associated with the reset token
		User user = userService.findUserByResetToken(resetToken);

		// This should always be non-null but we check just in case
		if (user != null) {

			String password = requestParams.get("password");
			userService.savePasswordAndResetToken(user, password);
			// In order to set a model attribute on a redirect, we must use
			// RedirectAttributes
			redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

			modelAndView.setViewName("redirect:/login");
			return modelAndView;

		} else {
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
			modelAndView.setViewName("resetpassword");
		}

		return modelAndView;
	}
}
