package edu.ntnu.idatt2001.ecschoye.gui.controllers;

import edu.ntnu.idatt2001.ecschoye.gui.alerts.DisplayAlerts;
import edu.ntnu.idatt2001.ecschoye.gui.models.ArmyModel;
import edu.ntnu.idatt2001.ecschoye.gui.models.FillModels;
import edu.ntnu.idatt2001.ecschoye.register.Register;
import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
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
 * Class BattleMenuController
 * @author Edvard Schøyen
 *
 */
public class BattleMenuController implements Initializable {
    @FXML private Label labelArmyName;
    @FXML private TableView<ArmyModel> tableViewBattleArmies;
    @FXML private TableColumn<ArmyModel, String> columnFileName;
    @FXML private TableColumn<ArmyModel, String> columnArmyName;
    @FXML private TableColumn<ArmyModel, Integer> columnTotalUnits;
    @FXML private TableColumn<ArmyModel, Integer> columnTotalHealth;
    @FXML private TableColumn<ArmyModel, Integer> columnAvgBaseAtt;
    @FXML private ChoiceBox<String> choiceBoxTerrain;
    @FXML private Label labelArmyOne;
    @FXML private Label labelArmyTwo;
    @FXML private ObservableList<ArmyModel> observableListArmy1 = FXCollections.observableArrayList();
    @FXML private ObservableList<ArmyModel> observableListArmy2 = FXCollections.observableArrayList();
    private final DisplayAlerts alerts = new DisplayAlerts();
    private String pathToArmyOne = "";
    private String pathToArmyTwo = "";


    /**
     * Uses FXMLLoaderClass to go to Upload army
     * @param event
     * @throws IOException
     */
    @FXML
    public void goToUploadArmy(ActionEvent event) throws IOException {
        FXMLLoaderClass.goToLoadArmy(event);
    }

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
     * Updates the tableview with information
     * about the army using the ArmyModel
     */
    public void updateTable() {
        emptyTable();
        FillModels fillModels = new FillModels();
        if (Register.armyRegister.isNotEmpty()){
            tableViewBattleArmies.setItems(fillModels.fillArmyModel());
        }
        else tableViewBattleArmies.setPlaceholder(new Label("No army to display. Upload an army to see the units."));

    }

    /**
     * Empties the tableview
     */
    public void emptyTable() {
        labelArmyName.setText("");
        tableViewBattleArmies.getItems().clear();
        tableViewBattleArmies.setPlaceholder(new Label("No army to display. Upload an army to see the units."));
    }


    /**
     * Puts the chosen ArmyModel object from the tableview in an observablelist
     * If the user has not chosen an army an alert will show up
     * If the observablelist contains an ArmyModel the filePath will be
     * added to the to the pathToArmyOne string.
     * If the pathToArmyOne equals pathToArmyTwo another alert will show up and the string will be emptied.
     * If they are not the same the string will be added to labelArmyOne
     */
    @FXML
    public void chooseArmyOne() {
        observableListArmy1 = tableViewBattleArmies.getSelectionModel().getSelectedItems();

        if (!observableListArmy1.isEmpty()) {
            pathToArmyOne = observableListArmy1.get(0).getFilePath();
            if (pathToArmyOne.equals(pathToArmyTwo)) {
                alerts.displayAlertChooseAnotherArmy();
                pathToArmyOne = "";
            } else {
                labelArmyOne.setText(observableListArmy1.get(0).getArmyName());
            }
        } else {
            alerts.displayAlertMustChooseAnArmy();
        }
    }

    /**
     * Puts the chosen ArmyModel object from the tableview in an observablelist
     * If the user has not chosen an army an alert will show up
     * If the observablelist contains an ArmyModel the filePath will be
     * added to the to the pathToArmyTwo string.
     * If the pathToArmyTwo equals pathToArmyOne another alert will show up and the string will be emptied.
     * If they are not the same the string will be added to labelArmyTwo
     */
    @FXML
    public void chooseArmyTwo() {
        observableListArmy2 = tableViewBattleArmies.getSelectionModel().getSelectedItems();
        if (!observableListArmy2.isEmpty()) {
            pathToArmyTwo = observableListArmy2.get(0).getFilePath();
            if (pathToArmyTwo.equals(pathToArmyOne)) {
                alerts.displayAlertChooseAnotherArmy();
                pathToArmyTwo = "";
            } else {
                labelArmyTwo.setText(observableListArmy2.get(0).getArmyName());
            }
        } else {
            alerts.displayAlertMustChooseAnArmy();
        }
    }


    /**
     * User chooses the two armies and terrain
     * If any of the filepaths are empty an alert will show up
     * the filepaths and terrain will be loaded to the SimulationController
     * and the FXMLoader class will load the simulation.fxml
     * @param event
     * @throws IOException
     */
    public void initiateBattle(ActionEvent event) throws IOException {
        String terrainType = choiceBoxTerrain.getValue().toLowerCase();
        Terrain terrain;
        switch (terrainType) {
            case "plains" -> terrain = Terrain.PLAINS;
            case "forest" -> terrain = Terrain.FOREST;
            case "hill" -> terrain = Terrain.HILL;
            case "random terrain" -> terrain = Terrain.randomTerrain();
            default -> throw new IllegalArgumentException("A terrain must be chosen.");
        }
        if (pathToArmyOne.isEmpty() || pathToArmyTwo.isEmpty()) {
            alerts.displayAlertMustChooseTwoArmies();
        } else {
            SimulationController.loadArmyOne(pathToArmyOne);
            SimulationController.loadArmyTwo(pathToArmyTwo);
            SimulationController.loadTerrain(terrain);
            FXMLLoaderClass.goToSimulation(event);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            choiceBoxTerrain.getItems().removeAll(choiceBoxTerrain.getItems());
            choiceBoxTerrain.getItems().addAll("Plains", "Forest", "Hill", "Random terrain");
            choiceBoxTerrain.getSelectionModel().select("Plains");
            tableViewBattleArmies.setPlaceholder(new Label("No armies to display. Upload some armies to initiate a battle."));
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
