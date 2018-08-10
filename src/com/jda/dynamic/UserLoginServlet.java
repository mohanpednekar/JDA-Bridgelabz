package com.jda.dynamic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jda.dynamic.model.User;
import com.jda.dynamic.repository.UserRepository;
import com.jda.dynamic.repository.UserRepositoryImpl;

public class UserLoginServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  UserRepository            repo             = new UserRepositoryImpl();
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user = new User();
    String username = req.getParameter("username");
    String pass = req.getParameter("password");
    boolean withEmail;
    if (username.matches("[0-9]+")) {
      user.setPhone(username);
      withEmail = false;
    } else {
      user.setEmail(username);
      withEmail = true;
    }

    if (repo.exists(user, withEmail)) {
      HttpSession session = req.getSession();
      session.setAttribute("user.name", user.getName());
      session.setAttribute("user.email", user.getEmail());
      session.setAttribute("user.phone", user.getPhone());
      resp.sendRedirect("welcome.html");
      return;
    } else {
      PrintWriter out = resp.getWriter();
      out.println("<font color=red>Failed to Login</font>");
      RequestDispatcher rd = req.getRequestDispatcher("login.html");
      rd.include(req, resp);
      return;
    }
  }
  
}
