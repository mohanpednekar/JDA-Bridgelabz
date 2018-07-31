package com.jda.views;

import com.jda.controllers.AddressBookController;
import com.jda.models.AddressBook;
import com.jda.models.FileSystem;
import com.jda.util.Reader;
import com.jda.views.AddressBookView.MenuItems;

public class AddressBookApplication {
  AddressBookController addressBookController = new AddressBookController();
  AddressBookView       addressBookView;
  FileSystem            fileSystem            = new FileSystem();
  
  public static void main(String[] args) {
    
    AddressBookApplication addressBookApplication = new AddressBookApplication();
    
    addressBookApplication.execute();

  }
  
  private void execute() {
    AddressBook addressBook = new AddressBook();
    addressBookView = new AddressBookView(addressBookController, addressBook);
    addressBookController.setAddressBookView(addressBookView);
    addressBookController.setFileSystem(fileSystem);
    System.out.println("Welcome to Address Book Manager");
    Reader reader = new Reader();
    MenuItems choice = null;
    do {
      for (MenuItems item : MenuItems.values()) {
        System.out.print(item + "\t\t");
      }
      choice = MenuItems.valueOf(reader.requestLine("\nEnter you Choice").trim().toUpperCase());
      System.out.println(choice);
      addressBookView.update(choice);
    } while (!choice.equals(MenuItems.QUIT));
    
  }
  
  public void quitApplication() {

  }
  
}
