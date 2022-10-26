package edu.ntnu.idatt2001.ecschoye.register;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import edu.ntnu.idatt2001.ecschoye.filehandling.Filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.lang.Object.*;

/**
 * Class ArmyRegister
 * @author Edvard Schøyen
 *
 */
public final class ArmyRegister {
    private final ArrayList<Army> armies;
    private final Filehandler filehandler = new Filehandler();
    /**
     * Constructor for the ArmyRegister
     */
    public ArmyRegister() {
        armies = new ArrayList<>();
    }

    /**
     * Takes in an army as a parameter
     * Then adds the army to the register
     * and writes the army to a .csv file
     * @param army
     */
    public void addArmy(Army army){
        armies.add(army);
        filehandler.writeArmyToFile(army,army.getArmyFilePath());
    }

    /**
     * Gets the armies
     * @return
     */
    public ArrayList<Army> getArmies() {
        return armies;
    }

    /**
     * Returns the amount of armies in the register
     * @return
     */
    public int getAmountOfArmies() {
        int amountOfArmies = 0;
        for (Army army : armies) {
            amountOfArmies++;
        }
        return amountOfArmies;
    }


    /**
     * Method to remove army from the register
     * Takes in army as parameter
     * Removes any army that has the same name as the army parameter from the register
     * @param army
     * @throws FileNotFoundException
     */
    public void removeArmy(Army army) {
        armies.removeIf(armyInArmy -> armyInArmy.getName().equals(army.getName()));
    }

    /**
     * Method to empty the register
     * clears the armies arraylist
     */
    public void removeAllArmies() {
        armies.clear();
    }


    /**
     * Method to delete a specific army from the register and its file
     * Takes in army as a parameter
     * Removes army from armies if the army parameter has the same name
     * Will then get the filepath of the removed army and delete its file if it exists
     * @param army
     * @throws FileNotFoundException
     */
    public void deleteArmy(Army army) throws FileNotFoundException {
        File file = new File(army.getArmyFilePath());
        if (file.exists()){
            try {
                armies.removeIf(armyInArmy -> armyInArmy.getName().equals(army.getName()));
                file.delete();
            } catch (Exception e) {
                throw new FileNotFoundException("File not found");
            }
        } else {
            throw new FileNotFoundException("File not found");
        }
    }

    /**
     * Method to delete all armies in the register
     * removes all armies from the armies arraylist
     * then deletes all files from the csv folder
     * @throws FileNotFoundException
     */
    public void deleteAllArmies() throws FileNotFoundException {
        armies.clear();
        File directory = new File("src/main/resources/csv");
        for (File file : Objects.requireNonNull(directory.listFiles())){
            try{
                if (!file.isDirectory()){
                    file.delete();
                }
            } catch (Exception e) {
                throw new FileNotFoundException("File not found");
            }
        }
    }

    /**
     * Lists all army names in an arraylist
     * @return
     */
    public ArrayList<String> listAllArmyNames() {
        return armies.stream().map(Army::getName).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     *  Checks if the armies register is empty or not
     * @return boolean
     */
    public boolean isNotEmpty() {
        return !armies.isEmpty();
    }

    public boolean isReadyForBattle() {
        return armies.size() >= 2;
    }
}
