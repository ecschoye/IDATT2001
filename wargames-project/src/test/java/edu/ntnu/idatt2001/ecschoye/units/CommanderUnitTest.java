package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class CommanderUnitTest
 * @author Edvard Schøyen
 *
 */
class CommanderUnitTest {
    /**
     * Checks that the attack bonus of the commander unit is 6 in hill
     */
    @Test
    void getAttackBonusInHill() {
        Unit testUnit = new CommanderUnit("Commander", 100);
        assertEquals(6,testUnit.getAttackBonus(Terrain.HILL));
    }

    /**
     * Checks that the attack bonus of the commander unit is 6 in forest
     */
    @Test
    void getAttackBonusInForest() {
        Unit testUnit = new CommanderUnit("Commander", 100);
        assertEquals(6,testUnit.getAttackBonus(Terrain.FOREST));
    }

    /**
     * Checks that the attack bonus of the commander unit is 8 in plains
     */
    @Test
    void getAttackBonusInPlains() {
        Unit testUnit = new CommanderUnit("Commander", 100);
        assertEquals(8,testUnit.getAttackBonus(Terrain.PLAINS));
    }

    /**
     * Checks that the resist bonus of the commander unit is 2 in hill
     */
    @Test
    void getResistBonusInHill() {
        Unit testUnit = new CommanderUnit("Commander", 100);
        assertEquals(2,testUnit.getResistBonus(Terrain.HILL));
    }

    /**
     * Checks that the resist bonus of the commander unit is 0 in forest
     */
    @Test
    void getResistBonusInForest() {
        Unit testUnit = new CommanderUnit("Commander", 100);
        assertEquals(0,testUnit.getResistBonus(Terrain.FOREST));
    }

    /**
     * Checks that the resist bonus of the commander unit is 2 in plains
     */
    @Test
    void getResistBonusPlains() {
        Unit testUnit = new CommanderUnit("Commander", 100);
        assertEquals(2,testUnit.getResistBonus(Terrain.PLAINS));
    }
}