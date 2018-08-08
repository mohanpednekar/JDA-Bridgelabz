package com.jda.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jda.interfaces.AddressBookInterface;
import com.jda.interfaces.FileSystemInterface;
import com.jda.util.Constants.Ext;
import com.jda.util.Constants.Path;

import java.io.*;
import java.lang.reflect.Type;

public
class FileSystemJson implements FileSystemInterface {
	@Override
	public
	AddressBookJson readFile(File file) {
		Gson gson = new Gson();
		Type type = new TypeToken<AddressBookJson>() {}.getType();
		try {
			return gson.fromJson(new BufferedReader(new FileReader(file)), type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public
	void saveFile(AddressBookInterface addressBook, File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (Writer writer = new FileWriter(file)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(addressBook, writer);
			addressBook.setChangedSinceLastSave(false);
			addressBook.setFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public
	File fetchFile(String addressBookName) {
		return new File(Path.ADDRESS_BOOKS + addressBookName + Ext.ADDRESS_BOOK);
	}
}
