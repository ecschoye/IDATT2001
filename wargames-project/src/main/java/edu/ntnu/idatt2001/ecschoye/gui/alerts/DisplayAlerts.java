package edu.ntnu.idatt2001.ecschoye.gui.alerts;

import javafx.scene.control.Alert;
/**
 * Class DisplayAlerts
 * @author Edvard Schøyen
 *
 */
public class DisplayAlerts {
    /**
     * Displays alert that something went wrong when creating the unit
     */
    public void displayAlertSomethingWentWrongWhenCreatingUnit() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Something went wrong.");
        alert.setHeaderText("");
        alert.setContentText("Make sure the health and amount are integers greater than 0.");
        alert.showAndWait();
    }


    /**
     * Displays alert that there must be at least two armies
     * in the register to go to battle menu
     */
    public void displayAlertMustAddArmies() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("You must add at least two armies.");
        alert.setHeaderText("");
        alert.setContentText("You must add at least two armies to go here.");
        alert.showAndWait();
    }

    /**
     * Displays alert that tells the user that an army must
     * have units to be added to the register
     */
    public void displayAlertMustContainUnits() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Army must contain units.");
        alert.setHeaderText("");
        alert.setContentText("An army must contain units. Please add some.");
        alert.showAndWait();
    }

    /**
     * Alert that tells the user that the army name is already in use
     */
    public void displayAlertArmyNameIsAlreadyInUse() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Army name is already in use.");
        alert.setHeaderText("");
        alert.setContentText("Army name is already in use. Please chose a different name.");
        alert.showAndWait();
    }

    /**
     * Alert that tells the user they have to set the simulation speed
     */
    public void displayAlertSetSimulationSpeed() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("You must set simulation speed");
        alert.setHeaderText("");
        alert.setContentText("You must choose speed for the simulation.");
        alert.showAndWait();
    }

    /**
     * Alert that tells the user that the same army can not fight itself
     */
    public void displayAlertChooseAnotherArmy() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Choose a different army.");
        alert.setHeaderText("");
        alert.setContentText("You can not choose the same army to fight itself.");
        alert.showAndWait();
    }

    /**
     * Alert that tells the user that they need to chose two armies to start a simulation
     */
    public void displayAlertMustChooseTwoArmies() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("You must choose two armies.");
        alert.setHeaderText("");
        alert.setContentText("You must choose two armies to start a simulation.");
        alert.showAndWait();
    }

    /**
     * Alert that tells the user they have to choose an army to select it for the battle
     */
    public void displayAlertMustChooseAnArmy() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("You must choose an army.");
        alert.setHeaderText("");
        alert.setContentText("You must select an army to choose it.");
        alert.showAndWait();
    }

    /**
     * Alert that tells the user that there's already an army
     * in the register with that name
     */
    public void displayAlertRegisterContainsArmy() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Choose a different army");
        alert.setHeaderText("");
        alert.setContentText("There is already an army with this name in the register.");
        alert.showAndWait();
    }

    /**
     * Alert that tells the user there has to be armies in the register to remove an army
     */
    public void displayAlertUploadArmyToRemove() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Upload an army");
        alert.setHeaderText("");
        alert.setContentText("You must upload an army to remove it.");
        alert.showAndWait();
    }

    /**
     * Alert that tells the user there has to be armies in the register to delete an army
     */
    public void displayAlertUploadArmyToDelete() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Upload an army");
        alert.setHeaderText("");
        alert.setContentText("You must upload an army to delete it.");
        alert.showAndWait();
    }

    /**
     * Alert that tells the user there has to be armies in the register to view an army
     */
    public void displayAlertUploadArmy() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Upload an army");
        alert.setHeaderText("");
        alert.setContentText("You must upload an army to view it.");
        alert.showAndWait();
    }

}
