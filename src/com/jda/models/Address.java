package com.jda.models;

public class Address {
  private String address;
  private String city;
  private String state;
  private String zip;
  
  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getZip() {
    return zip;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public void setZip(String zip) {
    this.zip = zip;
  }
  
  Address(String address, String city, String state, String zip) {
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(address).append("\n");
    builder.append(city).append(", ").append(state).append(", ").append(zip).append("\n");
    return builder.toString();
  }
}
