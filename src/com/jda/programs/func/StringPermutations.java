package com.jda.programs.func;

import java.util.HashSet;

import com.jda.util.Printer;
import com.jda.util.Reader;

public class StringPermutations {
  public static void main(String[] args) {
    Reader reader = new Reader();
    Printer.printLine("Enter a string to permute");
    String string = reader.readString();
    
    HashSet<String> iteratedPermutations = iterativelyPermute(string);
    iteratedPermutations.forEach(System.out::println);
    HashSet<String> recursivePermutations = recursivelyPermute(string);
    recursivePermutations.forEach(System.out::println);
    System.out.println("The number of recursive permutations is " + recursivePermutations.size());
  }
  
  private static HashSet<String> iterativelyPermute(String string) {
    HashSet<String> permuted = new HashSet<>();
    
    char[] letters = string.toCharArray();
    int n = string.length();
    for (int i = 0; i < n; i++) {
      
    }
    return permuted;
  }
  
  public static HashSet<String> recursivelyPermute(String string) {
    int n = string.length();
    return recursivelyPermute(string, 0, n - 1);
  }
  
  private static HashSet<String> recursivelyPermute(String string, int left, int right) {
    HashSet<String> permuted = new HashSet<>();
    if (left == right) {
      permuted.add(string);
    } else {
      swapAndRecursivelyPermute(string, left, right, permuted);
    }
    return permuted;
  }
  
  private static void swapAndRecursivelyPermute(String string, int left, int right,
      HashSet<String> permuted) {
    for (int i = left; i <= right; i++) {
      string = swapped(string, i, left);
      permuted.addAll(recursivelyPermute(string, left + 1, right));
      string = swapped(string, i, left);
    }
  }
  
  private static String swapped(String string, int i, int j) {
    char[] letters = string.toCharArray();
    char temp = letters[i];
    letters[i] = letters[j];
    letters[j] = temp;
    return String.valueOf(letters);
  }
}
