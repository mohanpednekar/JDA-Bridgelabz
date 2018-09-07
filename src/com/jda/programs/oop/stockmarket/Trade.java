package com.jda.programs.oop.stockmarket;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jda.util.Enums.TradeType;
import com.jda.util.Reader;

public class Trade extends JsonIdHolder<Long> {
  
  private long      customerId;
  private String    symbol;
  private TradeType tradeType;
  private double    amount;
  private double    shares;
  private long      timestamp;
  
  Trade(Reader reader, TradeType tradeType) {
    System.out.println("Enter customer id, stock symbol and amount of money (separated by spaces)");
    customerId = reader.readLong();
    symbol = reader.readString();
    this.tradeType = tradeType;
    amount = reader.readDouble();
    timestamp = System.currentTimeMillis();
  }
  
  @Override
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  @Override
  public String toString() {
    return "T[id=" + id + ", cId=" + customerId + ", " + symbol + ", " + tradeType + ", amt="
        + amount + ", shares=" + ((int) (100 * shares) / 100.0) + ", time="
        + new SimpleDateFormat("HH:mm:ss").format(new Date(timestamp)) + "]";
  }
  
  Stock findStock(Stocks stocks) {
    Stock stock = stocks.find(symbol);
    if (stock != null) {
      if (tradeType == TradeType.SELL) {
        return stock;
      } else if (stock.isWorth(amount)) { return stock; }
    }
    return null;
  }
  
  Customer findCustomer(Customers customers, Stock stock) {
    Customer customer = customers.find(customerId);
    if (customer == null) {
      System.out.println("Customer not found.");
      return null;
    }
    switch (tradeType) {
      case BUY:
        if (customer.canAfford(amount)) {
          return customer;
        } else {
          System.out.println("Insufficient balance");
        }
        break;
      case SELL:
        if (customer.has(shares, stock)) {
          return customer;
        } else {
          System.out.println("Insufficient shares");
        }
    }
    return null;
  }
  
  void commit(Long ref, Customer customer, Stock stock) {
    id = ref;
    shares = stock.worth(amount);
    switch (tradeType) {
      case BUY:
        customer.buy(new Stock(stock, amount));
        stock.reduce(amount);
        break;
      case SELL:
        customer.sell(new Stock(stock, amount));
        stock.increase(amount);
        break;
    }
  }
  
  public boolean has(Stock stock) {
    if (stock == null) { return true; }
    return stock.is(symbol);
  }
  
  public boolean has(Customer customer) {
    if (customer == null) { return true; }
    return customer.is(customerId);
  }
}
