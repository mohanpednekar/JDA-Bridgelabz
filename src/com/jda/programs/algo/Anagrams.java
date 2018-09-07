/*******************************************************************
 * Purpose: to check whether two strings are nagrams of each other
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 *******************************************************************/
package com.jda.programs.algo;

import com.jda.util.Reader;
import com.jda.util.StringUtils;

public class Anagrams {
  public static void main(String[] args) {
    Reader reader = new Reader();
    System.out.println("Enter first string");
    
    String string1 = reader.readString();
    
    System.out.println("Enter second string");
    
    String string2 = reader.readString();
    
    if (StringUtils.areAnagrams(string1, string2)) {
      System.out.println("Anagrams");
    } else {
      System.out.println("Not Anagrams");
    }
  }
}
