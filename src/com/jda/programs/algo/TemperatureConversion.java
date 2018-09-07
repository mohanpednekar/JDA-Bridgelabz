package com.jda.programs.algo;

import com.jda.util.Enums.TemperatureUnit;
import com.jda.util.Maths;
import com.jda.util.Reader;

public class TemperatureConversion {
  
  public static void main(String[] args) {
    Reader reader = new Reader();
    
    System.out.println("Let's convert temperature");
    
    System.out.println("Enter temperature in degree Celcius");
    double tempCelcius1 = reader.readDouble();
    double tempFahrenheit1 = Maths.temperatureConversion(tempCelcius1, TemperatureUnit.Fahrenheit);
    System.out.println("The temperature in degree Fahrenheit is " + tempFahrenheit1);
    
    System.out.println("\nEnter temperature in degree Fahrenheit");
    double tempFaahrenheit2 = reader.readDouble();
    double tempCelcius2 = Maths.temperatureConversion(tempFaahrenheit2, TemperatureUnit.Celsius);
    System.out.println("The temperature in degree Celcius is " + tempCelcius2);
  }
}
