package com.jda.programs.ds;

import com.jda.util.Enums.DayOfWeek;
import com.jda.util.ds.Queue;

class WeekDay {
  
  int       date;
  DayOfWeek day;
  
  public WeekDay(int date, DayOfWeek day) {
    this.date = date;
    this.day = day;
  }
}

public class Week {
  
  Queue<WeekDay> weekdays = new Queue<>();
  DayOfWeek      startDay;
  int            startDate;
  int            endDate;
  
  public Week(DayOfWeek startDay, int startDate, int endDate) {
    this.startDay = startDay;
    this.startDate = startDate;
    this.endDate = endDate;
    for (int i = startDay.ordinal(), date = startDate; i < 7; i++) {
      if (date > endDate) { return; }
      weekdays.enqueue(new WeekDay(date++, DayOfWeek.values()[i]));
    }
  }
  
  @Override
  public String toString() {
    StringBuilder weekDates = new StringBuilder();
    for (int i = 0; i < 7; i++) {
      if (i < startDay.ordinal()) {
        weekDates.append("   ");
      } else {
        int date = weekdays.dequeue().date;
        if (date < 10) {
          weekDates.append(" ");
        }
        weekDates.append(" ").append(date);
        if (date == endDate) {
          break;
        }
      }
    }
    return weekDates.toString();
  }
}
