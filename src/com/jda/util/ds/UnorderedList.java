package com.jda.util.ds;

public class UnorderedList<T> extends List<T> {
  
  public void add(T item) {
    root = new Node<>(item, root);
  }
  
  public void append(T item) {
    if (root == null) {
      root = new Node<>(item);
      return;
    }
    Node<T> node = root;
    
    while (node.getNext() != null) {
      node = node.getNext();
    }
    node.setNext(new Node<>(item));
  }
}
