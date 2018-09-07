package com.jda.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class Reader {

  public Reader() {
    scanner = new Scanner(System.in);
  }

  private Scanner scanner;

  public static <T> ArrayList<T> readArrayListFromFile(Gson gson, Type type, String file) {
    java.io.Reader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
    } catch (FileNotFoundException e) {
      System.out.println("File not Found");
    }
    return gson.fromJson(reader, type);
  }

  public boolean readBoolean(String positive, String negative) {
    return scanner.next().toLowerCase().startsWith(positive);
  }

  public double readDouble() {
    return scanner.nextDouble();
  }

  // reads an integer from input stream
  public int readInteger() {
    return scanner.nextInt();
  }

  public int[] readIntegerArray(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = scanner.nextInt();
    }
    return array;
  }

  public int[][] readIntegerArray(int rows, int columns) {
    int[][] array = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        array[i][j] = scanner.nextInt();
      }
    }
    return array;
  }

  public String readLine() {
    return scanner.nextLine();
  }

  public long readLong() {
    return Long.parseLong(scanner.next());
  }

  // reads a string from input stream delimited by any whitespace
  public String readString() {
    return scanner.next();
  }
}
