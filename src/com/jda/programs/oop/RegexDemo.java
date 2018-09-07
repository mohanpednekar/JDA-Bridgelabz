package com.jda.programs.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.jda.util.Constants;

public class RegexDemo {
  
  private static String INPUT = Constants.INPUT_PATH + "RegexMessage.txt";
  
  public static void main(String[] args) {
    String message = null;
    
    try {
      message = new String(Files.readAllBytes(Paths.get(INPUT)));
    } catch (IOException e) {
      System.out.println("Something went wrong");
    }
    
    if (message == null) { return; }
    
    System.out.println(message);
    
    String fullName = "Mohan Pednekar";
    long number = 8767337673L;
    String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    String result = message.replaceAll(Regex.NAME.toString(), fullName.split("\\s")[0])
        .replaceAll(Regex.FULL_NAME.toString(), fullName)
        .replaceAll(Regex.CONTACT_NUMBER.toString(), "91-" + number)
        .replaceAll(Regex.DATE.toString(), date);
    System.out.println(result);
  }
  
  enum Regex {
    NAME("<<[a-z]{4}>>"), FULL_NAME("<<[a-z ]{9}>>"), CONTACT_NUMBER("91-[x]{10}"), DATE(
        "\\d{2}\\/\\d{2}\\/\\d{4}");
    
    private String regex;
    
    Regex(String regex) {
      this.regex = regex;
    }
    
    @Override
    public String toString() {
      return regex;
    }
  }
}
