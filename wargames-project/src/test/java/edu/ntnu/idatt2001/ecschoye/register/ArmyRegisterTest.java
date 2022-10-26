package edu.ntnu.idatt2001.ecschoye.register;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import edu.ntnu.idatt2001.ecschoye.unitfactory.UnitFactory;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ArmyRegisterTest {
    UnitFactory unitFactory = new UnitFactory();

    /**
     * Test to add army to the register
     * asserts true that the register contains the added army
     * @throws FileNotFoundException
     */
    @Test
    void addArmy() throws FileNotFoundException {
        Army army = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Register.armyRegister.addArmy(army);
        assertTrue(Register.armyRegister.getArmies().contains(army));
        Register.armyRegister.deleteArmy(army);
    }

    /**
     * Test to remove army to the register
     * asserts true that the register contains the added army
     * asserts false that the register contains the added army after removing it
     * @throws FileNotFoundException
     */
    @Test
    void removeArmy() {
        Army army = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Register.armyRegister.addArmy(army);
        assertTrue(Register.armyRegister.getArmies().contains(army));
        Register.armyRegister.removeArmy(army);
        assertFalse(Register.armyRegister.getArmies().contains(army));
    }

    /**
     * Test to remove all armies from the register
     * starts by adding three armies
     * then asserts true that the register contains all three armies
     * then after using the removeAllArmies()- method
     * it asserts false when checking if it contains the armies
     * also checks with assertEquals to see that the expected number of armies is 0
     */
    @Test
    void removeAllArmies() {
        Army army = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Army army2 = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Army army3 = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Register.armyRegister.addArmy(army);
        Register.armyRegister.addArmy(army2);
        Register.armyRegister.addArmy(army3);
        assertTrue(Register.armyRegister.getArmies().contains(army));
        assertTrue(Register.armyRegister.getArmies().contains(army2));
        assertTrue(Register.armyRegister.getArmies().contains(army3));
        Register.armyRegister.removeAllArmies();
        assertFalse(Register.armyRegister.getArmies().contains(army));
        assertFalse(Register.armyRegister.getArmies().contains(army2));
        assertFalse(Register.armyRegister.getArmies().contains(army3));
        assertEquals(0, Register.armyRegister.getArmies().size());
    }


    /**
     * Test to get the armies
     * assertEquals asserts that the size of the register is as expected
     */
    @Test
    void getArmies() {
        Army army = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Army army2 = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Army army3 = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Register.armyRegister.addArmy(army);
        Register.armyRegister.addArmy(army2);
        Register.armyRegister.addArmy(army3);
        assertEquals(3,Register.armyRegister.getArmies().size());
    }

    /**
     * Test to get the amount of armies
     * assertEquals asserts that the amount of armies in the register is as expected
     */
    @Test
    void getAmountOfArmies() {
        Army army = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Army army2 = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Army army3 = new Army("army",unitFactory.multipleUnits("infantry","unit",100,100));
        Register.armyRegister.addArmy(army);
        Register.armyRegister.addArmy(army2);
        Register.armyRegister.addArmy(army3);
        assertEquals(3,Register.armyRegister.getAmountOfArmies());

    }

    /**
     * Test to delete an army from the register
     * starts by adding three armies to the register an assert that
     * is the correct amount of armies in the register
     * then removes on army and asserts that the amount of armies in
     * the register has been reduced by one
     * then removes the two remaining armies and asserts that the
     * amount of armies in the register is 0
     * @throws FileNotFoundException
     */
    @Test
    void deleteArmy() throws FileNotFoundException {
        Army testArmy = new Army("testArmy",unitFactory.multipleUnits("infantry","unit",100,100));
        Army testArmy2 = new Army("testArmy2",unitFactory.multipleUnits("infantry","unit",100,100));
        Army testArmy3 = new Army("testArmy3",unitFactory.multipleUnits("infantry","unit",100,100));
        Register.armyRegister.addArmy(testArmy);
        Register.armyRegister.addArmy(testArmy2);
        Register.armyRegister.addArmy(testArmy3);
        assertEquals(3,Register.armyRegister.getAmountOfArmies());
        Register.armyRegister.deleteArmy(testArmy);
        assertEquals(2,Register.armyRegister.getAmountOfArmies());
        Register.armyRegister.deleteArmy(testArmy2);
        Register.armyRegister.deleteArmy(testArmy3);
        assertEquals(0,Register.armyRegister.getAmountOfArmies());

    }

    /**
     * Test to delete an army from the register
     * starts by adding three armies to the register an assert that
     * is the correct amount of armies in the register
     * then removes all the armies and asserts that the
     * amount of armies in the register is 0
     * @throws FileNotFoundException
     */
    @Test
    void deleteAllArmies() throws FileNotFoundException {
        Army testArmy = new Army("testArmy",unitFactory.multipleUnits("infantry","unit",100,100));
        Army testArmy2 = new Army("testArmy2",unitFactory.multipleUnits("infantry","unit",100,100));
        Army testArmy3 = new Army("testArmy3",unitFactory.multipleUnits("infantry","unit",100,100));
        Register.armyRegister.addArmy(testArmy);
        Register.armyRegister.addArmy(testArmy2);
        Register.armyRegister.addArmy(testArmy3);
        assertEquals(3,Register.armyRegister.getAmountOfArmies());
        Register.armyRegister.deleteAllArmies();
        assertEquals(0,Register.armyRegister.getAmountOfArmies());
    }

}