package com.jda.programs.func;

import com.jda.util.Printer;
import com.jda.util.Reader;

public class Array2D {
  
  public static void main(String[] args) {
    Reader reader = new Reader();
    Printer.printLine("Let's create a 2D array.");
    Printer.printLine("Enter the number of rows");
    int rows = reader.readInteger();
    Printer.printLine("Enter the number of columns.");
    int columns = reader.readInteger();
    
    Printer.printLine("Enter the array");
    int[][] array = reader.readIntegerArray(rows, columns);
    Integer[][] objArray = getIntegers(rows, columns, array);
    Printer.printLine("The array you input is as follows.");
    Printer.printArray(objArray, rows, columns);
  }
  
  private static Integer[][] getIntegers(int rows, int columns, int[][] array) {
    Integer[][] objArray = new Integer[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        objArray[i][j] = array[i][j];
      }
    }
    return objArray;
  }
}
