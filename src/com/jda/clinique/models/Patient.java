package com.jda.clinique.models;

import com.jda.clinique.util.Reader;

public class Patient extends Person {
  private long mobile;
  private int  age;
  
  public Patient(Reader reader, int highestId) {
    id = highestId + 1;
    name = reader.requestInputLine("Enter name : ");
    mobile = reader.requestInputLong("Enter mobile : ");
    age = reader.requestInputInt("Enter age : ");
  }

  public long getMobile() {
    return mobile;
  }
  
  public void setMobile(long mobile) {
    this.mobile = mobile;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
}
