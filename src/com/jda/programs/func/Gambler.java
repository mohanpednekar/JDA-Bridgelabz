
package com.jda.programs.func;

import com.jda.util.Enums.Result;
import com.jda.util.Games;
import com.jda.util.Printer;
import com.jda.util.Reader;

public class Gambler {
  
  public static void main(String[] args) {
    Reader reader = new Reader();
    Printer.printLine("Welcome to Casino Royale!");
    Printer.printLine("How much do you want to stake each day?");
    int stake = reader.readInteger();
    Printer.printLine("How much do you want to win each day?");
    int goal = reader.readInteger();
    Printer.printLine("How many times do you want to gamble?");
    int attempts = reader.readInteger();
    
    int bet = 1; // bet is $1 per play
    int wins = 0; // number of winning days
    int losses = 0; // number of losing days
    
    // attemptWith the gambling game for given number of days
    for (int i = 0; i < attempts; i++) {
      if (Games.gamble(stake, goal, bet) == Result.WIN) {
        wins++;
      } else {
        losses++;
      }
    }
    
    Printer.printLine("You won " + wins + " times and lost " + losses + " times");
    Printer.printLine("You won " + wins * 100.0 / attempts + "% times");
  }
}
