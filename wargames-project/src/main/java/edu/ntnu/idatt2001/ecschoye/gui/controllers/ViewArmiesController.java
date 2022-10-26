package edu.ntnu.idatt2001.ecschoye.gui.controllers;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import edu.ntnu.idatt2001.ecschoye.filehandling.Filehandler;
import edu.ntnu.idatt2001.ecschoye.gui.alerts.DisplayAlerts;
import edu.ntnu.idatt2001.ecschoye.gui.models.ArmyModel;
import edu.ntnu.idatt2001.ecschoye.gui.models.FillModels;
import edu.ntnu.idatt2001.ecschoye.register.Register;
import edu.ntnu.idatt2001.ecschoye.gui.FXMLLoaderClass;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Class ViewArmiesController
 * @author Edvard Schøyen
 *
 */
public class ViewArmiesController implements Initializable {

    @FXML private TableView<ArmyModel> tableViewArmiesInRegister;
    @FXML private TableColumn<ArmyModel, String> columnFileName;
    @FXML private TableColumn<ArmyModel, String> columnArmyName;
    @FXML private TableColumn<ArmyModel, Integer> columnTotalUnits;
    @FXML private TableColumn<ArmyModel, Integer> columnAvgBaseAtt;
    @FXML private TableColumn<ArmyModel, Integer> columnTotalHealth;
    private final Filehandler filehandler = new Filehandler();
    private final DisplayAlerts alerts = new DisplayAlerts();


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
     * Uses FXMLLoaderClass to go to Add army
     * @param event
     * @throws IOException
     */
    @FXML
    public void goToAddArmy(ActionEvent event) throws IOException {
        FXMLLoaderClass.goToAddArmy(event);
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


    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void viewArmy(ActionEvent event) throws IOException {
        ObservableList<ArmyModel> observableListSelectedArmy = tableViewArmiesInRegister.getSelectionModel().getSelectedItems();
        if (!(observableListSelectedArmy.isEmpty())) {
            String pathToFile = observableListSelectedArmy.get(0).getFilePath();
            ViewArmyController.setFilePath(pathToFile);
            FXMLLoaderClass.goToViewArmy(event);
        } else {
            alerts.displayAlertUploadArmy();
        }
    }


    /**
     * Removes all the armies from the register and updates the tableview
     */
    @FXML
    public void removeAllArmies() {
        Register.armyRegister.removeAllArmies();
        updateTable();
    }

    /**
     * Deletes all the armies from the register and updates the tableview
     * @throws IOException
     */
    @FXML
    public void deleteAllArmies() throws IOException {
        Register.armyRegister.deleteAllArmies();
        updateTable();
    }

    /**
     * Checks if an army is chosen
     * then uses the filehandler in combination with the filepath to create an army object
     * to delete the army from the register
     * then updates table
     * if no army is chosen an alert will show up
     * @throws IOException
     */
    @FXML
    public void deleteArmy() throws IOException {
        ObservableList<ArmyModel> observableListSelectedArmy = tableViewArmiesInRegister.getSelectionModel().getSelectedItems();
        if (!(observableListSelectedArmy.isEmpty())) {
            Army army = filehandler.readFromFile(observableListSelectedArmy.get(0).getFilePath());
            Register.armyRegister.deleteArmy(army);
            updateTable();
        } else {
            alerts.displayAlertUploadArmyToDelete();
        }
    }

    /**
     * Checks if an army is chosen
     * then uses the filehandler in combination with the filepath to create an army object
     * to remove the army from the register
     * then updates table
     * if no army is chosen an alert will show up
     */
    @FXML
    public void removeArmy() {
        ObservableList<ArmyModel> observableListSelectedArmy= tableViewArmiesInRegister.getSelectionModel().getSelectedItems();
        if (!(observableListSelectedArmy.isEmpty())) {
            Army army = filehandler.readFromFile(observableListSelectedArmy.get(0).getFilePath());
            Register.armyRegister.removeArmy(army);
            updateTable();
        } else {
            alerts.displayAlertUploadArmyToRemove();
        }
    }

    /**
     * Empties the tableview
     */
    public void emptyTable() {
        tableViewArmiesInRegister.getItems().clear();
        tableViewArmiesInRegister.setPlaceholder(new Label("No army to display. Upload or create an army."));
    }

    /**
     * Updates the tableview with information
     * about the army using the UnitModel
     */
    public void updateTable() {
        emptyTable();
        FillModels fillModels = new FillModels();
        if (Register.armyRegister.isNotEmpty()) {
            tableViewArmiesInRegister.setItems(fillModels.fillArmyModel());
        }
        else tableViewArmiesInRegister.setPlaceholder(new Label("No army to display. Upload or create an army."));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tableViewArmiesInRegister.setPlaceholder(new Label("No army to display. Upload an army to see the units."));
            columnArmyName.setCellValueFactory(new PropertyValueFactory<>("armyName"));
            columnFileName.setCellValueFactory(new PropertyValueFactory<>("fileName"));
            columnTotalUnits.setCellValueFactory(new PropertyValueFactory<>("totalUnits"));
            columnAvgBaseAtt.setCellValueFactory(new PropertyValueFactory<>("avgBaseAtt"));
            columnTotalHealth.setCellValueFactory(new PropertyValueFactory<>("totalHealth"));
            updateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
