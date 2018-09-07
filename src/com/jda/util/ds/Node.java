package com.jda.util.ds;

public class Node<T> {
  
  private Node<T> prev;
  private T       data;
  private Node<T> next;
  
  public Node(T data, Node<T> next) {
    setData(data);
    setNext(next);
  }
  
  public Node(Node<T> prev, T data, Node<T> next) {
    this.prev = prev;
    this.data = data;
    this.next = next;
  }
  
  public Node(T data) {
    setData(data);
    setNext(null);
  }
  
  @Override
  public String toString() {
    return data.toString();
  }
  
  public T getData() {
    return data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public Node<T> getNext() {
    return next;
  }
  
  public void setNext(Node<T> next) {
    this.next = next;
  }
  
  public Node<T> getPrev() {
    return prev;
  }
  
  public void setPrev(Node<T> prev) {
    this.prev = prev;
  }
  
  public boolean hasPrev() {
    return prev != null;
  }
  
  public boolean hasNext() {
    return next != null;
  }
}
