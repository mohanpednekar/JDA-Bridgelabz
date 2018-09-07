package com.jda.util;

public class Validation {
  
  // checks whether the number of arguments is n
  public static boolean checkCmdArgs(String[] args, int n) {
    if (args.length < n) {
      System.out
          .println("Too few arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
    }
    if (args.length > n) {
      System.out
          .println("Too many arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
    }
    return args.length == n;
  }
}
