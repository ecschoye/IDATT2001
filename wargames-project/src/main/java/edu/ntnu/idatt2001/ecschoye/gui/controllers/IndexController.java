package edu.ntnu.idatt2001.ecschoye.gui.controllers;

import edu.ntnu.idatt2001.ecschoye.gui.FXMLLoaderClass;
import edu.ntnu.idatt2001.ecschoye.gui.alerts.DisplayAlerts;
import edu.ntnu.idatt2001.ecschoye.register.Register;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Class IndexController
 * @author Edvard Schøyen
 *
 */
public class IndexController {
    private final DisplayAlerts alerts = new DisplayAlerts();

    /**
     * Uses FXMLLoaderClass to go to Add army
     * @param event
     * @throws IOException
     */
    @FXML
    public void goToAddArmy(ActionEvent event) throws IOException {
        FXMLLoaderClass.goToAddArmy(event);
    }

    /**
     * Uses FXMLLoaderClass to go to Upload army
     * @param event
     * @throws IOException
     */
    @FXML
    public void goToUploadArmy(ActionEvent event) throws IOException {
        FXMLLoaderClass.goToLoadArmy(event);
    }

    /**
     * Uses FXMLLoaderClass to go to View armies
     * @param event
     * @throws IOException
     */
    @FXML
    public void goToViewArmies(ActionEvent event) throws IOException {
        FXMLLoaderClass.goToViewArmies(event);
    }

    /**
     * Uses FXMLLoaderClass to go to Battle menu
     * Requires at least two armies in the register to access
     * @param event
     * @throws IOException
     */
    @FXML
    public void goToBattleMenu(ActionEvent event) throws IOException {
        if (!Register.armyRegister.isReadyForBattle()) {
            alerts.displayAlertMustAddArmies();
        } else {
            FXMLLoaderClass.goToBattleMenu(event);
        }
    }
}
