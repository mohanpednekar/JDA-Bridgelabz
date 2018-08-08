package com.jda.models;

import com.jda.interfaces.AddressBookInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public
class AddressBookJson implements AddressBookInterface {
  private ArrayList<Person> collection     = new ArrayList<>();
  private transient File    file;
  private transient boolean changedSinceLastSave;
  private transient Integer selectedPerson = null;

  @Override
  public int getNumberOfPersons() {
    return collection.size();
  }

  @Override
  public void addPerson(String firstName, String lastName, String address, String city, String state, String zip,
      String phone) {
    Person person = new Person(firstName, lastName, address, city, state, zip, phone);
    collection.add(person);
    setChangedSinceLastSave(true);
    setSelectedPerson(getNumberOfPersons());
  }

  @Override
  public String getFullNameOfPerson(int index) {
    Person person = collection.get(index - 1);
    return person.getFirstName() + " " + person.getLastName();
  }

  @Override
  public ArrayList<String> getOtherPersonInformation(int index) {
    Person person = collection.get(index - 1);
    ArrayList<String> otherInfo = new ArrayList<>();
    otherInfo.add(person.getAddress());
    otherInfo.add(person.getCity());
    otherInfo.add(person.getState());
    otherInfo.add(person.getZip());
    otherInfo.add(person.getPhone());
    return otherInfo;
  }

  @Override
  public void updatePerson(int index, String address, String city, String state, String zip, String phone) {
    Person person = collection.get(index - 1);
    person.setAddress(address);
    person.setCity(city);
    person.setState(state);
    person.setZip(zip);
    person.setPhone(phone);
    setChangedSinceLastSave(true);
  }

  @Override
  public void removePerson(int index) {
    collection.remove(index - 1);
    setChangedSinceLastSave(true);
    setSelectedPerson(null);
  }

  @Override
  public void sortByName() {
    Collections.sort(collection, Person.CompareByName);
    setChangedSinceLastSave(true);
    setSelectedPerson(null);
  }

  @Override
  public void sortByZip() {
    Collections.sort(collection, Person.CompareByZip);
    setChangedSinceLastSave(true);
    setSelectedPerson(null);
  }

  @Override
  public void printAll() {
    collection.forEach(System.out::println);
  }

  @Override
  public File getFile() {
    return file;
  }

  @Override
  public void setFile(File file) {
    this.file = file;
  }

  @Override
  public String getTitle() {
    return file.getName();
  }

  @Override
  public boolean getChangedSinceLastSave() {
    return changedSinceLastSave;
  }

  @Override
  public void setChangedSinceLastSave(boolean changedSinceLastSave) {
    this.changedSinceLastSave = changedSinceLastSave;
  }

  public Integer getSelectedPerson() {
    return selectedPerson;
  }

  public void setSelectedPerson(Integer selectedPerson) {
    this.selectedPerson = selectedPerson;
    if (selectedPerson != null) {
      System.out.println(getFullNameOfPerson(selectedPerson));
    }
  }

}
