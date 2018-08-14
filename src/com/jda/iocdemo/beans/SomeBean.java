package com.jda.iocdemo.beans;

public class SomeBean implements MyBean {
  private String name;

  public void display() {
    System.out.println(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public void initBean() {
    System.out.println("Some Bean created");
  }
  
  @Override
  public void destroyBean() {
    System.out.println("Some Bean destroyed.");
  }

}
