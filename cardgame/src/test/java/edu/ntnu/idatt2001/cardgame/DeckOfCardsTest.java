package edu.ntnu.idatt2001.cardgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {
    /**
     *
     */
    @Test
    void setDeckOfCards(){
        DeckOfCards deckOfCards = new DeckOfCards();
        System.out.println(deckOfCards.toString());
    }

    @Test
    void dealHandTest(){
        DeckOfCards deckOfCards = new DeckOfCards();

        System.out.println(deckOfCards.dealHand(5).toString());
        assertEquals(5,deckOfCards.dealHand(5).size());
    }
}