package com.jda.programs.oop.stockmarket;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.util.Reader;

public class Customers extends JsonArrayList<Customer, Long> {
  
  Customers(Gson gson, String customersFile) {
    super(gson, customersFile);
    data = Reader.readArrayListFromFile(gson, new TypeToken<ArrayList<Customer>>() {}.getType(),
        customersFile);
    maxId = findHighestId();
  }
  
  public void add(Customer newCustomer) {
    maxId += 1;
    newCustomer.setId(maxId);
    data.add(newCustomer);
  }
}
