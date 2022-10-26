package edu.ntnu.idatt2001.ecschoye.filehandling;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import edu.ntnu.idatt2001.ecschoye.unitfactory.UnitFactory;
import edu.ntnu.idatt2001.ecschoye.units.*;

import java.io.*;
import java.nio.file.InvalidPathException;


/**
 * Class Filehandler
 * @author Edvard Schøyen
 *
 */
public class Filehandler {
    /**
     * The read army from file method
     * Checks if the String parameter ends with .csv, if not it throws and InvalidPathException
     * Reads the csv file line by line
     * Finds the army name from the first line and creates an army object
     * After that it makes sure the next line != null with a while loop
     * For each time it goes through the loop it will add the line to an array,
     * which it then uses the 0, 1 and 2 index to get Unit type, name and health to add an unit to the army.
     * This goes on until there are no more units to add.
     * @param resourcePath
     * @return
     */
    public Army readFromFile(String resourcePath){
        if (!(resourcePath.endsWith(".csv"))) throw new InvalidPathException(resourcePath, "File must be of type csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(resourcePath))) {
            String line;
            String delimiter = ",";
            String armyName = reader.readLine();
            Army army = new Army(armyName);
            while ((line = reader.readLine()) != null){
                String[] units = line.split(delimiter);
                String unitType = units[0];
                String unitName = units[1];
                int unitHealth = Integer.parseInt(units[2]);
                switch (unitType) {
                    case "InfantryUnit" -> army.add(new InfantryUnit(unitName, unitHealth));
                    case "CavalryUnit" -> army.add(new CavalryUnit(unitName, unitHealth));
                    case "RangedUnit" -> army.add(new RangedUnit(unitName, unitHealth));
                    case "CommanderUnit" -> army.add(new CommanderUnit(unitName, unitHealth));
                    case "ArtilleryUnit" -> army.add(new ArtilleryUnit(unitName, unitHealth));
                    default -> throw new IllegalArgumentException("An error occured while adding this unit. Please try again with a different unit.");
                }
            }
            reader.close();
            return army;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * The writeArmyToFile method
     * First checks if the army object exists.
     * Then it checks if the resourcePath ends with .csv, to make sure it will be stored as a csv file
     * Then it will for each unit in the army, store the unit type, unit name and unit health
     * @param army
     * @param resourcePath
     */
    public void writeArmyToFile(Army army, String resourcePath){
        if (army == null) throw new IllegalArgumentException("Army can not be null");
        if (!(resourcePath.endsWith(".csv"))) throw new InvalidPathException(resourcePath, "File must be of type csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resourcePath))){
            writer.write(army.getName() + "\n");
            army.getAllUnits().forEach(unit -> {
                try {
                    writer.write(unit.convertToCsvFormat());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
