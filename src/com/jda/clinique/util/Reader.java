package com.jda.clinique.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Reader {
  private Scanner scanner;
  
  public Reader() {
    scanner = new Scanner(System.in);
  }
  
  public String requestInputLine(String prompt) {
    System.out.println(prompt);
    return scanner.nextLine();
  }

  public int requestInputInt(String prompt) {
    System.out.println(prompt);
    return scanner.nextInt();
  }
  
  public <E extends Enum<E>> E requestInputEnum(String string, Class<E> menu) {
    System.out.println(Enums.toStringAll(menu, "\t\t"));
    E choice = null;
    while (choice == null) {
      try {
        choice = Enum.valueOf(menu, scanner.next().toUpperCase());
      } catch (Exception e) {
        choice = null;
      }
    }
    return choice;
  }
  
  public Date requestInputDate(String prompt) {
    System.out.println(prompt);
    Date date;
    try {
      date = new SimpleDateFormat(Constants.DATE_FORMAT).parse(scanner.nextLine());
    } catch (ParseException e) {
      return null;
    }
    return date;
  }
  
  public long requestInputLong(String prompt) {
    System.out.println(prompt);
    return scanner.nextLong();
  }

  public boolean requestConfirmation(String prompt) {
    System.out.println(prompt);
    return scanner.next().toLowerCase().charAt(0) == 'y';
  }
}
