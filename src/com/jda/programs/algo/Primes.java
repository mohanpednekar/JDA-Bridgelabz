/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 *******************************************************************/
package com.jda.programs.algo;

import java.util.ArrayList;

import com.jda.util.Maths;

public class Primes {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    int maxPrime = 1000;
    ArrayList<Integer> primes = Maths.primesUpto(maxPrime);
    primes.forEach(System.out::println);
  }
}
