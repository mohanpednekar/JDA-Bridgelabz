package com.jda.programs.oop;

import java.util.ArrayList;
import java.util.Collections;

import com.jda.programs.oop.classes.Card;
import com.jda.programs.oop.classes.CardsPlayer;
import com.jda.util.Enums.CardSuit;
import com.jda.util.Enums.CardValue;
import com.jda.util.Printer;

public class DeckOfCards {
  
  public static void main(String[] args) {
    ArrayList<Card> deck = createDeck();
    
    Collections.shuffle(deck);
    ArrayList<CardsPlayer> players = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      players.add(new CardsPlayer());
    }
    Card[][] cardsArray = new Card[4][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 4; j++) {
        Card card = deck.remove(0);
        players.get(j).receiveCard(card);
        cardsArray[j][i] = card;
      }
    }
    Printer.printArray(cardsArray, 4, 9);
  }
  
  static ArrayList<Card> createDeck() {
    ArrayList<Card> deck = new ArrayList<>();
    for (CardSuit suit : CardSuit.values()) {
      for (CardValue value : CardValue.values()) {
        deck.add(new Card(suit, value));
      }
    }
    return deck;
  }
}
