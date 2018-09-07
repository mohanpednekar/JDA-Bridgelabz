/*******************************************************************
 * Purpose: To find prime factors of a number
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 5, 2018
 *******************************************************************/
package com.jda.programs.func;

import java.util.ArrayList;

import com.jda.util.Maths;
import com.jda.util.Printer;
import com.jda.util.Reader;

public class Factors {
  
  public static void main(String[] args) {
    Reader reader = new Reader();
    Printer.printLine("Enter a number to factorise");
    int n = reader.readInteger();
    
    ArrayList<Integer> factors = new ArrayList<>();
    int temp = n;
    while (temp > 1) {
      int f = Maths.primeFactor(temp);
      factors.add(f);
      temp = temp / f;
    }
    
    Printer.printLine("The prime factors of " + n + " are " + Printer.toString(factors));
  }
}
