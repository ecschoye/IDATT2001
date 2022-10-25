package edu.ntnu.idatt2001.cardgame;

import java.util.*;

/**
 * Class DeckOfCards
 * @author Edvard Schøyen
 */
public class DeckOfCards {
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private ArrayList<PlayingCard> deck;

    public DeckOfCards(){
        deck = new ArrayList();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                PlayingCard playingCard = new PlayingCard(suit[i],j);
                deck.add(playingCard);
            }
        }
    }

    /**
     * Deals cards to hand
     * Adds cards to hand and removes them to make sure
     * the hand does not get multiple of the same card
     * @param cards
     * @return ArrayList<PlayingCard> handDealt
     */
    public ArrayList<PlayingCard> dealHand(int cards){
        ArrayList<PlayingCard> handDealt = new ArrayList<>();
        for (int i = 0; i < cards; i++) {
            Collections.shuffle(deck);
            handDealt.add(deck.get(0));
            deck.remove(deck.get(0));
        }
        return handDealt;
    }
}
