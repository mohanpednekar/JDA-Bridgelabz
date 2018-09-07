package com.jda.programs.ds;

import java.util.ArrayList;
import java.util.Collections;

import com.jda.util.Reader;

public class NumberOfBST {
  
  static long MOD = 100000007;
  
  public static void main(String[] args) {
    Reader reader = new Reader();
    int T = reader.readInteger();
    ArrayList<Integer> testCases = new ArrayList<>();
    for (int i = 0; i < T; i++) {
      testCases.add(reader.readInteger());
    }
    int max = Collections.max(testCases);
    long[] nBST = new long[max + 1];
    nBST[0] = 1;
    for (int i = 1; i <= max; i++) {
      for (int j = 0; j < i; j++) {
        nBST[i] = (nBST[i] + ((nBST[j] * nBST[i - 1 - j]) % MOD)) % MOD;
      }
    }
    for (Integer testCase : testCases) {
      System.out.println(nBST[testCase]);
    }
  }
}
