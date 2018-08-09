package com.jda.dynamic;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CongratsServlet extends GenericServlet {
  
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
    // TODO Auto-generated method stub
    System.out.println("Congratulations " + arg0.getParameter("name") + "! Your account is being created.");

  }

}
