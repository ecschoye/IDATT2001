package edu.ntnu.idatt2001.cardgame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardsInHandTest {

    /**
     * Prints the sum of the cards in the hand
     */
    @Test
    void sumOfCards() {
        DeckOfCards deckOfCards = new DeckOfCards();
        CardsInHand cards = new CardsInHand(deckOfCards.dealHand(5));
        System.out.println(cards.sumOfCards());

    }

    /**
     * Checks if the hand is a flush
     */
    @Test
    void isFlush() {
        ArrayList<PlayingCard> cards = new ArrayList<>();
        cards.add(new PlayingCard('H',1));
        cards.add(new PlayingCard('H',2));
        cards.add(new PlayingCard('H',3));
        cards.add(new PlayingCard('H',4));
        cards.add(new PlayingCard('H',5));

        CardsInHand cardsInHand = new CardsInHand(cards);
        assertTrue(cardsInHand.isFlush());
    }

    /**
     * Checks if the hand is not flush
     */
    @Test
    void isNotFlush(){
        ArrayList<PlayingCard> cards = new ArrayList<>();
        cards.add(new PlayingCard('D',1));
        cards.add(new PlayingCard('H',2));
        cards.add(new PlayingCard('D',3));
        cards.add(new PlayingCard('D',4));
        cards.add(new PlayingCard('D',5));

        CardsInHand cardsInHand = new CardsInHand(cards);
        assertFalse(cardsInHand.isFlush());
    }

    /**
     *
     */
    @Test
    void cardsOfHearts() {
        ArrayList<PlayingCard> cards = new ArrayList<>();
        cards.add(new PlayingCard('H',11));
        cards.add(new PlayingCard('C',12));
        cards.add(new PlayingCard('D',1));

        CardsInHand cardsInHand = new CardsInHand(cards);
        assertEquals(" H11 ",cardsInHand.cardsOfHearts());
    }

    /**
     *
     */
    @Test
    void notCardsOfHearts() {
        ArrayList<PlayingCard> cards = new ArrayList<>();
        cards.add(new PlayingCard('S',11));
        cards.add(new PlayingCard('C',11));
        cards.add(new PlayingCard('D',11));

        CardsInHand cardsInHand = new CardsInHand(cards);
        assertNotEquals(" H11 ",cardsInHand.cardsOfHearts());
    }

    /**
     * Checks if hand contains a queen of spades
     */
    @Test
    void checkQueenOfSpades() {
        ArrayList<PlayingCard> cards = new ArrayList<>();
        cards.add(new PlayingCard('S',12));
        cards.add(new PlayingCard('D',12));
        cards.add(new PlayingCard('H',12));

        CardsInHand cardsInHand = new CardsInHand(cards);
        assertTrue(cardsInHand.queenOfSpades());

    }

    /**
     * Checks if hand does not contain a queen of spades
     */
    @Test
    void checkNotQueenOfSpades() {
        ArrayList<PlayingCard> cards = new ArrayList<>();
        cards.add(new PlayingCard('D',12));
        cards.add(new PlayingCard('C',12));
        cards.add(new PlayingCard('H',12));

        CardsInHand cardsInHand = new CardsInHand(cards);
        assertFalse(cardsInHand.queenOfSpades());

    }

    /**
     * Checks if any other card with value 12 will return a false positive
     */
    @Test
    void checkFalseQueenOfSpades() {
        ArrayList<PlayingCard> cards = new ArrayList<>();
        cards.add(new PlayingCard('S',13));
        cards.add(new PlayingCard('H',12));
        cards.add(new PlayingCard('D',12));
        cards.add(new PlayingCard('C',12));
        cards.add(new PlayingCard('X',12));

        CardsInHand cardsInHand = new CardsInHand(cards);
        assertFalse(cardsInHand.queenOfSpades());

    }
}