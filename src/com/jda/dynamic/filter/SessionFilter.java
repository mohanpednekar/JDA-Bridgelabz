package com.jda.dynamic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {
  
  @Override
  public void destroy() {}

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;
    String url = request.getServletPath();
    System.out.println(url);
    if (!url.equals("/login.jsp")) {
      HttpSession session = request.getSession(false);
      if (null == session) {
        System.out.println("Inside Filter, session does not exist");
        response.sendRedirect("login.jsp");
        return;
      }
    }
    chain.doFilter(req, resp);
  }
}
