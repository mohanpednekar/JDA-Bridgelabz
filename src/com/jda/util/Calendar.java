package com.jda.util;

import com.jda.util.Enums.DayOfWeek;
import com.jda.util.Enums.Month;

public class Calendar {
  
  public static DayOfWeek dayOfWeek(Month month, int d, int y) {
    int m = month.ordinal() + 1;
    int y0 = y - ((14 - m) / 12);
    int x = ((y0 + (y0 / 4)) - (y0 / 100)) + (y0 / 400);
    int m0 = (m + (12 * ((14 - m) / 12))) - 2;
    int d0 = (d + x + ((31 * m0) / 12)) % 7;
    return DayOfWeek.values()[d0];
  }
  
  // checks whether the year provided is leap year or not
  public static boolean isLeapYear(int year) {
    if (year % 4 != 0) { return false; // year not divisible by 4 is not leap
    }
    if (year % 400 == 0) { return true; // year divisible by 400 is leap
    }
    return year % 100 != 0;
  }
}
