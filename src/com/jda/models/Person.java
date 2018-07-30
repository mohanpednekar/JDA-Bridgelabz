package com.jda.models;

import java.util.Comparator;

import com.jda.interfaces.PersonInterface;

public class Person implements PersonInterface {
  private String  fname;
  private String  sname;
  private Address address;
  private String  phone;
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(fname).append(" ").append(sname).append("\n");
    builder.append("Phone : ").append(phone).append("\n");
    builder.append(address);
    return builder.toString();
  }

  Person(String firstName, String lastName, String addressline, String city, String state, String zip,
      String phoneNumber) {
    fname = firstName;
    sname = lastName;
    address = new Address(addressline, city, state, zip);
    phone = phoneNumber;
  }

  @Override
  public String getFirstName() {
    return fname;
  }
  
  public void setAddress(String address) {
    this.address.setAddress(address);
  }
  
  @Override
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public static Comparator<Person> CompareByZip = (person1, person2) -> {
    int comparison = person1.address.getZip().compareTo(person2.address.getZip());
    if (comparison == 0) {
      comparison = person1.address.getAddress().compareTo(person2.address.getAddress()); // unnecessary
    }
    return comparison;
    
  };
  
  public static Comparator<Person> CompareByName = (person1, person2) -> {
    int comparison = person1.fname.compareToIgnoreCase(person2.fname);
    if (comparison == 0) {
      comparison = person1.sname.compareToIgnoreCase(person2.sname);
    }
    if (comparison == 0) {
      comparison = person1.phone.compareTo(person2.phone); // unnecessary
    }
    return comparison;
  };
  
  public void setCity(String city) {
    address.setCity(city);
  }
  
  public void setState(String state) {
    address.setState(state);
  }
  
  public void setZip(String zip) {
    address.setZip(zip);
  }
  
  @Override
  public String getLastName() {
    return sname;
  }
  
  @Override
  public String getAddress() {
    return address.getAddress();
  }
  
  @Override
  public String getCity() {
    return address.getCity();
  }
  
  @Override
  public String getState() {
    return address.getState();
  }
  
  @Override
  public String getZip() {
    return address.getZip();
  }
  
}