/*******************************************************************
 * Purpose: Find the Nth harmonic number;
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 5, 2018
 *******************************************************************/

package com.jda.programs.func;

import com.jda.util.Maths;
import com.jda.util.Printer;
import com.jda.util.Reader;
import com.jda.util.StringUtils;

public class HarmonicNumber {
  
  public static void main(String[] args) {
    Reader reader = new Reader();
    Printer.printLine("Which harmonic number do you wath to find?");
    int n = reader.readInteger();
    if (n < 1) {
      Printer.printLine("Enter a positive number");
    }
    double result = Maths.harmonicNumber(n);
    Printer.printLine("The " + StringUtils.ordinal(n) + " harmonic number is " + result);
  }
}
