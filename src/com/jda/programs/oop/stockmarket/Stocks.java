package com.jda.programs.oop.stockmarket;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.util.Reader;

public class Stocks extends JsonArrayList<Stock, String> {

  Stocks(Gson gson, String file) {
    super(gson, file);
    ArrayList<Stock> stocksArray = Reader.readArrayListFromFile(gson,
        new TypeToken<ArrayList<Stock>>() {}.getType(), file);
    stocksArray.forEach(data::add);
  }

  Stocks() {}
  
  public boolean add(Stock stock) {
    if (find(stock.getId()) == null) {
      data.add(stock);
      return true;
    } else {
      System.out.println("Stock symbol already exists");
    }
    return false;
  }
  
}
