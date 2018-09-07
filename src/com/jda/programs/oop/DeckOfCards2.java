package com.jda.programs.oop;

import com.jda.programs.oop.classes.Card;
import com.jda.programs.oop.classes.CardsPlayer;
import com.jda.util.Enums.CardSuit;
import com.jda.util.Enums.CardValue;
import com.jda.util.ds.Queue;
import com.jda.util.ds.UnorderedList;

public class DeckOfCards2 {
  
  public static void main(String[] args) {
    UnorderedList<Card> deck = createDeck();
    
    Queue<CardsPlayer> players = new Queue<>();
    for (int i = 0; i < 4; i++) {
      players.enqueue(new CardsPlayer());
    }
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 4; j++) {
        Card card = deck.pop(0);
        CardsPlayer player = players.dequeue();
        player.receiveCard(card);
        players.enqueue(player);
      }
    }
    
    for (int i = 0; i < 4; i++) {
      CardsPlayer player = players.dequeue();
      player.sort();
      System.out.println("Player " + i + " : " + player);
      players.enqueue(player);
    }
  }
  
  private static UnorderedList<Card> createDeck() {
    UnorderedList<Card> deck = new UnorderedList<>();
    for (CardSuit suit : CardSuit.values()) {
      for (CardValue value : CardValue.values()) {
        deck.add(new Card(suit, value));
      }
    }
    deck.shuffle();
    return deck;
  }
}
