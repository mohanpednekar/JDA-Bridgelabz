package com.jda.util.ds;

public class Squeue<T> extends Queue<T> {
  
  Stack<T> main     = new Stack<>();
  Stack<T> assitant = new Stack<>();
  
  @Override
  public T dequeue() {
    transferAll(main, assitant);
    return assitant.pop();
  }
  
  @Override
  public void enqueue(T item) {
    transferAll(assitant, main);
    main.push(item);
  }
  
  @Override
  public boolean isEmpty() {
    transferAll(assitant, main);
    return main.isEmpty();
  }
  
  private void transferAll(Stack<T> fromStack, Stack<T> toStack) {
    while (!fromStack.isEmpty()) {
      toStack.push(fromStack.pop());
    }
  }
}
