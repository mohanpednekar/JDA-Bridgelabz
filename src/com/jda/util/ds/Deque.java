package com.jda.util.ds;

public class Deque<T> extends Queue<T> {
  
  public void addFront(T item) {
    root = new Node<>(item, root);
  }
  
  public void addRear(T item) {
    enqueue(item);
  }
  
  public T removeFront() {
    return dequeue();
  }
  
  public T removeRear() {
    return pop();
  }
}
