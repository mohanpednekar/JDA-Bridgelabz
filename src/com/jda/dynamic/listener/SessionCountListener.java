package com.jda.dynamic.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCountListener implements HttpSessionListener {
  public static int sessionCount = 0;
  
  public static int getSessionCount() {
    return sessionCount;
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    sessionCount++;
    System.out.println("Created. Active sessions = " + sessionCount);
  }
  
  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    sessionCount--;
    System.out.println("Destroyed. Active sessions = " + sessionCount);
  }

}
