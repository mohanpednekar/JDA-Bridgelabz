package com.jda.programs.func;

import java.util.HashSet;

import com.jda.util.Maths;
import com.jda.util.Maths.ComplexNumber;
import com.jda.util.Reader;

public class Quadratic {
  
  public static void main(String[] args) {
    System.out.println("Let's find the roots of a Quadratic equation a*x*x + b*x + c = 0");
    Reader reader = new Reader();
    System.out.println("Please enter a b c");
    double a = reader.readDouble();
    double b = reader.readDouble();
    double c = reader.readDouble();
    HashSet<ComplexNumber> roots = Maths.findRoots(a, b, c);
    System.out.println((roots.size() > 1) ? "The roots are " : "The root is ");
    roots.forEach(System.out::println);
  }
}
