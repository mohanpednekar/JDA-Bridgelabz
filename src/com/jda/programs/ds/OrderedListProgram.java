package com.jda.programs.ds;

import com.jda.util.Constants;
import com.jda.util.Reader;
import com.jda.util.StringUtils;
import com.jda.util.ds.OrderedList;

public class OrderedListProgram {
  
  static String INPUT  = Constants.INPUT_PATH + "orderedLists.txt";
  static String OUTPUT = Constants.OUTPUT_PATH + "orderedLists.txt";
  
  public static void main(String[] args) {
    OrderedList<Integer> orderedList = readFromFile(INPUT);
    if (orderedList == null) { return; }
    
    System.out.println(orderedList);
    System.out.println("Which number do you want to search for?");
    Reader reader = new Reader();
    Integer numberToSearch = reader.readInteger();
    
    boolean found = orderedList.search(numberToSearch);
    if (found) {
      orderedList.remove(numberToSearch);
    } else {
      orderedList.add(numberToSearch);
    }
    
    orderedList.printToFile(OUTPUT);
    System.out.println(readFromFile(OUTPUT));
  }
  
  private static OrderedList<Integer> readFromFile(String filePath) {
    OrderedList<Integer> orderedList = new OrderedList<>();
    String[] words = StringUtils.getWordsFromFile(filePath);
    if (words == null) { return null; }
    for (String word : words) {
      orderedList.add(Integer.parseInt(word));
    }
    return orderedList;
  }
}
