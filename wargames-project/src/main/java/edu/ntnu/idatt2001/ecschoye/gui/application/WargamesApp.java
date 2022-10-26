package edu.ntnu.idatt2001.ecschoye.gui.application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Class WargamesApp
 * @author Edvard Schøyen
 *
 */
public class WargamesApp extends Application {

    public static void main (String[] args){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WargamesApp.class.getResource("/fxml/index.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1300,800);
        primaryStage.setTitle("Wargames!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
