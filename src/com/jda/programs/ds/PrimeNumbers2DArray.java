package com.jda.programs.ds;

import java.util.ArrayList;
import java.util.Collection;

import com.jda.util.Maths;

public class PrimeNumbers2DArray {
  
  public static void main(String[] args) {
    ArrayList<Integer> primes = Maths.primesUpto(1000);
    
    printIntArrayExceptZeros(primes);
  }
  
  static void printIntArrayExceptZeros(Collection<Integer> primes) {
    int maxCols = findMaxCols(primes);
    int[][] numbers = generateIntArray(primes, maxCols);
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < maxCols; j++) {
        if (numbers[i][j] != 0) {
          System.out.print(numbers[i][j] + " ");
        }
      }
      System.out.println();
    }
  }
  
  static int findMaxCols(Collection<Integer> primes) {
    int[] columns = new int[10];
    for (Integer prime : primes) {
      columns[prime / 100]++;
    }
    int maxCols = 0;
    for (int i = 0; i < 10; i++) {
      maxCols = Math.max(maxCols, columns[i]);
    }
    return maxCols;
  }
  
  private static int[][] generateIntArray(Collection<Integer> primes, int maxCols) {
    int[] nCols = new int[10];
    int[][] primes2D = new int[10][maxCols];
    for (Integer prime : primes) {
      primes2D[prime / 100][nCols[prime / 100]++] = prime;
    }
    return primes2D;
  }
}
