package com.jda.programs.ds;

import java.util.ArrayList;

import com.jda.util.Maths;
import com.jda.util.StringUtils;
import com.jda.util.ds.Stack;

public class PrimesUsingStack {
  
  public static void main(String[] args) {
    ArrayList<Integer> primes = Maths.primesUpto(1000);
    Stack<Integer> primesStack = new Stack<>();
    for (Integer prime : primes) {
      if (StringUtils.isPrimeAnagram(primes, prime)) {
        primesStack.push(prime);
      }
    }
    
    while (!primesStack.isEmpty()) {
      System.out.println(primesStack.pop());
    }
  }
}
