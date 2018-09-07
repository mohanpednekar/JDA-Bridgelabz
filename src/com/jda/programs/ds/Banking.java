package com.jda.programs.ds;

import com.jda.programs.ds.classes.Transaction;
import com.jda.util.Enums.TransactionType;
import com.jda.util.Reader;
import com.jda.util.ds.Queue;

public class Banking {
  
  public static void main(String[] args) {
    System.out.println("Welcome to JDA Bank");
    int balance = 100000;
    System.out.println("The balance at day opening is " + balance);
    StringBuilder inputFormat = new StringBuilder();
    
    inputFormat.append("Enter people in the following format:").append("\n");
    inputFormat.append("\td <<amount>> for deposit").append("\n");
    inputFormat.append("\tw <<amount>> for withdrawal").append("\n");
    inputFormat.append("Enter p to attemptWith next transaction").append("\n");
    inputFormat.append("Enter q to quit");
    System.out.println(inputFormat);
    
    Queue<Transaction> peopleQueue = new Queue<>();
    
    Reader reader = new Reader();
    while (true) {
      switch (reader.readString().charAt(0)) {
        case 'd':
          int depositAmount = reader.readInteger();
          peopleQueue.enqueue(new Transaction(TransactionType.DEPOSIT, depositAmount));
          break;
        case 'w':
          int withdrawalAmount = reader.readInteger();
          peopleQueue.enqueue(new Transaction(TransactionType.WITHDRAW, withdrawalAmount));
          break;
        case 'p':
          if (peopleQueue.isEmpty()) {
            System.out.println("Please wait for more customers");
            break;
          }
          Transaction transaction = peopleQueue.dequeue();
          int newBalance = transaction.attemptWith(balance);
          if (newBalance >= 0) {
            balance = newBalance;
          } else {
            reportLowBalance();
          }
          System.out.println("The current balance is " + balance);
          System.out.println("The current queue is");
          System.out.println(peopleQueue);
          break;
        case 'q':
          System.out.println("Lunch time! Bye.");
          return;
        default:
          System.out.println(inputFormat);
      }
    }
  }
  
  private static void reportLowBalance() {
    System.out.println("Sorry, we don't have sufficient balance");
  }
}
