package com.jda.programs.ds.classes;

import com.jda.util.Enums.TransactionType;

public class Transaction {
  
  TransactionType type;
  int             amount;
  
  public Transaction(TransactionType type, int amount) {
    this.type = type;
    this.amount = amount;
  }
  
  public int attemptWith(int balance) {
    switch (type) {
      case DEPOSIT:
        System.out.println("Depositing " + amount + " to " + balance);
        balance += amount;
        break;
      case WITHDRAW:
        System.out.println("Withdrawing " + amount + " from " + balance);
        balance -= amount;
        break;
    }
    return balance;
  }
  
  @Override
  public String toString() {
    return type + " " + amount + "\n";
  }
}
