package com.jda.programs.oop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jda.programs.oop.classes.Product;
import com.jda.util.Constants;
import com.jda.util.Printer;
import com.jda.util.Reader;

public class InventoryUsingGson {
  
  private static String INPUT  = Constants.INPUT_PATH + "inventory.json";
  private static String OUTPUT = Constants.INPUT_PATH + "inventory.json";
  
  public static void main(String[] args) {
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Type type = new TypeToken<HashMap<String, ArrayList<Product>>>() {}.getType();
    HashMap<String, ArrayList<Product>> inventory = null;
    try {
      inventory = gson.fromJson(new BufferedReader(new FileReader(INPUT)), type);
    } catch (FileNotFoundException e) {
      System.out.println("Something went wrong");
    }
    Printer.printToFile(OUTPUT, gson.toJson(inventory));
    inventory.forEach((key, item) -> System.out.println(key + " " + calculateValueOf(item)));
    
    System.out.println("Enter a to add, r to remove, q to quit");
    char choice;
    Reader reader = new Reader();
    do {
      choice = reader.readString().charAt(0);
      switch (choice) {
        case 'a':
          addProductTo(inventory);
          Printer.printToFile(OUTPUT, gson.toJson(inventory));
          break;
        case 'r':
          removeProductFrom(inventory);
          Printer.printToFile(OUTPUT, gson.toJson(inventory));
          break;
        default:
          choice = 'q';
          Printer.printToFile(OUTPUT, gson.toJson(inventory));
      }
    } while (choice != 'q');
  }
  
  private static long calculateValueOf(ArrayList<Product> products) {
    return products.stream().mapToLong(Product::findValue).sum();
  }
  
  private static void addProductTo(HashMap<String, ArrayList<Product>> inventory) {
    System.out.println("What do you want to add to inventory");
    Reader reader = new Reader();
    String item = reader.readLine();
    inventory.putIfAbsent(item, new ArrayList<>());
    inventory.get(item).add(new Product(reader));
  }
  
  private static void removeProductFrom(HashMap<String, ArrayList<Product>> inventory) {
    System.out.println("What do you want to remove from inventory");
    Reader reader = new Reader();
    String item = reader.readLine();
    ArrayList<Product> itemToRemove = inventory.get(item);
    if (itemToRemove == null) {
      System.out.println("This commodity doesn't exist");
      return;
    }
    System.out.println("Which one?");
    String productName = reader.readLine();
    Product productToRemove = null;
    for (Product product : itemToRemove) {
      if (product.getName().equals(productName)) {
        productToRemove = product;
      }
    }
    if (productToRemove == null) {
      System.out.println("This item doesn't exist");
    } else {
      itemToRemove.remove(productToRemove);
    }
  }
}
