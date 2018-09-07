package com.jda.programs.oop;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.jda.programs.oop.classes.StockPortfolio;
import com.jda.util.Constants;

public class StockReport {
  
  private static String INPUT = Constants.INPUT_PATH + "stocks.json";
  
  public static void main(String[] args) {
    JSONParser parser = new JSONParser();
    try {
      JSONArray stockArray = (JSONArray) parser.parse(new FileReader(INPUT));
      StockPortfolio portfolio = new StockPortfolio(stockArray);
      System.out.println("The entire portfolio is worth " + portfolio.calculateValue());
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Something went wrong");
    }
  }
}
