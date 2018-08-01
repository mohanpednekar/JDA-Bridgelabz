package com.jda.clinique.util;

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
        choice = Enum.valueOf(menu, scanner.next());
      } catch (Exception e) {
        choice = null;
      }
    }
    return choice;
  }
}
