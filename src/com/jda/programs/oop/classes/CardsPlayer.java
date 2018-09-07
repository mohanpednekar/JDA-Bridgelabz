package com.jda.programs.oop.classes;

import com.jda.util.ds.OrderedList;
import com.jda.util.ds.Queue;

public class CardsPlayer {
  
  Queue<Card> cards = new Queue<>();
  
  public void receiveCard(Card card) {
    cards.enqueue(card);
  }
  
  @Override
  public String toString() {
    return cards.toString();
  }
  
  public void sort() {
    OrderedList<Card> sortedCards = new OrderedList<>();
    while (!cards.isEmpty()) {
      sortedCards.add(cards.dequeue());
    }
    while (!sortedCards.isEmpty()) {
      cards.enqueue(sortedCards.pop(0));
    }
  }
}
