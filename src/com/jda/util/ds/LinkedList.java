package com.jda.util.ds;

public class LinkedList<T> extends List<T> implements Iterable<T> {

  public T get(int pos) {
    Node<T> node = root;

    if (pos == 0) {
      T rootData = root.getData();
      root = null;
      return rootData;
    }
    for (int i = 0; i < pos; i++) {
      node = node.getNext();
    }
    return node.getData();
  }

  public void add(T item) {
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
