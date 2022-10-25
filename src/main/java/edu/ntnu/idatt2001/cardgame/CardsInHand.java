package edu.ntnu.idatt2001.cardgame;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class CardsInHand
 * @author Edvard Schøyen
 */
public class CardsInHand {

    ArrayList<PlayingCard> cardsInHand;

    public CardsInHand(ArrayList<PlayingCard> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    /**
     * Returns sum of cards
     * @return integer
     */
    public int sumOfCards(){
        return cardsInHand.stream().mapToInt(PlayingCard::getFace).sum();
    }

    /**
     * Checks if cards in hand is a flush
     * @return boolean
     */
    public boolean isFlush(){
        return cardsInHand.stream().map(PlayingCard::getSuit).distinct().count() <= 1;
    }

    /**
     * Returns cards of hearts or "No hearts" if hand contains no cards of hearts
     * @return string
     */
    public String cardsOfHearts(){
        String hand = "";
        ArrayList<PlayingCard> heartCards = cardsInHand.stream().filter(playingCard -> playingCard.getSuit() == 'H').collect(Collectors.toCollection(ArrayList::new));
        if (heartCards.size() > 0){
            hand = heartCards.stream().map(PlayingCard::cardInfo).reduce(" ",String::concat);
                return hand;
        }
        else {
            return "No hearts";
        }
    }

    /**
     * Checks if hand contains queen of spades
     * @return
     */
    public boolean queenOfSpades(){
        return cardsInHand.stream().filter(playingCard -> Objects.equals(playingCard.getAsString(),"S12")).distinct().count() == 1;
    }


    public ArrayList<PlayingCard> getCardsInHand() {
        return cardsInHand;
    }
}
