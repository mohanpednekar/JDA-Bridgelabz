package com.jda.programs.ds;

import com.jda.util.Constants;
import com.jda.util.Reader;
import com.jda.util.StringUtils;
import com.jda.util.ds.UnorderedList;

public class UnorderedListProgram {
  
  static String INPUT  = Constants.INPUT_PATH + "unorderedLists.txt";
  static String OUTPUT = Constants.OUTPUT_PATH + "unorderedLists.txt";
  
  public static void main(String[] args) {
    
    UnorderedList<String> unorderedList = readFromFile(INPUT);
    if (unorderedList == null) { return; }
    
    System.out.println(unorderedList);
    System.out.println("Which word do you want to search for?");
    Reader reader = new Reader();
    String wordToSearch = reader.readString();
    
    boolean found = unorderedList.search(wordToSearch);
    if (found) {
      unorderedList.remove(wordToSearch);
    } else {
      unorderedList.add(wordToSearch);
    }
    
    unorderedList.printToFile(OUTPUT);
    System.out.println(readFromFile(OUTPUT));
  }
  
  private static UnorderedList<String> readFromFile(String filePath) {
    UnorderedList<String> unorderedList = new UnorderedList<>();
    String[] words = StringUtils.getWordsFromFile(filePath);
    if (words == null) { return null; }
    
    for (String word : words) {
      unorderedList.add(word);
    }
    return unorderedList;
  }
}
