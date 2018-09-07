package com.jda.programs.algo;

import com.jda.util.Maths;

public class MonthlyPayment {
  
  public static void main(String[] args) {
    double p = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);
    double r = Double.parseDouble(args[2]);
    
    System.out.println("Monthly payment = " + Maths.monthlyPayment(p, y, r));
  }
}
