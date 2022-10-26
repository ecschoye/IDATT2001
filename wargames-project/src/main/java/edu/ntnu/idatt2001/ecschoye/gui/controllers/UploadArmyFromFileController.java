package edu.ntnu.idatt2001.ecschoye.gui.controllers;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import edu.ntnu.idatt2001.ecschoye.filehandling.Filehandler;
import edu.ntnu.idatt2001.ecschoye.gui.FXMLLoaderClass;
import edu.ntnu.idatt2001.ecschoye.gui.alerts.DisplayAlerts;
import edu.ntnu.idatt2001.ecschoye.gui.models.FillModels;
import edu.ntnu.idatt2001.ecschoye.gui.models.UnitModel;
import edu.ntnu.idatt2001.ecschoye.register.Register;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Class UploadArmyFromFileController
 * @author Edvard Schøyen
 *
 */
public class UploadArmyFromFileController implements Initializable {

    @FXML public Label labelToFilePath;
    @FXML private Button btnRemoveArmy;
    @FXML private Button btnAddArmyToRegister;
    @FXML private TableView<UnitModel> tableViewArmyPreview;
    @FXML private TableColumn<UnitModel, String> columnUnit;
    @FXML private TableColumn<UnitModel, Integer> columnAmount;
    @FXML private Label labelUploadedFile;
    @FXML private Label labelArmyName;
    @FXML private Stage stage;
    private String filePath;
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
     * Opens filechooser and lets the user choose an army to upload
     * If the file is not a csv file an alert will show up
     * If it is a csv file the army wil be added to the register and
     * the tableview will be updated
     */
    public void openFileChooser() {
        filePath = "";
        String fileName;
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose file");
        File file = fc.showOpenDialog(stage);
        if (file == null) {
            throw new IllegalArgumentException("File is null. Please upload a different file.");
        }
        filePath = file.getAbsolutePath();
        fileName = file.getName();
        if (!fileName.endsWith(".csv")){
            labelUploadedFile.setText("File must be a csv file.");
            emptyTable();
        } else {
        labelUploadedFile.setText(fileName);
        labelToFilePath.setText(filePath);
        updateTable();
        btnAddArmyToRegister.setDisable(false);
        btnRemoveArmy.setDisable(false);
        }
    }

    /**
     * Checks if the army is in the register and removes it if it is
     */
    public void removeArmy(){
        if (Register.armyRegister.listAllArmyNames().contains(filehandler.readFromFile(filePath).getName())){
            Register.armyRegister.removeArmy(filehandler.readFromFile(filePath));
        }
        emptyTable();
        filePath = "";
        labelUploadedFile.setText("No file");
        btnRemoveArmy.setDisable(true);
        btnAddArmyToRegister.setDisable(true);
    }

    /**
     * Updates the tableview with information
     * about the army using the UnitModel
     */
    public void updateTable() {
        emptyTable();
        Army army = filehandler.readFromFile(filePath);
        labelArmyName.setText(army.getName());
        FillModels fillModels = new FillModels();
        tableViewArmyPreview.setItems(fillModels.fillUnitModel(army));
    }

    /**
     * Empties the tableview
     */
    public void emptyTable() {
        labelArmyName.setText("");
        labelToFilePath.setText("");
        tableViewArmyPreview.getItems().clear();
        tableViewArmyPreview.setPlaceholder(new Label("No army to display. Upload an army to see the units."));
    }

    /**
     * Reads army from filepath and creates the army object
     * If the register already contains this army an alert will show up and the tableview will be emptied.
     * If it is not already in the register it will be added to it
     */
    public void addArmy () {
        Army army = filehandler.readFromFile(filePath);
        if (Register.armyRegister.listAllArmyNames().contains(army.getName())) {
            emptyTable();
            labelUploadedFile.setText("");
            btnAddArmyToRegister.setDisable(true);
            btnRemoveArmy.setDisable(true);
            alerts.displayAlertRegisterContainsArmy();
        } else {
            btnAddArmyToRegister.setDisable(true);
            Register.armyRegister.addArmy(army);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tableViewArmyPreview.setPlaceholder(new Label("No army to display. Upload an army to see the units."));
            columnUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
            columnAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            btnAddArmyToRegister.setDisable(true);
            btnRemoveArmy.setDisable(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
