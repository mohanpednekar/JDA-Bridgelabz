package com.jda.programs.algo;

import com.jda.util.Calendar;
import com.jda.util.Enums.Month;
import com.jda.util.Reader;

public class DayOfWeek {
  
  public static void main(String[] args) {
    System.out.println("Enter date in \"mm dd yyyy\" format");
    Reader reader = new Reader();
    int mm = reader.readInteger();
    int dd = reader.readInteger();
    int yyyy = reader.readInteger();
    System.out.println(Calendar.dayOfWeek(Month.values()[mm - 1], dd, yyyy));
  }
}
