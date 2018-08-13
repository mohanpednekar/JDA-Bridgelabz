package com.jda.dynamic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.dynamic.model.User;
import com.jda.dynamic.repository.UserRepository;
import com.jda.dynamic.repository.UserRepositoryImpl;

public class UserRegistrationServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  UserRepository repo = new UserRepositoryImpl();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user = new User();
    user.setId(1);
    user.setName(req.getParameter("name"));
    user.setEmail(req.getParameter("email"));
    user.setPhone(req.getParameter("phone"));
    String pass1 = req.getParameter("password1");
    String pass2 = req.getParameter("password2");
    if (pass1.equals(pass2)) {
      user.setPassword(pass1);
      repo.save(user);
      resp.sendRedirect("login.jsp");
      return;
    } else {
      PrintWriter out = resp.getWriter();
      out.println("<font color=red >Passwords do not match </font>");
      RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
      rd.include(req, resp);
      return;
    }
    
  }
  
}
