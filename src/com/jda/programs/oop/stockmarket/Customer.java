package com.jda.programs.oop.stockmarket;

import com.jda.util.Reader;

public class Customer extends JsonIdHolder<Long> {

  private String   name;
  private String   surname;
  private long     mobile;
  private double   balance;
  private Holdings holdings;

  Customer(Reader reader) {
    System.out.println("Enter name, surname, mobile number and balance");
    name = reader.readString();
    surname = reader.readString();
    mobile = reader.readLong();
    balance = reader.readDouble();
    holdings = new Holdings();
  }

  @Override
  public Long getId() {
    return id;
  }

  void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "C{" + "id=" + id + ", '" + name + " " + surname + ", " + mobile + ", bal=" + balance
        + '}';
  }

  boolean has(double shares, Stock stockToSell) {
    if (holdings.isEmpty()) { return false; }
    return holdings.have(shares, stockToSell);
  }

  boolean canAfford(double amount) {
    return balance >= amount;
  }

  void buy(Stock stock) {
    if (holdings == null) {
      holdings = new Holdings();
    }
    holdings.purchase(stock);
    balance -= stock.findValue();
  }

  void sell(Stock stock) {
    if (holdings.soldAll(stock)) {
      holdings.remove(stock);
      balance += stock.findValue();
    }
  }

  public void showHoldings() {
    holdings.showAll();
  }
}
