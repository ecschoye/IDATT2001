package edu.ntnu.idatt2001.ecschoye.gui.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ArmyModel {
    private SimpleStringProperty armyName;
    private SimpleStringProperty fileName;
    private SimpleIntegerProperty totalUnits;
    private SimpleIntegerProperty avgBaseAtt;
    private SimpleIntegerProperty totalHealth;

    public ArmyModel(String armyName, String fileName, int totalUnits, int avgBaseAtt, int totalHealth) {
        this.armyName = new SimpleStringProperty(armyName);
        this.fileName = new SimpleStringProperty(fileName);
        this.totalUnits = new SimpleIntegerProperty(totalUnits);
        this.avgBaseAtt = new SimpleIntegerProperty(avgBaseAtt);
        this.totalHealth = new SimpleIntegerProperty(totalHealth);
    }

    public String getFilePath() {
        return getFileName();
    }

    public int getAvgBaseAtt() {
        return avgBaseAtt.getValue();
    }

    public SimpleIntegerProperty avgBaseAttProperty() {
        return avgBaseAtt;
    }

    public void setAvgBaseAtt(int avgBaseAtt) {
        this.avgBaseAtt = new SimpleIntegerProperty(avgBaseAtt);
    }

    public String getFileName() {
        return fileName.getValue();
    }

    public SimpleStringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = new SimpleStringProperty(fileName);
    }

    public String getArmyName() {
        return armyName.getValue();
    }

    public SimpleStringProperty armyNameProperty() {
        return armyName;
    }

    public void setArmyName(String armyName) {
        this.armyName = new SimpleStringProperty(armyName);
    }

    public int getTotalUnits() {
        return totalUnits.getValue();
    }

    public SimpleIntegerProperty totalUnitsProperty() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = new SimpleIntegerProperty(totalUnits);
    }

    public int getTotalHealth() {
        return totalHealth.getValue();
    }

    public SimpleIntegerProperty totalHealthProperty() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = new SimpleIntegerProperty(totalHealth);
    }
}
