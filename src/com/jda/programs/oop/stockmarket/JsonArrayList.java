package com.jda.programs.oop.stockmarket;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.jda.util.Constants;
import com.jda.util.Printer;
import com.jda.util.Reader;
import com.jda.util.ds.LinkedList;

public class JsonArrayList<T extends JsonIdHolder<G>, G extends Comparable<G>> {
  
  Long          maxId;
  Gson          gson;
  String        file;
  LinkedList<T> data = new LinkedList<>();
  
  JsonArrayList(Gson gson, String file) {
    this.gson = gson;
    this.file = file;
  }
  
  JsonArrayList() {
    data = new LinkedList<>();
  }
  
  Long findHighestId() {
    Long maxId = 0L;
    for (T item : data) {
      if (((Long) item.getId()).compareTo(maxId) > 0) {
        maxId = (Long) item.getId();
      }
    }
    return maxId;
  }
  
  void printToFile() {
    ArrayList<T> array = new ArrayList<>();
    data.forEach(array::add);
    Printer.printToFile(file, gson.toJson(array));
    System.out.println("Modified " + file.substring(Constants.LIVE_PATH.length()));
  }
  
  public boolean isEmpty() {
    return (data == null) || data.isEmpty();
  }
  
  void display(Reader reader, G id) {
    if (find(id) != null) {
      show(id);
    } else {
      System.out.println("Not found. Show all?");
      if (reader.readString().charAt(0) == 'y') {
        showAll();
      }
    }
  }
  
  T find(G id) {
    for (T item : data) {
      if (item.is(id)) { return item; }
    }
    return null;
  }
  
  void show(G id) {
    for (T item : data) {
      if (item.is(id)) {
        System.out.println(item);
      }
    }
  }
  
  void showAll() {
    for (T datum : data) {
      System.out.println(datum);
    }
    // data.forEach(System.out::println);
  }
  
  public boolean remove(G id) {
    T item = find(id);
    if (item == null) {
      System.out.println("Not found");
      return false;
    }
    data.remove(item);
    return true;
  }
  //
  // @Override
  // public Iterator<T> iterator() {
  // return new Iterator<T>() {
  // int index = 0;
  //
  // @Override
  // public boolean hasNext() {
  // return false;
  // }
  //
  // @Override
  // public T next() {
  // // TODO Auto-generated method stub
  // return null;
  // }
  // };
  // }
}
