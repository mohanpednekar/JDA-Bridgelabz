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
import com.jda.util.StringUtils;

public class PrimeAnagramsPalindromes {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int maxPrime = 1000;
    ArrayList<Integer> primes = Maths.primesUpto(maxPrime);
    primes.forEach(prime -> {
      if (StringUtils.isPalindrome(String.valueOf(prime))) {
        System.out.print(prime + " \t");
      }
    });
    System.out.println();
    for (Integer prime1 : primes)
      for (Integer prime2 : primes) {
        if (prime1 >= prime2) continue;
        if (StringUtils.areAnagrams(String.valueOf(prime1), String.valueOf(prime2)))
          System.out.print(prime1 + " and " + prime2 + " \t");
      }
  }
}
