package com.jda.util;

import java.util.Scanner;

public class Reader {
  Scanner scanner = new Scanner(System.in);
  
  public String readLine() {
    return scanner.nextLine();
  }

  public String readString() {
    return scanner.next();
  }
  
  public String requestLine(String prompt) {
    System.out.println(prompt + " : ");
    String inputLine = readLine();
    return inputLine;
  }
  
  public String requestUpdate(String field, String currentInfo) {
    System.out.println("Current " + field + " : " + currentInfo);
    String data = requestLine("New " + field);
    return data.equals("x") ? currentInfo : data;
  }
  
  public boolean seekConfirmation(String prompt) {
    return requestLine(prompt).toLowerCase().charAt(0) == 'y';
  }
}
