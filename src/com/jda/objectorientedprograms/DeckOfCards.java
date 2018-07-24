package com.jda.objectorientedprograms;

import com.jda.objectorientedprograms.classes.Card;
import com.jda.objectorientedprograms.classes.CardsPlayer;
import com.jda.utility.Enums.CardSuit;
import com.jda.utility.Enums.CardValue;
import com.jda.utility.Printer;
import java.util.ArrayList;
import java.util.Collections;

public
class DeckOfCards {

  public static
  void main(String[] args) {
    ArrayList<Card> cards = new ArrayList<>();
    for (CardSuit suit : CardSuit.values()) {
      for (CardValue value : CardValue.values()) {
        cards.add(new Card(suit, value));
      }
    }

    Collections.shuffle(cards);
    ArrayList<CardsPlayer> players = new ArrayList<>();
    for (int i = 0; i < 4; i++) { players.add(new CardsPlayer()); }
    Card[][] cardsArray = new Card[4][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 4; j++) {
        Card card = cards.remove(0);
        players.get(j).receiveCard(card);
        cardsArray[j][i] = card;
      }
    }
    Printer.printArray(cardsArray, 4, 9);

  }
}
