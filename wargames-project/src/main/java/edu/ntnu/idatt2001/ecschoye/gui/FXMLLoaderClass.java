package edu.ntnu.idatt2001.ecschoye.gui;

import edu.ntnu.idatt2001.ecschoye.gui.application.WargamesApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class FXMLLoaderClass {

    @FXML
    public static void goToLoadArmy(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WargamesApp.class.getResource("/fxml/uploadArmyFromFile.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1300,800);
        stage.setTitle("Load armies");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public static void goToAddArmy(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WargamesApp.class.getResource("/fxml/addArmy.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1300,800);
        stage.setTitle("Add army");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public static void goToViewArmies(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WargamesApp.class.getResource("/fxml/viewArmies.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1300,800);
        stage.setTitle("View armies");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public static void goToBattleMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WargamesApp.class.getResource("/fxml/battleMenu.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1300,800);
        stage.setTitle("Battle menu");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public static void goToViewArmy(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WargamesApp.class.getResource("/fxml/viewArmy.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1300,800);
        stage.setTitle("View army!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public static void goToSimulation(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WargamesApp.class.getResource("/fxml/simulation.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1300,800);
        stage.setTitle("Battle simulation!");
        stage.setScene(scene);
        stage.show();
    }

}
