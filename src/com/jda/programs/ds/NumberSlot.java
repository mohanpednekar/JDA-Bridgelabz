package com.jda.programs.ds;

import java.util.HashMap;

import com.jda.util.Constants;
import com.jda.util.Printer;
import com.jda.util.Reader;
import com.jda.util.StringUtils;
import com.jda.util.ds.OrderedList;

public class NumberSlot {
  
  static String INPUT  = Constants.INPUT_PATH + "numberSlots.txt";
  static String OUTPUT = Constants.OUTPUT_PATH + "numberSlots.txt";
  
  public static void main(String[] args) {
    System.out.println("Your hash table looks like this");
    HashMap<Integer, OrderedList<Integer>> map = createMap(INPUT, 11);
    System.out.println(map);
    Reader reader = new Reader();
    System.out.println("Enter a number to search");
    int number = reader.readInteger();
    searchAndUpdate(map, number % 11, number);
    System.out.println(map);
    Printer.printToFile(OUTPUT, map);
  }
  
  private static HashMap<Integer, OrderedList<Integer>> createMap(String inputFilePath,
      int nSlots) {
    HashMap<Integer, OrderedList<Integer>> map = new HashMap<>();
    String[] words = StringUtils.getWordsFromFile(inputFilePath);
    for (String word : words) {
      Integer number = Integer.parseInt(word);
      map.putIfAbsent(number % nSlots, new OrderedList<>());
      map.get(number % nSlots).add(number);
    }
    return map;
  }
  
  private static void searchAndUpdate(HashMap<Integer, OrderedList<Integer>> map, int key,
      int number) {
    map.putIfAbsent(key, new OrderedList<>());
    if (!map.get(key).search(number)) {
      map.get(key).add(number);
    } else {
      map.get(key).remove(number);
      if (map.get(key).isEmpty()) {
        map.remove(key);
      }
    }
  }
}
