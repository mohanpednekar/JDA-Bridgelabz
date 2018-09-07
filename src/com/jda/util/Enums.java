package com.jda.util;

public class Enums {
  
  public enum CardSuit {
    SPADES, CLUBS, HEARTS, DIAMONDS;
    /*
     * SPADES('???'), CLUBS('???'), HEARTS('???'), DIAMONDS('???'); char symbol;
     * CardSuit(char symbol) { this.symbol = symbol; }
     */
    public char singleChar() {
      return name().charAt(0);
    }
  }
  
  public enum CardValue {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
    
    int faceValue() {
      return ordinal() + 2;
    }
    
    public char singleChar() {
      if (faceValue() < 10) { return Character.forDigit(ordinal(), 10); }
      if (faceValue() == 10) { return 'X'; }
      return name().charAt(0);
    }
  }
  
  // defines an enum for the only two possibilities of coin faces
  enum CoinFace {
    // head and tail initialised with zero frequency
    HEAD(0), TAIL(0);
    
    // stores the frequency of the corresponding coinface
    private int count;
    
    // initialises the frequency of the coinface
    CoinFace(int n) {
      count = n;
    }
    
    // returns the frequency of the corresponding coinface
    public int frequency() {
      return count;
    }
    
    // increments the frequency of the coinface when tossed and returns its
    // own instance for further use if needed
    public CoinFace toss() {
      count++;
      return this;
    }
  }
  
  public enum DayOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    
    public String custom() {
      if (equals(THURSDAY)) { return "Th"; }
      return " " + toString().charAt(0);
    }
    
    public String threeChars() {
      return toString().substring(0, 3);
    }
  }
  
  public enum Month {
    JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31), AUGUST(
        31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);
    int nDays;
    
    Month(int nDays) {
      this.nDays = nDays;
    }
    
    public int getnDays() {
      return nDays;
    }
  }
  
  public enum Result {
    WIN, LOSS
  }
  
  public enum TemperatureUnit {
    Celsius, Fahrenheit
  }
  
  public enum TradeType {
    BUY, SELL
  }
  
  public enum TransactionType {
    DEPOSIT, WITHDRAW
  }
}
