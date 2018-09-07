package com.jda.programs.algo;

import java.util.ArrayList;
import java.util.HashSet;

import com.jda.util.Games;
import com.jda.util.Printer;
import com.jda.util.Reader;

public class VendingMachine {
  
  public static void main(String[] args) {
    Reader reader = new Reader();
    System.out.println("Enter the denominations available in your currency followed by 0");
    HashSet<Integer> denominations = new HashSet<>();
    while (true) {
      int denomination = reader.readInteger();
      if (denomination == 0) {
        break;
      }
      denominations.add(denomination);
    }
    System.out.println("Enter the amount you want to be disbursed");
    int amount = reader.readInteger();
    
    ArrayList<Integer> notes = Games.notesNeededToMake(amount, denominations);
    System.out.println("Your notes are");
    System.out.println(Printer.toString(notes));
  }
}
