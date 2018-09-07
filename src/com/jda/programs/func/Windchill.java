/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 11, 2018
 *******************************************************************/
package com.jda.programs.func;

public class Windchill {
  
  public static void main(String[] args) {
    double t = Double.parseDouble(args[0]);
    double v = Double.parseDouble(args[1]);
    
    if (Math.abs(t) > 50) {
      System.out.println("Wind chill formula doesn't work for the given temperature");
    }
    if ((v > 120) || (v < 3)) {
      System.out.println("Wind chill formula doesn't work for the given wind velocity");
    }
    double w = windChill(t, v);
    System.out.println("The effective temperature is " + w);
  }
  
  /**
   * @param t
   *          temperature in Fahreinheit
   * @param v
   *          wind speed in miles/hour
   * @return the effective temperature due to wind chill effect
   */
  private static double windChill(double t, double v) {
    return 35.74 + (0.6215 * t) + (((0.4275 * t) - 35.75) * Math.pow(v, 0.16));
  }
  
}
