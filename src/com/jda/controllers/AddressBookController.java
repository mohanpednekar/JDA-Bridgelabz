package com.jda.controllers;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.jda.models.AddressBookJson;
import com.jda.models.FileSystemJson;
import com.jda.util.Reader;
import com.jda.views.AddressBookView;

import java.io.File;
import java.util.ArrayList;

public class AddressBookController {
  private AddressBookView addressBookView;
	private FileSystemJson fileSystem;

  public void addPerson() {
    Reader reader = new Reader();
    String firstName = reader.requestLine("First Name");
    String lastName = reader.requestLine("Surname");
    String address = reader.requestLine("Address Line");
    String city = reader.requestLine("City");
    String state = reader.requestLine("State");
    String zip = reader.requestLine("ZIP");
    String phone = reader.requestLine("Phone");
	  AddressBookJson addressBook = addressBookView.getAddressBook();
    addressBook.addPerson(firstName, lastName, address, city, state, zip, phone);
  }

  public void editPerson(int index) {
	  AddressBookJson addressBook = addressBookView.getAddressBook();
    String fullName = addressBook.getFullNameOfPerson(index);
    System.out.println(fullName);
    ArrayList<String> info = addressBook.getOtherPersonInformation(index);
    System.out.println("Enter the requested edits. Enter x to keep current information");
    Reader reader = new Reader();
    String address = reader.requestUpdate("address", info.get(0));
    String city = reader.requestUpdate("city", info.get(1));
    String state = reader.requestUpdate("state", info.get(2));
    String zip = reader.requestUpdate("zip", info.get(3));
    String phone = reader.requestUpdate("phone", info.get(4));
    boolean confirmationProvided = reader.seekConfirmation("Confirm edit person?");
    if (confirmationProvided) {
      addressBook.updatePerson(index, address, city, state, zip, phone);
    } else {
      System.out.println("Cancelled editing person");
    }
  }

  public void deletePerson(Integer index) {
	  AddressBookJson addressBook = addressBookView.getAddressBook();
    String fullName = addressBook.getFullNameOfPerson(index);
    Reader reader = new Reader();
    System.out.println(fullName);
    boolean confirmationProvided = reader.seekConfirmation("Confirm delete person?");
    if (confirmationProvided) {
      addressBook.removePerson(index);
    } else {
      System.out.println("Cancelled removing person");
    }
  }

  public void sortByName() {
	  AddressBookJson addressBook = addressBookView.getAddressBook();
    addressBook.sortByName();

  }

  public void sortByZip() {
	  AddressBookJson addressBook = addressBookView.getAddressBook();
    addressBook.sortByZip();
  }

  public void printAll() {
	  AddressBookJson addressBook = addressBookView.getAddressBook();
    addressBook.printAll();
  }

  public void offerSaveChanges() {
    Reader reader = new Reader();
    boolean confirmSaveChanges = reader.seekConfirmation("Do you want to save current Address Book?");
    if (confirmSaveChanges) {
      saveAddressBook();
    } else {
      System.out.println("Changes discarded");
    }
  }

  public void saveAddressBook() {
	  AddressBookJson addressBook = addressBookView.getAddressBook();
    File file = addressBook.getFile();
    if (file == null) {
      saveAddressBookAs();
    } else {
	    fileSystem.saveFile(addressBook, file);
    }
  }

  public void saveAddressBookAs() {
    Reader reader = new Reader();
    String addressBookName = reader.requestLine("Enter name for Address Book");
    File file = fileSystem.fetchFile(addressBookName);
	  AddressBookJson addressBook = addressBookView.getAddressBook();
    addressBook.setFile(file);
    saveAddressBook();
  }

	public
	void createNewAddressBook() {
		AddressBookJson addressBook = new AddressBookJson();
    addressBookView.setAddressBook(addressBook);
    System.out.println("New addressbook created");
  }

  public void openAddressBook() {
    Reader reader = new Reader();
    String addressBookName = reader.requestLine("Enter name for Address Book");
    File file = fileSystem.fetchFile(addressBookName);

    try {
	    AddressBookJson addressBook = fileSystem.readFile(file);
      addressBook.setFile(file);
      addressBookView.setAddressBook(addressBook);
    } catch (JsonIOException | JsonSyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

	public void selectPerson() {
		AddressBookJson addressBook = addressBookView.getAddressBook();
    int count = addressBook.getNumberOfPersons();
    Reader reader = new Reader();
    int selected = Integer.parseInt(reader.requestLine("Enter the person number"));
    if (selected <= count) {
      addressBook.setSelectedPerson(selected);
    }
  }

	public
	Integer getSelectedPerson() {
		AddressBookJson addressBook = addressBookView.getAddressBook();
    return addressBook.getSelectedPerson();
  }

  public void setAddressBookView(AddressBookView addressBookView) {
    this.addressBookView = addressBookView;
  }

	public
	void setFileSystem(FileSystemJson fileSystem) {
    this.fileSystem = fileSystem;
  }
}
