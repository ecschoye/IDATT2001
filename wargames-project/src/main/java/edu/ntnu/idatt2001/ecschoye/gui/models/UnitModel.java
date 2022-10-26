package edu.ntnu.idatt2001.ecschoye.gui.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class UnitModel {
    private SimpleStringProperty unit;
    private SimpleIntegerProperty amount;

    public UnitModel(String unit, int amount) {
        this.unit = new SimpleStringProperty(unit);
        this.amount = new SimpleIntegerProperty(amount);
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

    public Integer getAmount() {
        return amount.getValue();
    }

    public SimpleIntegerProperty amountProperty() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = new SimpleIntegerProperty(amount);
    }


}
