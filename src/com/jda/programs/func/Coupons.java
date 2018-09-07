package com.jda.programs.func;

import java.util.HashSet;
import java.util.Random;

import com.jda.util.Printer;
import com.jda.util.Reader;

public class Coupons {
  
  public static void main(String[] args) {
    int MAX_COUPONS;
    
    Reader reader = new Reader();
    Printer.printLine("Welcome to Lotto mania!");
    
    Printer.printLine("How many coupons do you want to generate?");
    int nCoupons = reader.readInteger();
    MAX_COUPONS = nCoupons;
    HashSet<Integer> couponSet = new HashSet<>();
    while (couponSet.size() < nCoupons) {
      couponSet.add(randomNumber(MAX_COUPONS));
    }
    
    Printer.printLine("Your coupons are " + Printer.toString(couponSet));
    
    int attempts = attemptsToProcessDistinctCoupons(couponSet, MAX_COUPONS);
    
    Printer.printLine("All coupons generated in " + attempts + " attempts.");
  }
  
  private static Integer randomNumber(int maxCoupons) {
    Random random = new Random();
    return random.nextInt(maxCoupons);
  }
  
  /**
   * @param couponSet
   *          the original set of coupons targeted
   * @param max_coupons
   *          maximum number of coupons
   * @return the number of attempts made to generate all the target coupons
   */
  private static int attemptsToProcessDistinctCoupons(HashSet<Integer> couponSet, int max_coupons) {
    HashSet<Integer> candidateLot = new HashSet<>();
    int attempts = 0;
    while (!candidateLot.containsAll(couponSet)) {
      candidateLot.add(randomNumber(max_coupons));
      attempts++;
    }
    return attempts;
  }
}
