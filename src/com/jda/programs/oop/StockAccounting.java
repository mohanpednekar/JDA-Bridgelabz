package com.jda.programs.oop;

import com.jda.programs.oop.stockmarket.StockAccount;
import com.jda.programs.oop.stockmarket.StockAccount.Choice;
import com.jda.util.Constants;
import com.jda.util.StringUtils;

public class StockAccounting {
  
  private static final int LINE_LENGTH = 60;
  private static String    CUSTOMERS   = Constants.LIVE_PATH + "customers.json";
  private static String    STOCKS      = Constants.LIVE_PATH + "stocks.json";
  private static String    TRADES      = Constants.LIVE_PATH + "trades.json";
  
  public static void main(String[] args) {
    
    StockAccount stockAccount = new StockAccount(CUSTOMERS, STOCKS, TRADES);
    String inputFormat = generateInputFormat(Choice.values());
    System.out.println(inputFormat);
    stockAccount.performOperations(inputFormat);
  }
  
  private static String generateInputFormat(Choice[] choices) {
    StringBuilder format = new StringBuilder("\n");
    format.append(repeatString("=", LINE_LENGTH));
    format.append("\nWelcome to Stock market\n");
    format.append(repeatString("=", LINE_LENGTH)).append("\n");
    
    for (Choice choice : choices) {
      String readable = StringUtils.titleCase(choice.name().replaceAll("_", " "));
      format.append(readable).append("\t\t");
    }
    format.append(repeatString("=", LINE_LENGTH)).append("\n");
    return format.toString();
  }
  
  private static StringBuilder repeatString(String string, int n) {
    StringBuilder format = new StringBuilder();
    for (int i = 0; i < n; i++) {
      format.append(string);
    }
    return format;
  }
  
}
