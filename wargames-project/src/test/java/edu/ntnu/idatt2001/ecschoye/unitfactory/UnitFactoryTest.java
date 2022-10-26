package edu.ntnu.idatt2001.ecschoye.unitfactory;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitFactoryTest {

    /**
     * unitFactoryTest
     * Uses assertEquals to make sure that the amount of units is the same as expected
     * Has to manually change the expected number due to the UnitFactory only adding one unit at a time
     *
     */
    @Test
    void unitFactoryTest() {
        UnitFactory unitFactory = new UnitFactory();
        Army testUnitFactoryArmy = new Army("testUnitFactoryArmy");
        testUnitFactoryArmy.add(unitFactory.singleUnit("infantry","footsoldier",100));
        assertEquals(1, testUnitFactoryArmy.getAllUnits().size());
    }

    /**
     * unitFactoryTest2
     * Uses assertEquals to make sure that the amount of units is the same as expected
     * Due to being able to add several units of a specific unit type at a time, the test lets you change the amount of units
     * This will update the number of units being added to the army
     *
     */
    @Test
    void UnitFactoryTestWithSeveralOfOneTypeOfUnit() {
        int amountOfInfantryUnits = 10; //change this int to the amount of units
        UnitFactory unitFactory = new UnitFactory();
        Army testUnitFactoryArmy = new Army("testUnitFactoryArmy");
        testUnitFactoryArmy.addAll(unitFactory.multipleUnits("infantry","footsoldier",100,amountOfInfantryUnits));
        int amountOfInfantryUnitsInArmy = testUnitFactoryArmy.getInfantryUnits().size();
        assertEquals(amountOfInfantryUnits, amountOfInfantryUnitsInArmy);
    }

    /**
     * unitFactoryTest2
     * Uses assertEquals to make sure that the amount of units is the same as expected
     * Due to being able to add several units of a specific unit type at a time, the test lets you change the amount of units
     * This will update the number of units being added to the army
     *
     */
    @Test
    void UnitFactoryTestWithSeveralOfTypesOfUnits() {
        int amountOfInfantryUnits = 10; //change this int to the amount of units
        int amountOfRangedUnits = 10; //change this int to the amount of units
        int amountOfCavalryUnits = 10; //change this int to the amount of units
        int amountOfUnits = amountOfInfantryUnits + amountOfRangedUnits + amountOfCavalryUnits;
        UnitFactory unitFactory = new UnitFactory();
        Army testUnitFactoryArmy = new Army("testUnitFactoryArmy");
        testUnitFactoryArmy.addAll(unitFactory.multipleUnits("infantry","footsoldier",100,amountOfInfantryUnits));
        testUnitFactoryArmy.addAll(unitFactory.multipleUnits("ranged","ranger",100,amountOfRangedUnits));
        testUnitFactoryArmy.addAll(unitFactory.multipleUnits("cavalry","knight",100,amountOfCavalryUnits));
        int amountOfInfantryUnitsInArmy = testUnitFactoryArmy.getInfantryUnits().size();
        int amountOfRangedUnitsInArmy = testUnitFactoryArmy.getInfantryUnits().size();
        int amountOfCavalryUnitsInArmy = testUnitFactoryArmy.getInfantryUnits().size();
        int amountOfUnitsInArmy = amountOfInfantryUnitsInArmy + amountOfRangedUnitsInArmy + amountOfCavalryUnitsInArmy;
        assertEquals(amountOfUnits, amountOfUnitsInArmy);
    }

}