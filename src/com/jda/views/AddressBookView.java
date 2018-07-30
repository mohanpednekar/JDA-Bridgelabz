package com.jda.views;

import com.jda.controllers.AddressBookController;
import com.jda.models.AddressBook;

import java.util.ArrayList;
import java.util.Observable;

public class AddressBookView {
	AddressBookController addressBookController;
	AddressBook addressBook;
	ArrayList<String> nameList;

	public AddressBookView(AddressBookController addressBookController, AddressBook addressBook) {
		this.addressBookController = addressBookController;
		this.addressBook = addressBook;
	}

	public AddressBook getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}

	public void reportError(String message) {

	}

	public void update(Observable o, Object arg) {

	}

	enum MenuItems {
		NEW, OPEN, SAVE, SAVEAS, PRINT, QUIT
	}

	enum Buttons {
		ADD, EDIT, DELETE, SORTBYNAME, SORTBYZIP
	}
}
