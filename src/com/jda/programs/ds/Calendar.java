package com.jda.programs.ds;

import com.jda.util.Enums.DayOfWeek;
import com.jda.util.Enums.Month;
import com.jda.util.ds.Squeue;

public class Calendar {
  
  Month     month;
  int       year;
  int       nDays;
  DayOfWeek startDay;
  
  Squeue<Week> weeks = new Squeue<>();
  
  public Calendar(int mm, int yyyy) {
    month = Month.values()[mm - 1];
    year = yyyy;
    nDays = month.getnDays();
    if (month.equals(Month.FEBRUARY) && com.jda.util.Calendar.isLeapYear(year)) {
      nDays = 29;
    }
    startDay = com.jda.util.Calendar.dayOfWeek(month, 1, year);
  }
  
  public static void main(String[] args) {
    int month = Integer.parseInt(args[0]);
    int year = Integer.parseInt(args[1]);
    
    Calendar calendar = new Calendar(month, year);
    System.out.println(calendar);
  }
  
  @Override
  public String toString() {
    StringBuilder calendarPage = new StringBuilder();
    StringBuilder header = generateHeader();
    StringBuilder monthPage = generateMonthPage();
    return calendarPage.append(header).append(monthPage).toString();
  }
  
  private StringBuilder generateHeader() {
    StringBuilder header = new StringBuilder();
    header.append("  ").append(month).append(" ").append(year).append("\n");
    for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
      header.append(" ").append(dayOfWeek.custom());
    }
    return header;
  }
  
  private StringBuilder generateMonthPage() {
    StringBuilder monthPage = new StringBuilder();
    int[][] dates = fillDates();
    for (int i = 0; i < 6; i++) {
      monthPage.append("\n");
      for (int j = 0; j < 7; j++) {
        int date = dates[i][j];
        monthPage.append(" ");
        if (date == 0) {
          if (i > 0) { return monthPage; }
          monthPage.append("  ");
        } else {
          if (date < 10) {
            monthPage.append(" ");
          }
          monthPage.append(date);
        }
      }
    }
    return monthPage;
  }
  
  public int[][] fillDates() {
    int[][] dates = new int[6][7];
    int date = 1;
    for (int i = startDay.ordinal(); date <= nDays; date++, i++) {
      dates[i / 7][i % 7] = date;
    }
    return dates;
  }
  
  public void fillUsingQueue() {
    int endDate = 7 - startDay.ordinal();
    weeks.enqueue(new Week(startDay, 1, endDate));
    while (endDate < nDays) {
      int startDate = endDate + 1;
      endDate += 7;
      if (endDate > nDays) {
        endDate = nDays;
      }
      weeks.enqueue(new Week(DayOfWeek.SUNDAY, startDate, endDate));
    }
  }
  
  public void displayUsingQueue() {
    while (!weeks.isEmpty()) {
      System.out.println(weeks.dequeue());
    }
  }
}
