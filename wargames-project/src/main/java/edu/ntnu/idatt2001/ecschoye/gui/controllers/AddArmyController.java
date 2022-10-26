package edu.ntnu.idatt2001.ecschoye.gui.controllers;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import edu.ntnu.idatt2001.ecschoye.gui.alerts.DisplayAlerts;
import edu.ntnu.idatt2001.ecschoye.gui.models.FillModels;
import edu.ntnu.idatt2001.ecschoye.gui.models.UnitModel;
import edu.ntnu.idatt2001.ecschoye.register.Register;
import edu.ntnu.idatt2001.ecschoye.unitfactory.UnitFactory;
import edu.ntnu.idatt2001.ecschoye.gui.FXMLLoaderClass;
import javafx.collections.FXCollections;
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
 * Class AddArmyController
 * @author Edvard Schøyen
 *
 */
public class AddArmyController implements Initializable {

    @FXML private TextField txtFieldArmyName;
    @FXML private Button btnSetArmyName;
    @FXML private Label labelArmyName;
    @FXML private TableView<UnitModel> tableViewArmyPreview;
    @FXML private TableColumn<UnitModel, String> columnUnit;
    @FXML private TableColumn<UnitModel, Integer> columnAmount;
    @FXML private ChoiceBox<String> choiceBoxUnit;
    @FXML private TextField txtFieldUnitName;
    @FXML private TextField txtFieldUnitAmount;
    @FXML private TextField txtFieldUnitHealth;
    @FXML private Label labelNameIsTaken;
    @FXML private Button btnAddUnitToArmy;
    @FXML private Button btnAddArmyToRegister;
    @FXML private ObservableList<UnitModel> observableList = FXCollections.observableArrayList();
    private Army army;
    private final UnitFactory unitFactory = new UnitFactory();
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
     * Uses FXMLLoaderClass to go to View army
     * @param event
     * @throws IOException
     */
    @FXML
    public void goToViewArmy(ActionEvent event) throws IOException {
        FXMLLoaderClass.goToAddArmy(event);
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
     * Sets army name
     * Creates an army object from the text input
     * If an army with that name already exists in the register an alert will
     * show up and the user has to write a new army name.
     * If it's a new name it will allow the user to input unit values.
     */
    @FXML
    public void setArmyName() {
        army = new Army(txtFieldArmyName.getText());

        for (Army armyFromFile: Register.armyRegister.getArmies()) {
            if (armyFromFile.getName().equals(army.getName())){
                labelNameIsTaken.setText(army.getName() + " is already in use. Please choose a different name.");
                btnAddUnitToArmy.setDisable(true);
                btnAddArmyToRegister.setDisable(true);
                alerts.displayAlertArmyNameIsAlreadyInUse();
                army = null;
            }
        }
        enableUserUnitInput();
    }

    /**
     * Takes inn the unit type, name, health and int and tries to add the unit/ units to the army
     * If successfull it resets the unit inputs and updates the tableview
     * If unsuccessfull an alert will show up
     */
    @FXML
    public void addUnitToArmy() {
        try {
            String unitTypeString = choiceBoxUnit.getValue().toLowerCase();
            String unitNameString = txtFieldUnitName.getText();
            int unitHealthInt = Integer.parseInt(txtFieldUnitHealth.getText());
            int unitAmountInt = Integer.parseInt(txtFieldUnitAmount.getText());
            army.addAll(unitFactory.multipleUnits(unitTypeString,unitNameString,unitHealthInt,unitAmountInt));
            resetUnitInfo();
            updateTable();
            btnAddArmyToRegister.setDisable(false);
        } catch (Exception e) {
            alerts.displayAlertSomethingWentWrongWhenCreatingUnit();
        }
    }


    /**
     * Updates the tableview with information
     * about the army using the UnitModel
     */
    public void updateTable() {
        emptyTable();
        labelArmyName.setText(army.getName());
        FillModels fillModels = new FillModels();
        tableViewArmyPreview.setItems(fillModels.fillUnitModel(army));
    }

    /**
     * Empties the tableview
     */
    public void emptyTable() {
        labelArmyName.setText("");
        tableViewArmyPreview.getItems().clear();
        observableList.clear();
        tableViewArmyPreview.setPlaceholder(new Label("No army to display. Upload an army to see the units."));
    }

    /**
     * Method to add the army to the register
     * First checks if army is empty, if it is an alert will show up
     * telling the user that the army must contain units
     * If the army has units it will be added to the register
     * and the inputs will be reset to let the user add more armies
     */
    public void addArmyToRegister() {
        if (!army.hasUnits()) {
            alerts.displayAlertMustContainUnits();
            throw new IllegalArgumentException("Army must contain units");
        }
        Register.armyRegister.addArmy(army);
        txtFieldArmyName.clear();
        army = null;
        enableAddNewArmy();
        resetUnitInfo();
        emptyTable();
    }

    /**
     * Resets the unit information inputs
     */
    public void resetUnitInfo() {
        txtFieldUnitName.clear();
        txtFieldUnitHealth.clear();
        txtFieldUnitAmount.clear();
    }

    /**
     * Disables the army name input due to the army object being created
     * Enables the unit inputs to allow the user to add units to the army
     */
    public void enableUserUnitInput() {
        btnSetArmyName.setDisable(true);
        btnAddUnitToArmy.setDisable(false);
        txtFieldArmyName.setDisable(true);
        choiceBoxUnit.setDisable(false);
        txtFieldUnitName.setDisable(false);
        txtFieldUnitHealth.setDisable(false);
        txtFieldUnitAmount.setDisable(false);
    }

    /**
     * Enables the army name input but disables the other inputs
     * This is to make sure the army object is created first
     */
    public void enableAddNewArmy() {
        txtFieldArmyName.setDisable(false);
        btnSetArmyName.setDisable(false);
        btnAddUnitToArmy.setDisable(true);
        btnAddArmyToRegister.setDisable(true);
        choiceBoxUnit.setDisable(true);
        txtFieldUnitName.setDisable(true);
        txtFieldUnitHealth.setDisable(true);
        txtFieldUnitAmount.setDisable(true);
        choiceBoxUnit.getSelectionModel().select("Infantry");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            choiceBoxUnit.getItems().removeAll(choiceBoxUnit.getItems());
            choiceBoxUnit.getItems().addAll("Infantry","Ranged","Cavalry","Commander", "Artillery");
            choiceBoxUnit.getSelectionModel().select("Infantry");
            tableViewArmyPreview.setPlaceholder(new Label("No army to display. Upload an army to see the units."));
            columnUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
            columnAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            tableViewArmyPreview.setItems(observableList);
            enableAddNewArmy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
