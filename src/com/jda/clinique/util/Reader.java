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
    try {
      return Enum.valueOf(menu, scanner.next().toUpperCase());
    } catch (Exception ignored) {}
    return null;
  }
  
  public Date requestInputDate(String prompt) {
    System.out.println(prompt);
    scanner.nextLine();
    String inputDate = scanner.nextLine();
    // System.out.println("**" + inputDate + "**");
    try {
      return new SimpleDateFormat(Constants.DATE_FORMAT).parse(inputDate);
    } catch (ParseException ignored) {}
    return null;
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
