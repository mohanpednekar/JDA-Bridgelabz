/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 11, 2018
 *******************************************************************/
package com.jda.programs.algo;

import java.util.ArrayList;
import java.util.HashMap;

import com.jda.util.Printer;
import com.jda.util.Reader;
import com.jda.util.Sorting;
import com.jda.util.Stopwatch;

public class SearchAndSort {
  
  public static void main(String[] args) {
    Reader reader = new Reader();
    SearchAndSort programs = new SearchAndSort();
    Printer.printLine("What do you want to enter?");
    Printer.printLine("s : Strings \t i : Integers");
    char ch = reader.readString().toLowerCase().charAt(0);
    Printer.printLine("How many of them?");
    int n = reader.readInteger();
    
    switch (ch) {
      case 's':
        ArrayList<String> strings = new ArrayList<>();
        Printer.printLine("Enter " + n + " strings");
        
        for (int i = 0; i < n; i++) {
          strings.add(reader.readString());
        }
        Printer.printLine("What do you want to search for?");
        String stringToSearch = reader.readString();
        programs.searchAndSort(strings, stringToSearch);
        break;
      case 'i':
        ArrayList<Integer> integers = new ArrayList<>();
        Printer.printLine("Enter " + n + " integers");
        for (int i = 0; i < n; i++) {
          integers.add(reader.readInteger());
        }
        Printer.printLine("What do you want to search for?");
        Integer integerToSearch = reader.readInteger();
        programs.searchAndSort(integers, integerToSearch);
        break;
      default:
    }
  }
  
  /**
   * @param items
   */
  private <T extends Comparable<T>> void searchAndSort(ArrayList<T> items, T itemToSearch) {
    
    Watcher.BINARY.start();
    boolean found = binarySearch(items, itemToSearch);
    Watcher.BINARY.stop();
    System.out.println("found = " + found);
    
    Watcher.INSERTION.start();
    ArrayList<T> insertionSorted = Sorting.insertionSort(items);
    Watcher.INSERTION.stop();
    System.out.println(insertionSorted);
    
    Watcher.BUBBLE.start();
    ArrayList<T> bubbleSorted = Sorting.bubbleSort(items);
    Watcher.BUBBLE.stop();
    System.out.println(bubbleSorted);
    
    HashMap<Watcher, Long> watchersMap = new HashMap<>();
    
    for (Watcher watcher : Watcher.values()) {
      System.out.println(watcher.resultString());
      watchersMap.put(watcher, watcher.elapsedTimeNanos());
    }
  }
  
  /**
   * @param items
   * @param itemToSearch
   * @return
   */
  private <T extends Comparable<T>> boolean binarySearch(ArrayList<T> items, T itemToSearch) {
    BST tree = new BST(items.get(0));
    items.forEach(tree::insert);
    return tree.has(itemToSearch);
  }
  
  enum Watcher {
    BINARY("Binary search"), INSERTION("Insertion sort"), BUBBLE("Bubble sort");
    Stopwatch stopwatch = new Stopwatch();
    String    watcherName;
    
    Watcher(String str) {
      watcherName = str;
    }
    
    public void start() {
      stopwatch.start();
    }
    
    public void stop() {
      stopwatch.stop();
    }
    
    public long elapsedTimeNanos() {
      return stopwatch.elapsedTimeNanos();
    }
    
    public String resultString() {
      return watcherName + " took " + elapsedTimeSeconds() + " seconds";
    }
    
    public double elapsedTimeSeconds() {
      return stopwatch.elapsedTimeSeconds();
    }
  }
  
  public class BST<T extends Comparable<T>> {
    
    T   value;
    BST left;
    BST right;
    
    BST(T value) {
      this.value = value;
    }
    
    /*
     * (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    // @Override
    // public
    // int compare(T o1, T o2) {
    // if (o1.getClass().toString().endsWith("Integer")) {
    // return ((Integer) o1).compareTo((Integer) o2);
    // }
    // if (o1.getClass().toString().endsWith("String")) {
    // return ((String) o1).compareToIgnoreCase((String) o2);
    // }
    // return 0;
    // }
    
    public boolean has(T value) {
      if (value.compareTo(this.value) == 0) { return true; }
      if ((value.compareTo(this.value) < 0) && (null != left)) { return left.has(value); }
      if ((value.compareTo(this.value) > 0) && (null != right)) { return right.has(value); }
      return false;
    }
    
    public void insert(T value) {
      if (value.compareTo(this.value) <= 0) {
        if (null == left) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else if (null == right) {
        right = new BST(value);
      } else {
        right.insert(value);
      }
    }
  }
}
