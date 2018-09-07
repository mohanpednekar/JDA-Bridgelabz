package com.jda.util.ds;

public class Stack<T> extends LinkedList<T> {

  public void push(T item) {
    root = new Node<>(item, root);
  }

  @Override
  public T pop() {
    Node<T> node = root;
    root = root.getNext();
    return node.getData();
  }

  public T peek() {
    return root.getData();
  }
}
