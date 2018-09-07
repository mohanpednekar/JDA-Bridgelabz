package com.jda.util;

import com.jda.util.Enums.CoinFace;

public class CoinFlip {
  
  private int nCoinFlips;
  
  // flips a coin n times
  public CoinFlip(int nFlips) {
    nCoinFlips = nFlips;
    for (int i = 0; i < nFlips; i++) {
      flipACoin();
    }
  }
  
  // performs a coin flip and returns the result.
  CoinFace flipACoin() {
    double randomNumber = Math.random();
    if (randomNumber < 0.5) { return CoinFace.HEAD.toss(); }
    /* else */
    return CoinFace.TAIL.toss();
  }
  
  // finds percentage of of heads out of the total coinflips
  public float percentageOfHeads() {
    float percentage = CoinFace.HEAD.frequency() / (float) nCoinFlips;
    return percentage * 100;
  }
}
