package edu.ntnu.idatt2001.ecschoye.battle;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
import edu.ntnu.idatt2001.ecschoye.unitfactory.UnitFactory;
import edu.ntnu.idatt2001.ecschoye.units.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    UnitFactory unitFactory = new UnitFactory();

    /**
     * Test of the simulate method
     * asserts that one of the armies will be dead after the simulation
     */
    @Test
    void simulate() {
        Terrain terrain = Terrain.randomTerrain();
        Army testOne = new Army("Test");
        Army testTwo = new Army("Test");
        testOne.addAll(unitFactory.multipleUnits("infantry","test",100,100));
        testOne.addAll(unitFactory.multipleUnits("ranged","test",100,100));
        testOne.addAll(unitFactory.multipleUnits("cavalry","test",100,100));
        testOne.add(unitFactory.singleUnit("commander","test",200));
        testTwo.addAll(unitFactory.multipleUnits("infantry","test",100,100));
        testTwo.addAll(unitFactory.multipleUnits("ranged","test",100,100));
        testTwo.addAll(unitFactory.multipleUnits("cavalry","test",100,100));
        testTwo.add(unitFactory.singleUnit("commander","test",200));
        Battle battle = new Battle(testOne,testTwo,terrain);
        battle.simulate();
        assertTrue(testOne.hasUnits() && !testTwo.hasUnits() || !testOne.hasUnits() && testTwo.hasUnits());
    }

    /**
     * Asserts that unit is dead when health is 0 or less
     */
    @Test
    void isDead() {
        Unit test = new InfantryUnit("isdead",1);
        Unit test2 = new InfantryUnit("isdead",1);
        test.setHealth(-2);
        test2.setHealth(-1);
        assertTrue(Battle.isDead(test));
        assertTrue(Battle.isDead(test2));
    }


}