package com.jda.util;

public class Constants {
	public
	enum MenuItems {
		NEW, OPEN, SAVE, SAVEAS, PRINT, QUIT, ADD, EDIT, DELETE, SORTBYNAME, SORTBYZIP, SELECT
	}

	public
	enum DataStorageType {
		JSON, DB
	}

	public
	class Path {
    public static final String DATA          = "data/";
    public static final String ADDRESS_BOOKS = DATA + "AddressBooks/";
  }

  public class Ext {
    public static final String ADDRESS_BOOK = ".addr";
  }
}
