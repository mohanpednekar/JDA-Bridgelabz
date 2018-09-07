package com.jda.programs.oop.stockmarket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jda.util.Enums.TradeType;
import com.jda.util.Reader;

public class StockAccount {

  private Trades    trades;
  private Customers customers;
  private Stocks    stocks;

  public StockAccount(String customersFile, String stocksFile, String tradesFile) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    customers = new Customers(gson, customersFile);
    trades = new Trades(gson, tradesFile);
    stocks = new Stocks(gson, stocksFile);
  }

  public void performOperations(String inputFormat) {

    Reader reader = new Reader();
    boolean stillWorking = true;
    while (stillWorking) {
      switch (getChoice(reader)) {

        case BUY:
          Trade buyTrade = new Trade(reader, TradeType.BUY);
          Stock boughtStock = buyTrade.findStock(stocks);
          Customer buyer = buyTrade.findCustomer(customers, boughtStock);
          if ((buyer != null) && (boughtStock != null)) {
            trades.commit(buyTrade, buyer, boughtStock);
            writeToJson();
          }
          break;
        case SELL:
          Trade sellTrade = new Trade(reader, TradeType.SELL);
          Stock soldStock = sellTrade.findStock(stocks);
          Customer seller = sellTrade.findCustomer(customers, soldStock);
          if ((seller != null) && (soldStock != null)) {
            trades.commit(sellTrade, seller, soldStock);
            writeToJson();
          }
          break;
        case SHOW_CUSTOMER:
          System.out.println("Enter customer id");
          Long id = reader.readLong();
          customers.display(reader, id);
          break;
        case SHOW_ALL_CUSTOMERS:
          customers.showAll();
          break;
        case SHOW_HOLDINGS:
          System.out.println("Enter customer id");
          Customer customerH = customers.find(reader.readLong());
          customerH.showHoldings();
          break;
        case SHOW_TRADES:
          System.out.println("Enter customer id to filter. (0 to skip)");
          Customer customerT = customers.find(reader.readLong());
          System.out.println("Enter stock symbol to filter. (x to skip)");
          Stock stockT = stocks.find(reader.readString());
          trades.filter(customerT, stockT);
          break;
        case SHOW_STOCK:
          System.out.println("Enter stock symbol");
          String symbol = reader.readString();
          stocks.display(reader, symbol);
          break;
        case SHOW_ALL_STOCKS:
          stocks.showAll();
          break;
        case SHOW_TRADE:
          System.out.println("Enter trade reference");
          long ref = reader.readLong();
          trades.display(reader, ref);
          break;
        case SHOW_ALL_TRADES:
          trades.showAll();
          break;
        case SHOW_ALL:
          customers.showAll();
          stocks.showAll();
          trades.showAll();
          break;
        case ADD_STOCK:
          Stock newStock = new Stock(reader);
          if (stocks.add(newStock)) {
            stocks.printToFile();
          }
          break;
        case REMOVE_STOCK:
          System.out.println("Enter stock symbol");
          String symbolToRemove = reader.readString();
          if (stocks.remove(symbolToRemove)) {
            stocks.printToFile();
          }
          break;
        case ADD_CUSTOMER:
          Customer newCustomer = new Customer(reader);
          customers.add(newCustomer);
          customers.printToFile();
          break;
        case REMOVE_CUSTOMER:
          System.out.println("Enter customer id");
          Long customerToRemove = reader.readLong();
          if (customers.remove(customerToRemove)) {
            customers.printToFile();
          }
          break;
        case QUIT:
          stillWorking = false;
          System.out.println("Bye!");
          break;
        case HELP:
          System.out.println(inputFormat);
          break;
      }
    }
  }

  private Choice getChoice(Reader reader) {
    Choice choice;
    try {
      choice = Choice.valueOf(reader.readLine().trim().toUpperCase().replaceAll(" ", "_"));
    } catch (Exception e) {
      return Choice.HELP;
    }
    return choice;
  }

  private void writeToJson() {
    customers.printToFile();
    trades.printToFile();
    stocks.printToFile();
  }

  public enum Choice {
    BUY, SELL, SHOW_CUSTOMER, SHOW_STOCK, SHOW_TRADE, SHOW_ALL_CUSTOMERS, SHOW_HOLDINGS, SHOW_TRADES, SHOW_ALL_STOCKS, SHOW_ALL_TRADES, SHOW_ALL, ADD_STOCK, REMOVE_STOCK, ADD_CUSTOMER, REMOVE_CUSTOMER, QUIT, HELP
  }
}
