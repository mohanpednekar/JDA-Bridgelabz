package com.jda.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;

public class Printer {
  
  public static <T> void printArray(T[][] array, int rows, int columns) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print(array[i][j]);
      }
      System.out.println();
    }
  }
  
  public static void print(String string) {
    System.out.print(string);
  }
  
  public static void printLine(String string) {
    System.out.println(string);
  }
  
  public static String toString(Collection<Integer> collection) {
    StringBuilder sb = new StringBuilder();
    collection.forEach(item -> sb.append(item).append(" "));
    return sb.toString();
  }
  
  public static void printToFile(String filePath, Object object) {
    try (PrintWriter out = new PrintWriter(filePath)) {
      out.println(object);
    } catch (FileNotFoundException e) {
      System.out.println("Writing to file failed");
    }
  }
}
