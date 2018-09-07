package com.jda.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.jda.programs.func.StringPermutations;

public class StringUtils {
  
  /**
   * checks whether the given strings can be formed by rearranging the letters
   * in each other
   */
  public static boolean areAnagrams(String string1, String string2) {
    List<Character> s1 = stringToCharacterList(string1);
    List<Character> s2 = stringToCharacterList(string2);
    Collections.sort(s1);
    Collections.sort(s2);
    return s1.equals(s2);
  }
  
  /**
   * @return list of all the characters (in lowercase) present in the string
   *         excluding whitespace
   */
  private static List<Character> stringToCharacterList(String string1) {
    return string1.replaceAll("\\s", "").toLowerCase().chars().mapToObj(c -> (char) c)
        .collect(Collectors.toList());
  }
  
  public static boolean isPalindrome(String string) {
    String original = string.replace("\\s", "").toLowerCase();
    String reversed = new StringBuilder(original).reverse().toString();
    return original.equals(reversed);
  }
  
  public static boolean isPrimeAnagram(ArrayList<Integer> primes, Integer prime) {
    HashSet<Integer> anagrams = anagramsOf(prime);
    boolean foundPrimeAnagram = false;
    if (anagrams.size() > 1) {
      for (Integer anagram : anagrams) {
        if (primes.contains(anagram)) {
          if (!anagram.equals(prime)) {
            foundPrimeAnagram = true;
          }
        }
      }
    }
    return foundPrimeAnagram;
  }
  
  public static HashSet<Integer> anagramsOf(Integer prime) {
    HashSet<Integer> anagrams = new HashSet<>();
    String string = String.valueOf(prime);
    HashSet<String> anagramsAsStrings = StringPermutations.recursivelyPermute(string);
    for (String anagram : anagramsAsStrings) {
      anagrams.add(Integer.parseInt(anagram));
    }
    return anagrams;
  }
  
  // appends an ordinal suffix to the number
  public static String ordinal(int n) {
    if (((n % 100) > 10) && ((n % 100) < 20)) { return n + "th"; }
    switch (n % 10) {
      case 1:
        return n + "st";
      case 2:
        return n + "nd";
      case 3:
        return n + "rd";
      default:
        return n + "th";
    }
  }
  
  // converts a string into positive integer if possible, otherwise returns -1
  public static int stringToPositiveInteger(String string) {
    int n;
    try {
      n = Integer.parseInt(string);
      if (n >= 0) { return n; }
    } catch (NumberFormatException e) {
      // invoked only when parsing an integer fails
      System.out.println("The value given is not an integer");
      return -1;
    }
    // when n is negative
    System.out.println("The value given is not a positive integer");
    return -1;
  }
  
  public static String[] getWordsFromFile(String filePath) {
    try {
      return new String(Files.readAllBytes(Paths.get(filePath))).split("\\s");
    } catch (IOException e) {
      System.out.println("Reading file failed");
      return null;
    }
  }

  public static String titleCase(String string) {
    if (string.length() < 2) { return string.toUpperCase(); }
    return string.toUpperCase().charAt(0) + string.substring(1).toLowerCase();
  }
}
