package com.jda.programs.ds;

import com.jda.util.Reader;
import com.jda.util.ds.Deque;

public class PalindromeChecker {
  
  public static void main(String[] args) {
    System.out.println("Welcome to Palindrome checker");
    System.out.println("Enter a string");
    Reader reader = new Reader();
    String input = reader.readString();
    char[] originalChars = input.toCharArray();
    Deque<Character> characterDeque = new Deque<>();
    for (char ch : originalChars) {
      characterDeque.addRear(ch);
    }
    
    StringBuilder reversed = new StringBuilder();
    while (!characterDeque.isEmpty()) {
      char ch = characterDeque.removeRear();
      reversed.append(ch);
    }
    boolean isPalindrome = reversed.toString().equals(input);
    if (isPalindrome) {
      System.out.println("Palindrome");
    } else {
      System.out.println("Not palindrome");
    }
  }
}
