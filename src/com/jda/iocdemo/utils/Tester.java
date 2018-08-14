package com.jda.iocdemo.utils;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jda.iocdemo.beans.SomeBean;

public class Tester {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    SomeBean bean1 = (SomeBean) context.getBean("some");
    bean1.setName("Hello");
    bean1.display();
    SomeBean bean2 = (SomeBean) context.getBean("some");
    bean2.setName("World");
    bean2.display();
    bean1.display();
    System.out.println(bean1.hashCode());
    System.out.println(bean2.hashCode());
    context.registerShutdownHook();
    context.close();
  }
}
