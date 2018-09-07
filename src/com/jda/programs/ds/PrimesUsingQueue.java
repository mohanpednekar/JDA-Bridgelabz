package com.jda.programs.ds;

import java.util.ArrayList;

import com.jda.util.Maths;
import com.jda.util.StringUtils;
import com.jda.util.ds.Queue;

public class PrimesUsingQueue {
  
  public static void main(String[] args) {
    ArrayList<Integer> primes = Maths.primesUpto(1000);
    Queue<Integer> primesQueue = new Queue<>();
    for (Integer prime : primes) {
      if (StringUtils.isPrimeAnagram(primes, prime)) {
        primesQueue.enqueue(prime);
      }
    }
    
    while (!primesQueue.isEmpty()) {
      System.out.println(primesQueue.dequeue());
    }
  }
}
