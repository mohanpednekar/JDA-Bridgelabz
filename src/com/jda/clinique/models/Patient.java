package com.jda.clinique.models;

public class Patient extends Person {
  private long mobile;
  private int  age;
  
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
