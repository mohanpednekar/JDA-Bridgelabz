package com.jda.views;

import com.jda.controllers.AddressBookController;
import com.jda.models.AddressBook;

public class AddressBookView {
  private AddressBookController addressBookController;
  private AddressBook           addressBook;
  // private ArrayList<String> nameList;

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
    System.err.println(message);
  }

  public void update(MenuItems menuItem) {
    switch (menuItem) {
      case ADD:
        addressBookController.addPerson();
        break;
      case DELETE: {
        Integer selectedPerson = addressBookController.getSelectedPerson();
        if (selectedPerson == null) {
          reportError("No person selected");
        } else {
          addressBookController.deletePerson(selectedPerson);
        }
      }
        break;
      case EDIT: {
        Integer selectedPerson = addressBookController.getSelectedPerson();

        if (selectedPerson == null) {
          reportError("No person selected");
        } else {
          addressBookController.editPerson(selectedPerson);
        }
      }
        break;
      case NEW: {
        boolean changed = addressBook.getChangedSinceLastSave();
        if (changed) {
          addressBookController.offerSaveChanges();
        }
        addressBookController.createNewAddressBook();
      }
        break;
      case OPEN: {
        boolean changed = addressBook.getChangedSinceLastSave();
        if (changed) {
          addressBookController.offerSaveChanges();
        }
        addressBookController.openAddressBook();
      }
        break;
      case PRINT:
        addressBookController.printAll();
        break;
      case QUIT:
        break;
      case SAVE:
        addressBookController.saveAddressBook();
        break;
      case SAVEAS:
        addressBookController.saveAddressBookAs();
        break;
      case SORTBYNAME:
        addressBookController.sortByName();
        break;
      case SORTBYZIP:
        addressBookController.sortByZip();
        break;
      case SELECT:
        addressBookController.selectPerson();
    }
  }

  enum MenuItems {
    NEW, OPEN, SAVE, SAVEAS, PRINT, QUIT, ADD, EDIT, DELETE, SORTBYNAME, SORTBYZIP, SELECT
  }
}
