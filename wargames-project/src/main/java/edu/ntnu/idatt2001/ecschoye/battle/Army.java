package edu.ntnu.idatt2001.ecschoye.battle;

import edu.ntnu.idatt2001.ecschoye.units.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class Army
 * @author Edvard Schøyen
 *
 */
public class Army {
    private final String name;
    private ArrayList<Unit> units = new ArrayList<Unit>();

    /**
     * Default constructor
     * @param name
     * @throws IllegalArgumentException
     */
    public Army(String name) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Name can not be blank.");
        this.name = name;
    }

    /**
     * Constructor. Takes in a list of units.
     * @param name
     * @param units
     * @throws IllegalArgumentException
     */
    public Army(String name, ArrayList<Unit> units) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Name can not be blank.");
        this.name = name;
        this.units = units;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a Unit to the list if the list does not contain the unit.
     * @param unit
     */
    public void add(Unit unit){
        if (!units.contains(unit)){
            units.add(unit);
        }
    }

    /**
     * Adds a list of Unit to the units list.
     * @param units
     */
    public void addAll(ArrayList<Unit> units){
        this.units.addAll(units);
    }

    /**
     * Removes a specific unit.
     * @param unit
     */
    public void remove(Unit unit){
            this.units.remove(unit);
    }

    /**
     * Checks if the list of units has Units
     * @return
     */
    public boolean hasUnits(){
        return !units.isEmpty();
    }

    /**
     *
     * @return units
     */
    public ArrayList<Unit> getAllUnits(){
        return this.units;
    }

    /**
     * Returns a random Unit from a list
     * If no Units in list, return null
     * @return Unit
     */
    public Unit getRandom(){
        if (hasUnits()){
            return this.units.get(new Random().nextInt(this.units.size()));
        }
        return null;
    }

    /**
     * Returns all infantry units
     * @return
     */
    public ArrayList<Unit> getInfantryUnits(){
        ArrayList<Unit> infantryUnits = new ArrayList<Unit>();
        units.stream().filter(unit -> unit instanceof InfantryUnit).forEach(infantryUnits::add);
        return infantryUnits;
    }

    /**
     * Returns arraylist with all cavalry units
     * @return
     */
    public ArrayList<Unit> getCavalryUnits(){
        ArrayList<Unit> cavalryUnits = new ArrayList<Unit>();
        units.stream().filter(unit -> unit instanceof CavalryUnit).forEach(cavalryUnits::add);
        units.stream().filter(unit -> unit instanceof CommanderUnit).forEach(cavalryUnits::remove);
        return cavalryUnits;
    }

    /**
     * Returns arraylist with all ranged units
     * @return
     */
    public ArrayList<Unit> getRangedUnits(){
        ArrayList<Unit> rangedUnits = new ArrayList<Unit>();
        units.stream().filter(unit -> unit instanceof RangedUnit).forEach(rangedUnits::add);
        return rangedUnits;
    }

    /**
     * Returns arraylist with all commander units
     * @return
     */
    public ArrayList<Unit> getCommanderUnits(){
        ArrayList<Unit> commanderUnits = new ArrayList<Unit>();
        units.stream().filter(unit -> unit instanceof CommanderUnit).forEach(commanderUnits::add);
        return commanderUnits;
    }

    /**
     * Returns arraylist with all artillery units
     * @return
     */
    public ArrayList<Unit> getArtilleryUnits() {
        ArrayList<Unit> artilleryUnits = new ArrayList<>();
        units.stream().filter(unit -> unit instanceof ArtilleryUnit).forEach(artilleryUnits::add);
        return artilleryUnits;
    }

    /**
     * Returns an arraylist with all distinctive units
     * @return
     */
    public ArrayList<String> getArrayListWithDistinctiveUnits(){
        return getAllUnits().stream().map(Unit::getUnitType).distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Returns an arraylist with all distinctive unit names
     * @return
     */
    public ArrayList<String> getArrayListWithDistinctiveUnitNames(){
        return getAllUnits().stream().map(Unit::getName).distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Returns an arraylist with all distinctive unit types
     * @param unitName
     * @return
     */
    public ArrayList<String> getArrayListWithDistinctiveUnitType(String unitName) {
        ArrayList<Unit> unitType = getAllUnits().stream().filter(unit -> unit.getName().equals(unitName)).collect(Collectors.toCollection(ArrayList::new));
        return unitType.stream().map(Unit::getUnitType).distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Returns health of distinctive unit
     * @param unitName
     * @return
     */
    public int getHealthOfDistinctiveUnit(String unitName) {
        ArrayList<Unit> unitType = getAllUnits().stream().filter(unit -> unit.getName().equals(unitName)).collect(Collectors.toCollection(ArrayList::new));
        return unitType.stream().mapToInt(Unit::getHealth).sum()/unitType.size();
    }

    /**
     * Returns attack of distinctive unit
     * @param unitName
     * @return
     */
    public int getAttackOfDistinctiveUnit(String unitName) {
        ArrayList<Unit> unitType = getAllUnits().stream().filter(unit -> unit.getName().equals(unitName)).collect(Collectors.toCollection(ArrayList::new));
        return unitType.stream().mapToInt(Unit::getAttack).sum()/unitType.size();
    }

    /**
     * Returns amount of unit type
     * @param unitType
     * @return
     */
    public int getAmountOfUnitType(String unitType){
        return (int) getAllUnits().stream().filter(unit -> unit.getUnitType().equals(unitType)).count();
    }

    /**
     * Returns amount of distinctive units as integer
     * @return
     */
    public int getAmountOfDistinctiveUnits(){
        return (int) getAllUnits().stream().map(Unit::getUnitType).distinct().count();
    }

    /**
     * Returns amount of distinctive unit names as integer
     * @return
     */
    public int getAmountOfDistinctiveUnitNames(){
        return (int) getAllUnits().stream().map(Unit::getName).distinct().count();
    }

    /**
     * Gets total amount of units in army
     * @return
     */
    public int getAmountOfTotalUnits(){
        return getAllUnits().size();
    }

    /**
     *
     * @return
     */
    public ArrayList<String> arrayListWithUnitNames(){
        return getAllUnits().stream().map(Unit::getName).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Returns total health of army as integer
     * @return
     */
    public int getTotalHealthOfArmy(){
        return getAllUnits().stream().mapToInt(Unit::getHealth).sum();
    }

    /**
     * Returns the average base attack of army as integer
     * @return
     */
    public int getAverageBaseAttack (){
        return (getAllUnits().stream().mapToInt(Unit::getAttack).sum())/getAllUnits().size();
    }

    /**
     *
     * @param list
     * @return
     */
    public String arrayListToString(ArrayList<Unit> list){
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    /**
     * Returns the army file path as a string
     * @return
     */
    public String getArmyFilePath(){
        return this.getFilePath() + ".csv";
    }

    public String getFilePath(){
        return "src/main/resources/csv/" + this.getName();
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder results = new StringBuilder(": ");
        for (Unit unit : units){
            results.append("\n").append(unit.getClass().getSimpleName()).append(" ").append(unit.getName()).append(" with ").append(unit.getHealth()).append("hp");
        }
        return "The army, " + name + ", with remaining units " + results;
    }

    public String getFileName() {
        return this.getName();
    }


    /**
     * Checks if two objects are equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

}
