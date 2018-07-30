package com.jda.models;

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
import com.google.gson.reflect.TypeToken;
import com.jda.util.Constants.Ext;
import com.jda.util.Constants.Path;

public class FileSystem {
  public AddressBook readFile(File file) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
    Gson gson = new Gson();
    Type type = new TypeToken<AddressBook>() {}.getType();
    return gson.fromJson(new BufferedReader(new FileReader(file)), type);
  }
  
  public void saveFile(AddressBook addressBook, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(addressBook, writer);
      addressBook.setChangedSinceLastSave(false);
      addressBook.setFile(file);
    }
  }

  public File fetchFile(String addressBookName) {
    return new File(Path.ADDRESS_BOOKS + addressBookName + Ext.ADDRESS_BOOK);
    
  }
  
}
