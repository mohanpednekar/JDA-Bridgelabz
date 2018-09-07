package com.jda.programs.oop.classes;

import org.json.simple.JSONObject;

import com.jda.util.Reader;

public class Product {
  
  private String name;
  private long   weight;
  private long   priceperkg;
  
  public Product(JSONObject jsonObject) {
    name = (String) jsonObject.get("name");
    weight = (long) jsonObject.get("weight");
    priceperkg = (long) jsonObject.get("priceperkg");
  }
  
  public Product(Reader reader) {
    System.out.println("Enter name");
    name = reader.readLine();
    System.out.println("Enter weight");
    weight = reader.readLong();
    System.out.println("Enter price per kg");
    priceperkg = reader.readLong();
  }
  
  public String getName() {
    return name;
  }
  
  @Override
  public String toString() {
    return "{" + "\"name\" : \"" + name + '\"' + ", \"weight\" : " + weight + ", \"priceperkg\" : "
        + priceperkg + '}';
  }
  
  public long findValue() {
    return weight * priceperkg;
  }
}
