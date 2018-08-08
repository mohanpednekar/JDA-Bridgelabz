package com.jda.app;

import com.jda.controllers.AddressBookController;
import com.jda.models.AddressBookJson;
import com.jda.models.FileSystemJson;
import com.jda.util.Constants;
import com.jda.util.Reader;
import com.jda.views.AddressBookView;

public class AddressBookApplication {
  AddressBookController addressBookController = new AddressBookController();
	AddressBookView addressBookView;
	FileSystemJson fileSystem = new FileSystemJson();

  public static void main(String[] args) {

    AddressBookApplication addressBookApplication = new AddressBookApplication();

    addressBookApplication.execute();

  }

  private void execute() {
	  AddressBookJson addressBook = new AddressBookJson();
    addressBookView = new AddressBookView(addressBookController, addressBook);
    addressBookController.setAddressBookView(addressBookView);
    addressBookController.setFileSystem(fileSystem);
    System.out.println("Welcome to Address Book Manager");
    Reader reader = new Reader();
	  Constants.MenuItems choice = null;
    do {
	    for (Constants.MenuItems item : Constants.MenuItems.values()) {
        System.out.print(item + "\t\t");
      }
	    choice = Constants.MenuItems.valueOf(reader.requestLine("\nEnter you Choice").trim().toUpperCase());
      System.out.println(choice);
      addressBookView.update(choice);
    } while (!choice.equals(Constants.MenuItems.QUIT));
  }

  public void quitApplication() {

  }
}
