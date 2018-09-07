package com.jda.programs.oop.stockmarket;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.util.Reader;

class Trades extends JsonArrayList<Trade, Long> {

  Trades(Gson gson, String file) {
    super(gson, file);
    ArrayList<Trade> tradesArray = Reader.readArrayListFromFile(gson,
        new TypeToken<ArrayList<Trade>>() {}.getType(), file);
    tradesArray.forEach(data::add);
    maxId = findHighestId();
  }
  
  void commit(Trade trade, Customer customer, Stock stock) {
    maxId += 1;
    trade.commit(maxId, customer, stock);
    data.add(trade);
  }
  
  public void filter(Customer customer, Stock stock) {
    for (Trade trade : data) {
      if (trade.has(customer) && trade.has(stock)) {
        System.out.println(trade);
      }
    }
  }
}
