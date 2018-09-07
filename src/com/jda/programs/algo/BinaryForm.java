package com.jda.programs.algo;

import com.jda.util.Maths;
import com.jda.util.Reader;

public class BinaryForm {
  
  public static void main(String[] args) {
    Reader reader = new Reader();
    System.out.println("Enter a number to convert to Binary");
    int number = reader.readInteger();
    System.out.print("The binary form is ");
    String binary = Maths.toBinary(number);
    System.out.println(binary);
    String swappedNibbles = Maths.swapNibbles(binary);
    System.out.println("After Swapping nibbles : " + swappedNibbles);
    int newNumber = Maths.binaryToDecimal(swappedNibbles);
    System.out.println("The new number is " + newNumber);
    System.out.println("The resultant number is " + (Maths.isPowerOf2(swappedNibbles) ? "" : "not ")
        + "a " + "power" + " of" + " 2");
  }
}
