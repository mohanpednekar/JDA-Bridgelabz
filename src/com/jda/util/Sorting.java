package com.jda.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
  
  /**
   * Performs bubble sort
   */
  public static <T extends Comparable<T>> ArrayList<T> bubbleSort(ArrayList<T> items) {
    int n = items.size();
    for (int i = 0; i < (n - 1); i++) {
      for (int j = 0; j < (n - 1); j++) {
        T input = items.get(j);
        T input2 = items.get(j + 1);
        if (input.compareTo(input2) > 0) {
          Collections.swap(items, j, j + 1);
        }
      }
    }
    return items;
  }
  
  public static <T extends Comparable<T>> ArrayList<T> mergeSort(List<T> list) {
    int n = list.size();
    if (2 > n) { return (ArrayList<T>) list; }
    ArrayList<T> sorted = new ArrayList<>();
    ArrayList<T> part1 = mergeSort(list.subList(0, n / 2));
    ArrayList<T> part2 = mergeSort(list.subList((n / 2) + 1, n));
    while (!part1.isEmpty() && !part2.isEmpty()) {
      if (part1.get(0).compareTo(part2.get(0)) < 0) {
        sorted.add(part1.remove(0));
      } else {
        sorted.add(part2.remove(0));
      }
    }
    sorted.addAll(part1);
    sorted.addAll(part2);
    return sorted;
  }
  
  /**
   * @param items
   * @return
   */
  public static <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> items) {
    int n = items.size();
    for (int i = 0; i < n; i++) {
      for (int j = i; j > 0; j--) {
        T i1 = items.get(j - 1);
        T i2 = items.get(j);
        if (i1.compareTo(i2) > 0) {
          Collections.swap(items, j - 1, j);
        }
      }
    }
    return items;
  } /*
     * (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
}
