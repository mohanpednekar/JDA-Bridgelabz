package com.jda.programs.oop.stockmarket;

import org.json.simple.JSONObject;

import com.jda.util.Reader;

public class Stock extends JsonIdHolder<String> {
  
  private String name;
  private double shares;
  private double price;
  
  Stock(Reader reader) {
    System.out.println("Enter name");
    name = reader.readLine();
    System.out.println("Enter symbol, price and number of shares (separated by spaces)");
    id = reader.readString();
    price = reader.readDouble();
    shares = reader.readDouble();
  }
  
  Stock(Stock stock, double amount) {
    name = stock.name;
    id = stock.id;
    price = stock.price;
    shares = amount / price;
  }
  
  public Stock(JSONObject stock) {
    name = (String) stock.get("name");
    shares = (double) stock.get("number");
    price = (double) stock.get("price");
  }
  
  @Override
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  @Override
  public String toString() {
    return "S [id=" + id + ", " + name + ", number=" + shares + ", price=" + price + "]";
  }
  
  boolean isWorth(double amount) {
    return findValue() >= amount;
  }
  
  public double findValue() {
    return shares * price;
  }
  
  boolean has(double shares) {
    return this.shares > shares;
  }
  
  boolean reduce(Stock stock) {
    shares -= stock.shares;
    return shares <= 1e-9;
  }
  
  void reduce(double amount) {
    shares -= amount / price;
  }
  
  void increase(double amount) {
    shares += amount / price;
  }
  
  double worth(double amount) {
    return amount / price;
  }
}
