package com.jda.util.ds;

public class OrderedList<T extends Comparable<T>> extends List<T> {
  
  public void add(T item) {
    if (root == null) {
      root = new Node<>(item);
      return;
    }
    if (root.getData().compareTo(item) > 0) {
      root = new Node<>(item, root);
      return;
    }
    Node<T> node = root;
    
    while (node.getNext() != null) {
      if (node.getNext().getData().compareTo(item) > 0) {
        node.setNext(new Node<>(item, node.getNext()));
        return;
      }
      node = node.getNext();
    }
    node.setNext(new Node<>(item));
  }
}
