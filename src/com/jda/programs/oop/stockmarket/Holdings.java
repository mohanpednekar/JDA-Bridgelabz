package com.jda.programs.oop.stockmarket;

import java.util.ArrayList;

public class Holdings {
  ArrayList<Stock> data = new ArrayList<>();
  
  boolean have(double shares, Stock stockToSell) {
    for (Stock stock : data) {
      if (stock.is(stockToSell.getId()) && stock.has(shares)) { return true; }
    }
    return false;
  }

  Stock find(String id) {
    for (Stock item : data) {
      if (item.is(id)) { return item; }
    }
    return null;
  }

  public void purchase(Stock stock) {
    if (find(stock.getId()) == null) {
      data.add(stock);
    } else {
      find(stock.getId()).increase(stock.findValue());
    }
  }
  
  public void remove(Stock stock) {
    data.remove(stock);
  }

  boolean soldAll(Stock stock) {
    return data.stream().anyMatch(holding -> holding.is(stock.getId()) && holding.reduce(stock));
  }

  void showAll() {
    data.forEach(System.out::println);
  }
  
  public boolean isEmpty() {
    return (data == null) || data.isEmpty();
  }
}
