package edu.ntnu.idatt2001.ecschoye.gui.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ViewArmyModel {
    private SimpleStringProperty unit;
    private SimpleStringProperty name;
    private SimpleIntegerProperty health;
    private SimpleIntegerProperty attack;
    private SimpleIntegerProperty amount;

    public ViewArmyModel(String unit, String name, int health, int attack) {
        this.unit = new SimpleStringProperty(unit);
        this.name = new SimpleStringProperty(name);
        this.health = new SimpleIntegerProperty(health);
        this.attack = new SimpleIntegerProperty(attack);
    }

    public String getUnit() {
        return unit.getValue();
    }

    public SimpleStringProperty unitProperty() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = new SimpleStringProperty(unit);
    }

    public String getName() {
        return name.getValue();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public int getHealth() {
        return health.getValue();
    }

    public SimpleIntegerProperty healthProperty() {
        return health;
    }

    public void setHealth(int health) {
        this.health = new SimpleIntegerProperty(health);
    }

    public int getAttack() {
        return attack.getValue();
    }

    public SimpleIntegerProperty attackProperty() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = new SimpleIntegerProperty(attack);
    }


}
