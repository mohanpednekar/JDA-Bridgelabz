package com.jda.programs.oop.classes;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jda.programs.oop.stockmarket.Stock;

public class StockPortfolio {
  
  private ArrayList<Stock> stocks = new ArrayList<>();
  
  public StockPortfolio(JSONArray stockArray) {
    for (Object stock : stockArray) {
      stocks.add(new Stock((JSONObject) stock));
    }
  }
  
  public double calculateValue() {
    return stocks.stream().mapToDouble(Stock::findValue).sum();
  }
}
