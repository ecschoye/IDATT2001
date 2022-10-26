package edu.ntnu.idatt2001.ecschoye.battle;

import edu.ntnu.idatt2001.ecschoye.unitfactory.UnitFactory;
import edu.ntnu.idatt2001.ecschoye.units.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class ArmyTest
 * @author Edvard Schøyen
 *
 */
class ArmyTest {
    private static final UnitFactory unitFactory = new UnitFactory();

    /**
     * Test to get name of army
     */
    @Test
    void getNameTest() {
        Army test = new Army("Test");
        assertEquals("Test",test.getName());
        assertNotEquals("test",test.getName());
    }

    /**
     * Test to add unit to army
     */
    @Test
    void addTest() {
        Army testArmy = new Army("Test army");
        testArmy.add(new InfantryUnit("test unit",10));
        assertEquals(1,testArmy.getAmountOfTotalUnits());
    }

    /**
     * Test to add multiple units to army
     */
    @Test
    void addAllTest() {
        ArrayList<Unit> units = new ArrayList<>();
        Army test = new Army("test");
        test.addAll(unitFactory.multipleUnits("infantry","test",100,2));
        assertEquals(2,test.getAllUnits().size());
    }

    /**
     * Tests removing units from army
     */
    @Test
    void removeTest() {
        Army testArmy = new Army("Test army");
        Unit testUnit = new InfantryUnit("test unit",10);
        testArmy.add(testUnit);
        assertEquals(1,testArmy.getAllUnits().size());
        testArmy.remove(testUnit);
        assertEquals(0,testArmy.getAllUnits().size());
    }

    /**
     * Test to see if army has units
     */
    @Test
    void hasUnitsTest() {
        Army testArmy = new Army("Test army");
        Unit testUnit = new InfantryUnit("test unit",10);
        testArmy.add(testUnit);
        assertTrue(testArmy.hasUnits());
        testArmy.remove(testUnit);
        assertFalse(testArmy.hasUnits());
    }

    /**
     * Tests to get all units from an army
     * also has tests to get distinctive unit types
     */
    @Test
    void getAllUnitsTest() {
        Army test = new Army("test");
        test.addAll(unitFactory.multipleUnits("infantry","Footman",100,10));
        test.addAll(unitFactory.multipleUnits("cavalry","Knight",100,11));
        test.addAll(unitFactory.multipleUnits("ranged","Ranged",100,10));
        test.addAll(unitFactory.multipleUnits("artillery","Ranged",100,20));
        test.add(unitFactory.singleUnit("commander","Commander",100));
        assertEquals(52,test.getAllUnits().size());
        assertEquals(10,test.getInfantryUnits().size());
        assertEquals(10,test.getRangedUnits().size());
        assertEquals(11,test.getCavalryUnits().size());
        assertEquals(1, test.getCommanderUnits().size());
        assertEquals(20, test.getArtilleryUnits().size());
        assertNotEquals(2, test.getCommanderUnits().size());
    }

    /**
     * Test to get a random unit from an army
     */
    @Test
    void getRandomTest() {
        Army test = new Army("test"); //Army with units
        Army test2 = new Army("test"); //Army with no units
        test.add(new InfantryUnit("test",1));
        test.add(new InfantryUnit("test",2));
        test.add(new InfantryUnit("test",3));
        assertNotNull(test.getRandom());
        assertNull(test2.getRandom());
    }

    /**
     * Test to get filepath of army
     */
    @Test
    void getFilePathTest() {
        Army getFilePathArmy = new Army("TestGetFilePathArmy");
        UnitFactory unitFactory = new UnitFactory();
        getFilePathArmy.addAll(unitFactory.multipleUnits("infantry","Footsoldier",100,100));
        getFilePathArmy.getFilePath();
        assertEquals("src/main/resources/csv/TestGetFilePathArmy.csv", getFilePathArmy.getArmyFilePath());
        assertNotEquals("src/main/resources/csv/TestGetFilePathArmy", getFilePathArmy.getArmyFilePath());
    }

    /**
     * Test to get filename of army, which is also the armyname
     */
    @Test
    void getFileNameTest() {
        Army getFileNameArmy = new Army("TestGetFileNameArmy");
        UnitFactory unitFactory = new UnitFactory();
        getFileNameArmy.addAll(unitFactory.multipleUnits("infantry","Footsoldier",100,100));
        assertEquals("TestGetFileNameArmy",getFileNameArmy.getFileName());
    }


    /**
     * Test to get the infantry units of an army
     */
    @Test
    void getInfantryUnitsTest() {
        int infantryUnitAmount = 100;
        int rangedUnitAmount = 120;
        Army getInfantryUnitsArmy = new Army("InfantryUnits");
        getInfantryUnitsArmy.addAll(unitFactory.multipleUnits("infantry","infantry",100,infantryUnitAmount));
        getInfantryUnitsArmy.addAll(unitFactory.multipleUnits("ranged","ranged",100,rangedUnitAmount));
        getInfantryUnitsArmy.addAll(unitFactory.multipleUnits("cavalry","cavalry",100,130));
        getInfantryUnitsArmy.addAll(unitFactory.multipleUnits("commander","commander",100,105));
        assertEquals(infantryUnitAmount,getInfantryUnitsArmy.getInfantryUnits().size());
        assertNotEquals(rangedUnitAmount, getInfantryUnitsArmy.getInfantryUnits().size());

    }

    /**
     * Test to get the cavalry units of an army
     */
    @Test
    void getCavalryUnitsTest() {
        int cavalryUnitAmount = 100;
        int rangedUnitAmount = 120;
        Army getCavalryUnitsArmy = new Army("CavalryUnits");
        getCavalryUnitsArmy.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        getCavalryUnitsArmy.addAll(unitFactory.multipleUnits("ranged","ranged",100,rangedUnitAmount));
        getCavalryUnitsArmy.addAll(unitFactory.multipleUnits("cavalry","cavalry",100,cavalryUnitAmount));
        getCavalryUnitsArmy.addAll(unitFactory.multipleUnits("commander","commander",100,104));
        assertEquals(cavalryUnitAmount,getCavalryUnitsArmy.getCavalryUnits().size());
        assertNotEquals(rangedUnitAmount,getCavalryUnitsArmy.getCavalryUnits().size());
    }

    /**
     * Test to get the ranged units of an army
     */
    @Test
    void getRangedUnitsTest() {
        int rangedUnitAmount = 100;
        int infantryUnitAmount = 120;
        Army getRangedUnits = new Army("RangedUnits");
        getRangedUnits.addAll(unitFactory.multipleUnits("infantry","infantry",100,infantryUnitAmount));
        getRangedUnits.addAll(unitFactory.multipleUnits("ranged","ranged",100,rangedUnitAmount));
        getRangedUnits.addAll(unitFactory.multipleUnits("cavalry","cavalry",100,102));
        getRangedUnits.addAll(unitFactory.multipleUnits("commander","commander",100,104));
        assertEquals(rangedUnitAmount,getRangedUnits.getRangedUnits().size());
        assertNotEquals(infantryUnitAmount,getRangedUnits.getRangedUnits().size());
    }

    /**
     * Test to get the commander units of an army
     */
    @Test
    void getCommanderUnitsTest() {
        int commanderUnitAmount = 100;
        int rangedUnitAmount = 120;
        Army getCommanderUnits = new Army("CommanderUnits");
        getCommanderUnits.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        getCommanderUnits.addAll(unitFactory.multipleUnits("ranged","ranged",100,rangedUnitAmount));
        getCommanderUnits.addAll(unitFactory.multipleUnits("cavalry","cavalry",100,130));
        getCommanderUnits.addAll(unitFactory.multipleUnits("commander","commander",100,commanderUnitAmount));
        assertEquals(commanderUnitAmount,getCommanderUnits.getCommanderUnits().size());
        assertNotEquals(rangedUnitAmount,getCommanderUnits.getCommanderUnits().size());
    }

    /**
     * Test to get the artillery units of an army
     */
    @Test
    void getArrayListWithDistinctiveUnitsTest() {
        Army getArrayListWithDistinctiveUnits = new Army("DistinctiveUnits");
        getArrayListWithDistinctiveUnits.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        getArrayListWithDistinctiveUnits.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        getArrayListWithDistinctiveUnits.addAll(unitFactory.multipleUnits("cavalry","cavalry",100,130));
        getArrayListWithDistinctiveUnits.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        assertEquals(4,getArrayListWithDistinctiveUnits.getArrayListWithDistinctiveUnits().size());
        assertNotEquals(5, getArrayListWithDistinctiveUnits.getArrayListWithDistinctiveUnits().size());
    }

    /**
     * Test to get an arraylist with distinctive unit names
     */
    @Test
    void getArrayListWithDistinctiveUnitNamesTest() {
        Army getArrayListWithDistinctiveUnitNames = new Army("DistinctiveUnitNames");
        getArrayListWithDistinctiveUnitNames.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        getArrayListWithDistinctiveUnitNames.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        getArrayListWithDistinctiveUnitNames.addAll(unitFactory.multipleUnits("cavalry","cavalry",100,130));
        getArrayListWithDistinctiveUnitNames.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        getArrayListWithDistinctiveUnitNames.addAll(unitFactory.multipleUnits("commander","command",100,100));
        getArrayListWithDistinctiveUnitNames.addAll(unitFactory.multipleUnits("commander","commandest",100,100));
        assertEquals(6,getArrayListWithDistinctiveUnitNames.getArrayListWithDistinctiveUnitNames().size());
        assertNotEquals(16,getArrayListWithDistinctiveUnitNames.getArrayListWithDistinctiveUnitNames().size());
    }

    /**
     * Test to get the health of distinctive units
     */
    @Test
    void getHealthOfDistinctiveUnitTest() {
        Army getHealthOfDistinctiveUnit = new Army("HealthOfUnit");
        getHealthOfDistinctiveUnit.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        getHealthOfDistinctiveUnit.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        getHealthOfDistinctiveUnit.addAll(unitFactory.multipleUnits("cavalry","cavalry",50,130));
        getHealthOfDistinctiveUnit.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        assertEquals(unitFactory.singleUnit("Cavalry","health",50).getHealth(),getHealthOfDistinctiveUnit.getHealthOfDistinctiveUnit("cavalry"));
        assertNotEquals(unitFactory.singleUnit("Cavalry","health",100).getHealth(),getHealthOfDistinctiveUnit.getHealthOfDistinctiveUnit("cavalry"));
    }

    /**
     * Test to get the attack of distinctive units
     */
    @Test
    void getAttackOfDistinctiveUnitTest() {
        Army getAttackOfDistinctiveUnit = new Army("AttackOfUnit");
        getAttackOfDistinctiveUnit.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        getAttackOfDistinctiveUnit.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        getAttackOfDistinctiveUnit.addAll(unitFactory.multipleUnits("cavalry","cavalry",50,130));
        getAttackOfDistinctiveUnit.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        getAttackOfDistinctiveUnit.addAll(unitFactory.multipleUnits("infantry","attacker",100,1));
        assertEquals(15,getAttackOfDistinctiveUnit.getAttackOfDistinctiveUnit("attacker"));
    }


    /**
     * Test to get the amount of unit by type
     */
    @Test
    void getAmountOfUnitTypeTest() {
        Army getAmountOfUnitType = new Army("AmountOfUnitType");
        Army getAmountOfUnitType2 = new Army("AmountOfUnitType");
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("infantry","infanterist",100,101));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("cavalry","cavalry",50,130));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("infantry","attacker",100,1));
        getAmountOfUnitType2.addAll(unitFactory.multipleUnits("infantry","attacker",100,1));
        assertEquals(130, getAmountOfUnitType.getAmountOfUnitType("Cavalry"));
        assertEquals(102, getAmountOfUnitType.getAmountOfUnitType("Infantry"));
    }

    /**
     * Test to get the amount of distinctive units by type
     */
    @Test
    void getAmountOfDistinctiveUnitsTest() {
        Army getAmountOfDistinctiveUnits = new Army("AmountOfUnit");
        getAmountOfDistinctiveUnits.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        getAmountOfDistinctiveUnits.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        getAmountOfDistinctiveUnits.addAll(unitFactory.multipleUnits("cavalry","cavalry",50,130));
        getAmountOfDistinctiveUnits.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        getAmountOfDistinctiveUnits.addAll(unitFactory.multipleUnits("infantry","attacker",100,1));
        assertEquals(4,getAmountOfDistinctiveUnits.getAmountOfDistinctiveUnits());
    }

    /**
     * Test to get the distinctive units by name
     * //TODO: one flaw is that it does not seperate by unit type so two units with same name but different unit type will be counted as one
     */
    @Test
    void getAmountOfDistinctiveUnitNamesTest() {
        Army getAmountOfUnitType = new Army("AmountOfUnitType");
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("cavalry","cavalry",50,130));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("infantry","attacker",100,1));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("ranged","attacker",100,1));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("infantry","attakest",100,1));
        getAmountOfUnitType.addAll(unitFactory.multipleUnits("infantry","attacked",100,1));
        assertEquals(7,getAmountOfUnitType.getAmountOfDistinctiveUnitNames());
    }


    /**
     * Test to get total health of army
     */
    @Test
    void getTotalHealthOfArmyTest() {
        Army totalHealthOfArmy = new Army("TotalHealth");
        totalHealthOfArmy.addAll(unitFactory.multipleUnits("infantry","infantry",100,100));
        totalHealthOfArmy.addAll(unitFactory.multipleUnits("ranged","ranged",100,100));
        totalHealthOfArmy.addAll(unitFactory.multipleUnits("cavalry","cavalry",100,100));
        totalHealthOfArmy.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        totalHealthOfArmy.addAll(unitFactory.multipleUnits("infantry","attacker",100,100));
        assertEquals(50000,totalHealthOfArmy.getTotalHealthOfArmy());
    }

    /**
     * Test to get average base attack of army
     */
    @Test
    void getAverageBaseAttackTest() {
        Army getAverageBaseAttack = new Army("AverageBaseAttack");
        getAverageBaseAttack.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        getAverageBaseAttack.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        getAverageBaseAttack.addAll(unitFactory.multipleUnits("cavalry","cavalry",50,130));
        getAverageBaseAttack.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        getAverageBaseAttack.addAll(unitFactory.multipleUnits("infantry","attacker",100,1));
        assertEquals(18,getAverageBaseAttack.getAverageBaseAttack());
    }

    //TODO: finish these tests

    /**
     * Test to get army file path with .csv ending to access file
     */
    @Test
    void getArmyFilePathTest() {
        Army testArmy = new Army("test");
        testArmy.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        testArmy.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        testArmy.addAll(unitFactory.multipleUnits("cavalry","cavalry",50,130));
        testArmy.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        testArmy.addAll(unitFactory.multipleUnits("infantry","attacker",100,1));
        assertEquals("src/main/resources/csv/test.csv",testArmy.getArmyFilePath());

    }

    /**
     * Test to get file path but not the .csv ending of the file
     */
    @Test
    void testGetFilePathTest() {
        Army testArmy = new Army("test");
        testArmy.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        testArmy.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        testArmy.addAll(unitFactory.multipleUnits("cavalry","cavalry",50,130));
        testArmy.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        testArmy.addAll(unitFactory.multipleUnits("infantry","attacker",100,1));
        assertEquals("src/main/resources/csv/test",testArmy.getFilePath());
    }

    /**
     * Test to get the name of the file
     */
    @Test
    void testGetFileName() {
        Army testArmy = new Army("test");
        testArmy.addAll(unitFactory.multipleUnits("infantry","infantry",100,101));
        testArmy.addAll(unitFactory.multipleUnits("ranged","ranged",100,102));
        testArmy.addAll(unitFactory.multipleUnits("cavalry","cavalry",50,130));
        testArmy.addAll(unitFactory.multipleUnits("commander","commander",100,100));
        testArmy.addAll(unitFactory.multipleUnits("infantry","attacker",100,1));
        assertEquals("test",testArmy.getFileName());
    }

}