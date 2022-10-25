package edu.ntnu.idatt2001.cardgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Class HelloController
 * @author Edvard Schøyen
 */
public class HelloController {
    @FXML
    private Label dealHand;
    @FXML
    private Label labelSumFaces;
    @FXML
    private Label labelFlush;
    @FXML
    private Label labelCardsOfHearts;
    @FXML
    private Label labelQueenOfSpades;
    @FXML
    private Label checkHand;
    @FXML
    private Label card1;
    @FXML
    private Label card2;
    @FXML
    private Label card3;
    @FXML
    private Label card4;
    @FXML
    private Label card5;

    CardsInHand cardsInHand;

    @FXML
    protected void dealHand() {
        DeckOfCards deckOfCards = new DeckOfCards();
        cardsInHand = new CardsInHand(deckOfCards.dealHand(5));
        showCards();
        emptyBoxes();
    }

    @FXML
    protected void checkHand(){
        calculateSum();
        checkFlush();
        checkHearts();
        checkQueenOfSpades();
    }

    @FXML
    protected void dealAndCheck(){
        dealHand();
        checkHand();
    }

    public void emptyBoxes(){
        labelSumFaces.setText("0");
        labelFlush.setText("No");
        labelCardsOfHearts.setText("0");
        labelQueenOfSpades.setText("No");
    }

    public void calculateSum(){
        String sumFaces = String.valueOf(cardsInHand.sumOfCards());
        labelSumFaces.setText(sumFaces);
    }

    public void checkFlush(){
        String flush = "No";
        if (this.cardsInHand.isFlush()){
            flush = "Yes";
        }
        labelFlush.setText(flush);
    }

    public void checkHearts(){
        labelCardsOfHearts.setText(this.cardsInHand.cardsOfHearts());
    }

    public void checkQueenOfSpades(){
        String queenOfSpades = "No";
        if (this.cardsInHand.queenOfSpades()){
            queenOfSpades = "Yes";
        }
        labelQueenOfSpades.setText(queenOfSpades);
    }

    public void showCards(){
        card1.setText(cardsInHand.getCardsInHand().get(0).getAsString());
        card2.setText(cardsInHand.getCardsInHand().get(1).getAsString());
        card3.setText(cardsInHand.getCardsInHand().get(2).getAsString());
        card4.setText(cardsInHand.getCardsInHand().get(3).getAsString());
        card5.setText(cardsInHand.getCardsInHand().get(4).getAsString());
    }




}