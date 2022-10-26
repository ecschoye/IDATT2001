package edu.ntnu.idatt2001.ecschoye.unitfactory;

import edu.ntnu.idatt2001.ecschoye.units.*;

import java.util.ArrayList;

/**
 * Class UnitFactory
 * @author Edvard Schøyen
 *
 */
public class UnitFactory {
    /**
     * Unitfactory method that creates single units
     * Takes in unit type as string, unit name and health as parameters
     * Then uses a switch to create the corresponding unit
     * @param unit, String unit type
     * @param name, String unit name
     * @param health, int unit health
     * @return Unit
     */
    public Unit singleUnit(String unit, String name, int health){
        switch (unit.toLowerCase()) {
            case "infantry" -> {
                return new InfantryUnit(name, health);
            }
            case "ranged" -> {
                return new RangedUnit(name, health);
            }
            case "cavalry" -> {
                return new CavalryUnit(name, health);
            }
            case "commander" -> {
                return new CommanderUnit(name, health);
            }
            case "artillery" ->{
                return new ArtilleryUnit(name,health);
            }
            default -> throw new IllegalArgumentException("Invalid unit type");
        }
    }

    /**
     * Unitfactory method that can create several units
     * Creates an ArrayList Unit type, units
     * Takes in unit type as string, unit name, health and amount as parameters
     * Makes sure the amount is greater than 0
     * Then uses a for loop to create the given amount of the specific unit
     * and add them to the ArrayList units
     * @param unit, String unit type
     * @param name, String unit name
     * @param health, int unit health
     * @param amount, int unit amount
     * @return ArrayList units
     * @throws IllegalArgumentException
     */
    public ArrayList<Unit> multipleUnits(String unit, String name, int health, int amount) throws IllegalArgumentException{
        ArrayList<Unit> units = new ArrayList<>();
        if (amount <= 0){
            throw new IllegalArgumentException("Amount can not be less than zero.");
        }
        for (int i = 0; i < amount ; i++) {
            units.add(singleUnit(unit,name,health));
        }
        return units;
    }
}
