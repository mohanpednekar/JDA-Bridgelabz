package com.jda.util;

public class Stopwatch {
  
  private long begin;
  private long end;
  
  private long elapsedTime;
  
  public Stopwatch() {
    begin = 0;
    end = 0;
    elapsedTime = 0;
  }
  
  public double elapsedTimeSeconds() {
    return elapsedTimeNanos() * 1e-9;
  }
  
  public long elapsedTimeNanos() {
    return elapsedTime;
  }
  
  public void start() {
    begin = System.nanoTime();
  }
  
  public void stop() {
    end = System.nanoTime();
    elapsedTime = end - begin;
  }
}
