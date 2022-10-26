package edu.ntnu.idatt2001.ecschoye.gui.controllers;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import edu.ntnu.idatt2001.ecschoye.battle.Battle;
import edu.ntnu.idatt2001.ecschoye.filehandling.Filehandler;
import edu.ntnu.idatt2001.ecschoye.gui.alerts.DisplayAlerts;
import edu.ntnu.idatt2001.ecschoye.register.Register;
import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
import edu.ntnu.idatt2001.ecschoye.gui.FXMLLoaderClass;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


/**
 * Class SimulationController
 * @author Edvard Schøyen
 *
 */
public class SimulationController implements Initializable {

    @FXML private Label labelInformation;
    @FXML private Button btnFastSpeed;
    @FXML private Button btnNormalSpeed;
    @FXML private TextArea textAreaBattleStats;
    @FXML private Button btnStartBattle;
    @FXML private Label labelArmyOne;
    @FXML private Label labelArmyTwo;
    @FXML private Button btnResetArmies;
    @FXML private Button btnSaveArmies;

    private final DisplayAlerts alerts = new DisplayAlerts();
    private static final Filehandler filehandler = new Filehandler();
    private static Army armyOne;
    private static Army armyTwo;
    private static Terrain terrain;
    private int sleep = -1;
    private static String pathToArmyOne;
    private static String pathToArmyTwo;

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
     * takes in the path to army one as parameter and creates armyone
     * and stores the filepath to a new string
     * @param path
     */
    public static void loadArmyOne(String path) {
        armyOne = filehandler.readFromFile(path);
        pathToArmyOne = path;
    }

    /**
     * takes in the path to army two as parameter and creates armytwo
     * and stores the filepath to a new string
     * @param path
     */
    public static void loadArmyTwo(String path) {
        armyTwo = filehandler.readFromFile(path);
        pathToArmyTwo = path;
    }

    /**
     * takes in the terrain and stores it
     * @param t
     */
    public static void loadTerrain(Terrain t) {
        terrain = t;
    }

    /**
     * Checks if the sleep time is valid and displays an alert if not
     * Clears the TextArea and creates a battle object using armyOne, armyTwo and terrain
     * simulates the battle and uses the outputBattleStatsToTextArea-method to
     * display the simulation
     * disables the speed button and enables the others
     */
    public void startSimulation() {
        if (sleep < 0) {
            alerts.displayAlertSetSimulationSpeed();
        } else {
            textAreaBattleStats.clear();
            Battle battle = new Battle(armyOne, armyTwo, terrain);
            battle.simulate();
            outputBattleStatsToTextArea(battle.getBattleStats());
            btnSaveArmies.setDisable(false);
            btnResetArmies.setDisable(false);
            btnStartBattle.setDisable(true);
            btnNormalSpeed.setDisable(true);
            btnFastSpeed.setDisable(true);
        }
        btnResetArmies.setDisable(true);
        btnSaveArmies.setDisable(true);
    }

    /**
     * Method for outputing the battlestats to the user
     * First checks if the sleep time is greater than 0
     * Creates a new thread with runnable to update the TextArea
     * @param battleStats
     */
    public void outputBattleStatsToTextArea(StringBuilder battleStats) {
        boolean sleepBoolean = sleep > 0;
        Thread thread = new Thread(() -> {
            Runnable runnable = () -> {};
            Scanner scanner = new Scanner(String.valueOf(battleStats));
            String newLine = "\n";
            StringBuilder output = new StringBuilder();
            while (scanner.hasNextLine()) {
                try {
                    if (sleepBoolean) {
                        textAreaBattleStats.appendText(scanner.nextLine() + newLine);
                        Thread.sleep(sleep);
                    } else {
                        output.append(scanner.nextLine()).append(newLine);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Platform.runLater(runnable);
            }
            if (!sleepBoolean) {
                textAreaBattleStats.appendText(output.toString());
            }
            btnResetArmies.setDisable(false);
            btnSaveArmies.setDisable(false);
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Sets the background color of the TextArea depending on the terrain
     */
    public void chooseTerrain() {
        if (terrain == Terrain.FOREST) textAreaBattleStats.setStyle("-fx-control-inner-background:#5d7d1a; -fx-font-family: Consolas; -fx-highlight-fill: #556c45; -fx-highlight-text-fill: #98fb98; -fx-text-fill: #29380e; ");
        if (terrain == Terrain.HILL) textAreaBattleStats.setStyle("-fx-control-inner-background:#6b8d6b; -fx-font-family: Consolas; -fx-highlight-fill: #b2cbb0; -fx-highlight-text-fill: #000000; -fx-text-fill: #747a74; ");
        if (terrain == Terrain.PLAINS) textAreaBattleStats.setStyle("-fx-control-inner-background:#488649; -fx-font-family: Consolas; -fx-highlight-fill: #5d7d1a; -fx-highlight-text-fill: #9f3f3f; -fx-text-fill: #121810; ");
    }

    /**
     * Sets the speed the text will appear in the TextArea
     */
    public void setBtnNormalSpeed() {
        labelInformation.setText("");
        sleep = 50;
        btnStartBattle.setDisable(false);
        btnNormalSpeed.setDisable(true);
        btnFastSpeed.setDisable(false);
        labelInformation.setText("Speed set to normal speed.");
    }

    /**
     * Sets it so the text will appear in the TextArea immediately
     */
    public void setBtnFastSpeed() {
        labelInformation.setText("");
        sleep = 0;
        btnStartBattle.setDisable(false);
        btnFastSpeed.setDisable(true);
        btnNormalSpeed.setDisable(false);
        labelInformation.setText("Speed set to fast speed.");
    }

    /**
     * Method to save the winning army and its current state to the register
     * Removes both armies from the register
     * Adds the army with units left to the register to update the unit stats
     * @throws FileNotFoundException
     */
    public void saveArmies() throws FileNotFoundException {
        labelInformation.setText("");
        Register.armyRegister.deleteArmy(armyOne);
        Register.armyRegister.deleteArmy(armyTwo);
        if (armyOne.hasUnits()) Register.armyRegister.addArmy(armyOne);
        if (armyTwo.hasUnits()) Register.armyRegister.addArmy(armyTwo);
        btnSaveArmies.setDisable(true);
        labelInformation.setText("The winning army has been saved ...");
    }


    /**
     * Resets the stats of both armies
     */
    public void resetArmies() {
        labelInformation.setText("");
        armyOne = filehandler.readFromFile(pathToArmyOne);
        armyTwo = filehandler.readFromFile(pathToArmyTwo);
        textAreaBattleStats.clear();
        btnStartBattle.setDisable(true);
        btnResetArmies.setDisable(true);
        btnSaveArmies.setDisable(true);
        btnNormalSpeed.setDisable(false);
        btnFastSpeed.setDisable(false);
        labelInformation.setText("The armies have been reset.");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelArmyOne.setText(armyOne.getName());
        labelArmyTwo.setText(armyTwo.getName());
        textAreaBattleStats.setEditable(false);
        btnStartBattle.setDisable(true);
        btnResetArmies.setDisable(true);
        btnSaveArmies.setDisable(true);
        chooseTerrain();
    }
}
