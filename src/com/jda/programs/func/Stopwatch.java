package com.jda.programs.func;

import com.jda.util.Printer;
import com.jda.util.Reader;

public class Stopwatch {
  public static void main(String[] args) {
    Reader reader = new Reader();
    long start = System.currentTimeMillis();
    doNothing(10e7);
    long end = System.currentTimeMillis();
    Printer.printLine("Watch started at " + start);
    Printer.printLine("Watch stopped at " + end);
    Printer.printLine("The time elapsed was " + (end - start) + " ms");
  }
  
  // This function does nothing
  // Actually, it prints nothing n times
  private static void doNothing(double n) {
    for (int i = 0; i < n; i++)
      System.out.print("");
  }
}
