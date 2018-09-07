/*******************************************************************
 * Purpose: Contains all utilities for Algorithm programs
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 *******************************************************************/
package com.jda.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import com.jda.util.Enums.CoinFace;
import com.jda.util.Enums.Result;

public class Games {
  
  public static ArrayList<Integer> notesNeededToMake(int money, HashSet<Integer> denominations) {
    TreeSet<Integer> sortedDenominations = new TreeSet<>();
    sortedDenominations.addAll(denominations);
    ArrayList<Integer> notes = new ArrayList<>();
    while (money > 0) {
      for (Integer denomination : denominations) {
        if (denomination > money) {
          sortedDenominations.remove(denomination);
        }
      }
      int currentMoney = money;
      denominations.removeIf(denomination -> denomination > currentMoney);
      int note = sortedDenominations.last();
      money -= note;
      notes.add(note);
    }
    
    return notes;
  }
  
  public static int guess(int low, int high, int n) {
    if (low == high) { return low; }
    System.out.println(n + " attemptWith" + (1 < n ? "s" : "") + " left");
    if (n == 0) { return -1; }
    int mid = (high + low) / 2;
    StringBuilder query = new StringBuilder();
    query.append("Is the number ");
    if (low != mid) {
      query.append("between ");
    }
    query.append(low);
    if (low != mid) {
      query.append(" and ").append(mid);
    }
    query.append("?");
    System.out.println(query);
    Reader reader = new Reader();
    boolean correctGuess = reader.readBoolean("y", "n");
    return correctGuess ? guess(low, mid, n - 1) : guess(mid + 1, high, n - 1);
  }
  
  /**
   * @param stake
   *          the amount at stake each day
   * @param goal
   *          the desired winning amount each day
   * @param bet
   *          the amount betted per play
   * @return whether the goal amount was won or lost
   */
  public static Result gamble(int stake, int goal, int bet) {
    int balance = stake;
    CoinFlip coinFlip = new CoinFlip(0);
    while (true) {
      if (coinFlip.flipACoin() == CoinFace.HEAD) {
        balance += bet;
      } else {
        balance -= bet;
      }
      if (balance >= goal) { return Result.WIN; }
      if (balance <= 0) { return Result.LOSS; }
    }
  }
}
