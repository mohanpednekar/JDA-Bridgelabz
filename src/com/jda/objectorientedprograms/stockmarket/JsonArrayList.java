package com.jda.objectorientedprograms.stockmarket;

import com.google.gson.Gson;
import com.jda.utility.Printer;
import com.jda.utility.Reader;
import java.util.ArrayList;

public
class JsonArrayList<T extends JsonIdHolder, G extends Comparable<G>> {

  Long maxId;
  Gson gson;
  String file;
  ArrayList<T> data;

  JsonArrayList(Gson gson, String file) {
    this.gson = gson;
    this.file = file;
  }

  JsonArrayList() {
    data = new ArrayList<>();
  }

  Long findHighestId() {
    Long maxId = 0L;
    for (T item : data) {
      if (item.getId().compareTo(maxId) > 0) {
        maxId = (Long) item.getId();
      }
    }
    return maxId;
  }

  void printToFile() {
    Printer.printToFile(file, gson.toJson(data));
  }

  public
  boolean isEmpty() {
    return (data == null) || data.isEmpty();
  }

  void display(Reader reader, G id) {
    if (find(id) != null) { show(id); }
    else {
      System.out.println("Not found. Show all?");
      if (reader.readString().charAt(0) == 'y') { showAll(); }
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
    data.forEach(System.out::println);
  }

  public
  boolean remove(G id) {
    T item = find(id);
    if (item == null) {
      System.out.println("Not found");
      return false;
    }
    data.remove(item);
    return true;
  }
}
