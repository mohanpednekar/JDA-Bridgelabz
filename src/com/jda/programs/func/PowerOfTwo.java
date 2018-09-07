/**************************************************
 * Purpose: Finds the nth power of 2
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since 05-07-2018
 **************************************************/

package com.jda.programs.func;

import com.jda.util.Maths;
import com.jda.util.Printer;
import com.jda.util.Reader;
import com.jda.util.StringUtils;
import com.jda.util.Validation;

public class PowerOfTwo {
  
  public static void main(String[] args) {
    
    Reader reader = new Reader();
    
    // checks whether a command line argument is provided
    if (!Validation.checkCmdArgs(args, 1)) { return; }
    
    int n = StringUtils.stringToPositiveInteger(args[0]);
    if (n == -1) { return; }
    if (n >= 31) {
      Printer.printLine("Please input a power less than 31");
    }
    int result = Maths.power(2, n);
    
    Printer.printLine("The " + StringUtils.ordinal(n) + " power of 2 is " + result);
  }
}
