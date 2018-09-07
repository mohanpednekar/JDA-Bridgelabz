package com.jda.programs.ds;

public class Calendar2 {
  
  public static void main(String[] args) {
    int month = Integer.parseInt(args[0]);
    int year = Integer.parseInt(args[1]);
    
    Calendar calendar = new Calendar(month, year);
    calendar.fillUsingQueue();
    calendar.displayUsingQueue();
  }
}
