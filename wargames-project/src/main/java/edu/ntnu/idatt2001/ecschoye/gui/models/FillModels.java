package edu.ntnu.idatt2001.ecschoye.gui.models;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import edu.ntnu.idatt2001.ecschoye.gui.models.ArmyModel;
import edu.ntnu.idatt2001.ecschoye.gui.models.UnitModel;
import edu.ntnu.idatt2001.ecschoye.gui.models.ViewArmyModel;
import edu.ntnu.idatt2001.ecschoye.register.Register;
import edu.ntnu.idatt2001.ecschoye.units.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FillModels {
    private final ObservableList<ArmyModel> observableArmyList = FXCollections.observableArrayList();
    private final ObservableList<ViewArmyModel> observableViewArmyList = FXCollections.observableArrayList();
    private final ObservableList<UnitModel> observableUnitList = FXCollections.observableArrayList();

    public ObservableList<ArmyModel> fillArmyModel (){
        int amountOfArmies = Register.armyRegister.getAmountOfArmies();
        int i = 0;
        while (i < amountOfArmies) {
            ArmyModel armyModel = new ArmyModel(
                    Register.armyRegister.getArmies().get(i).getFileName(),
                    Register.armyRegister.getArmies().get(i).getArmyFilePath(),
                    Register.armyRegister.getArmies().get(i).getAmountOfTotalUnits(),
                    Register.armyRegister.getArmies().get(i).getAverageBaseAttack(),
                    Register.armyRegister.getArmies().get(i).getTotalHealthOfArmy());
            observableArmyList.add(armyModel);
            i++;
        }
        return observableArmyList;
    }

    public ObservableList<ViewArmyModel> fillViewArmyModel(Army army) {
        for (int i = 0; i < army.getAmountOfTotalUnits(); i++) {
            ViewArmyModel viewArmyModelArtillery = new ViewArmyModel(
                    army.getAllUnits().get(i).getUnitType(),
                    army.getAllUnits().get(i).getName(),
                    army.getAllUnits().get(i).getHealth(),
                    army.getAllUnits().get(i).getAttack()
            );
            observableViewArmyList.add(viewArmyModelArtillery);
        }
        return observableViewArmyList;
    }


    public ObservableList<UnitModel> fillUnitModel (Army army){
        for (int i = 0; i < army.getAmountOfDistinctiveUnits(); i++) {
            UnitModel unitModel = new UnitModel(
                    army.getArrayListWithDistinctiveUnits().get(i),
                    army.getAmountOfUnitType(army.getArrayListWithDistinctiveUnits().get(i)));
            observableUnitList.add(unitModel);
        }
        return observableUnitList;
    }
}
