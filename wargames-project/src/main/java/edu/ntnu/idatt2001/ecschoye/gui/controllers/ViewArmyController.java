package edu.ntnu.idatt2001.ecschoye.gui.controllers;

import edu.ntnu.idatt2001.ecschoye.filehandling.Filehandler;
import edu.ntnu.idatt2001.ecschoye.gui.alerts.DisplayAlerts;
import edu.ntnu.idatt2001.ecschoye.gui.models.FillModels;
import edu.ntnu.idatt2001.ecschoye.gui.models.ViewArmyModel;
import edu.ntnu.idatt2001.ecschoye.gui.FXMLLoaderClass;
import edu.ntnu.idatt2001.ecschoye.register.Register;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Class ViewArmyController
 * @author Edvard Schøyen
 *
 */
public class ViewArmyController implements Initializable {
    @FXML private TableView<ViewArmyModel> tableViewThisArmy;
    @FXML private TableColumn<ViewArmyModel, String> columnUnit;
    @FXML private TableColumn<ViewArmyModel, String> columnUnitName;
    @FXML private TableColumn<ViewArmyModel, Integer> columnUnitHealth;
    @FXML private TableColumn<ViewArmyModel, Integer> columnUnitAttack;
    @FXML private final ObservableList<ViewArmyModel> observableList = FXCollections.observableArrayList();
    @FXML private Label labelArmyName;

    private final DisplayAlerts alerts = new DisplayAlerts();
    private final Filehandler filehandler = new Filehandler();
    private static String filePath;

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
     * Sets the filepath
     * @param path, String path to file
     */
    public static void setFilePath(String path) {
        filePath = path;
    }

    /**
     * Updates the tableview with information
     * about the army using the UnitModel
     */
    public void updateTable() {
        emptyTable();
        FillModels fillModels = new FillModels();
        labelArmyName.setText(filehandler.readFromFile(filePath).getName());
        tableViewThisArmy.setItems(fillModels.fillViewArmyModel(filehandler.readFromFile(filePath)));
    }

    /**
     * Empties the tableview
     */
    public void emptyTable() {
        labelArmyName.setText("");
        tableViewThisArmy.getItems().clear();
        tableViewThisArmy.setPlaceholder(new Label("No army to display. Upload an army to see the units."));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tableViewThisArmy.setPlaceholder(new Label("No army to display. Upload an army to see the units."));
            columnUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
            columnUnitName.setCellValueFactory(new PropertyValueFactory<>("name"));
            columnUnitHealth.setCellValueFactory(new PropertyValueFactory<>("health"));
            columnUnitAttack.setCellValueFactory(new PropertyValueFactory<>("attack"));
            labelArmyName.setText("");
            updateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
