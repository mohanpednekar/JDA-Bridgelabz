package com.jda.clinique.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.jda.clinique.util.Constants;

public class FileSystemService {
  public <T> T readFile(String pathname, Type type) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
    File file = new File(pathname);
    Gson gson = new GsonBuilder().setDateFormat(Constants.DATE_FORMAT).create();
    System.out.println(type.getTypeName());
    System.out.println(file.getAbsolutePath());
    return gson.fromJson(new BufferedReader(new FileReader(file)), type);
  }

  public <T> void saveFile(T item, String pathname) throws IOException {
    File file = new File(pathname);
    file.createNewFile();
    try (Writer writer = new FileWriter(file)) {
      Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat(Constants.DATE_FORMAT).create();
      gson.toJson(item, writer);
    }
  }
}
