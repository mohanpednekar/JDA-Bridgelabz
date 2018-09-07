package com.jda.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

import com.jda.util.Enums.TemperatureUnit;

public class Maths {
  
  /**
   * @param n
   * @return
   */
  public static int log2(int n) {
    return 32 - Integer.numberOfLeadingZeros(n);
  }
  
  public static double sqrt(double number) {
    double EPSILON = 1e-15;
    double root = number;
    do {
      root = average(number / root, root);
    } while (Math.abs(root - (number / root)) > (EPSILON * root));
    return root;
  }
  
  private static double average(double n1, double n2) {
    return (n1 + n2) / 2;
  }
  
  /**
   * @param maxPrime
   *          the limit for the largest prime number to find
   * @return list of all prime numbers upto maxPrime
   */
  public static ArrayList<Integer> primesUpto(int maxPrime) {
    ArrayList<Integer> nums = new ArrayList<>();
    for (int i = 2; i <= maxPrime; i++) {
      nums.add(i);
    }
    ArrayList<Integer> primes = new ArrayList<>();
    while (!nums.isEmpty()) {
      Integer nextPrime = nums.remove(0);
      primes.add(nextPrime);
      nums.removeIf(n -> 0 == (n % nextPrime));
    }
    return primes;
  }
  
  public static double monthlyPayment(double principal, double years, double rateOfInterest) {
    double p = principal;
    double n = 12 * years;
    double r = rateOfInterest / (12 * 100);
    return (p * r) / (1 - Math.pow(1 + r, -n));
  }
  
  public static int binaryToDecimal(String swappedNibbles) {
    int decimal = 0;
    for (char ch : swappedNibbles.toCharArray()) {
      decimal *= 2;
      if (ch == '1') {
        decimal++;
      }
    }
    return decimal;
  }
  
  public static boolean isPowerOf2(String binary) {
    String result = binary.replaceAll("0", "");
    return result.length() == 1;
  }
  
  public static String toBinary(int decimal) {
    StringBuilder binary = new StringBuilder();
    int padding = 8;
    while (0 < decimal) {
      binary.append(decimal % 2);
      decimal /= 2;
      padding--;
    }
    for (int i = 0; i < padding; i++) {
      binary.append(0);
    }
    return binary.reverse().toString();
  }
  
  public static String swapNibbles(String binary) {
    int paddingNeeded = binary.length() % 8;
    StringBuilder input = new StringBuilder();
    for (int i = 0; i < paddingNeeded; i++) {
      input.append(0);
    }
    input.append(binary);
    
    StringBuilder output = new StringBuilder();
    
    while (0 < input.length()) {
      output.append(input.substring(4, 8)).append(input.substring(0, 4));
      input.delete(0, 8);
    }
    return output.toString();
  }
  
  public static HashSet<ComplexNumber> findRoots(double a, double b, double c) {
    HashSet<ComplexNumber> roots = new HashSet<>();
    double d = discriminant(a, b, c); // or delta
    double real = -b / (2 * a);
    System.out.println(real);
    
    double img = Math.sqrt(Math.abs(d)) / (2 * a);
    System.out.println(img);
    if (d < 0) {
      roots.add(new ComplexNumber(real, img));
      roots.add(new ComplexNumber(real, -img));
    } else {
      roots.add(new ComplexNumber(real + img, 0));
      roots.add(new ComplexNumber(real - img, 0));
    }
    
    return roots;
  }
  
  private static double discriminant(double a, double b, double c) {
    return (b * b) - (4 * a * c);
  }
  
  public static double euclideanDistance(double x1, double y1, double x2, double y2) {
    double dx = x1 - x2;
    double dy = y1 - y2;
    return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
  }
  
  public static int factorial(int length) {
    if (length == 0) { return 1; }
    return length * factorial(length - 1);
  }
  
  /**
   * @param n
   *          the order of Harmonic number desired
   * @return the nth harmonic number
   */
  public static double harmonicNumber(int n) {
    
    double result = 0;
    for (int i = 1; i <= n; i++) {
      result += 1.0 / i;
    }
    return result;
  }
  
  // calculates x^n for non-negative n;
  public static int power(int x, int n) {
    int result = 1;
    for (int i = 0; i < n; i++) {
      result *= x;
    }
    return result;
  }
  
  // finds the smallest prime factor of the number n
  public static int primeFactor(int n) {
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) { return i; }
    }
    return n;
  }
  
  public static double temperatureConversion(double inputTemp, TemperatureUnit convertTo) {
    double outputTemp = Double.NaN;
    switch (convertTo) {
      case Celsius:
        outputTemp = (inputTemp - 32.0) * (5.0 / 9.0);
        break;
      case Fahrenheit:
        outputTemp = (inputTemp * (9.0 / 5.0)) + 32.0;
        break;
    }
    return outputTemp;
  }
  
  public static class ComplexNumber {
    
    double real;
    double imaginary;
    
    public ComplexNumber(double real, double imaginary) {
      this.real = real + 0.0;
      this.imaginary = imaginary;
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(real, imaginary);
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) { return true; }
      if ((o == null) || (getClass() != o.getClass())) { return false; }
      ComplexNumber that = (ComplexNumber) o;
      return (Double.compare(that.real, real) == 0)
          && (Double.compare(that.imaginary, imaginary) == 0);
    }
    
    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      if (real != 0) {
        stringBuilder.append(real);
      }
      if (imaginary != 0) {
        stringBuilder.append((imaginary > 0) ? " + " : " - ").append(Math.abs(imaginary))
            .append("i");
      }
      if (stringBuilder.length() == 0) {
        stringBuilder.append(0);
      }
      return stringBuilder.toString();
    }
  }
}
