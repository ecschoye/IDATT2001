package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class InfantryUnitTest
 * @author Edvard Schøyen
 *
 */
class InfantryUnitTest {
    /**
     * Checks that the attack bonus of the infantry unit is 2 in hill
     */
    @Test
    void getAttackBonusInHill() {
        Unit testUnit = new InfantryUnit("Infantry", 100);
        assertEquals(2,testUnit.getAttackBonus(Terrain.HILL));
    }

    /**
     * Checks that the attack bonus of the infantry unit is 4 in forest
     */
    @Test
    void getAttackBonusInForest() {
        Unit testUnit = new InfantryUnit("Infantry", 100);
        assertEquals(4,testUnit.getAttackBonus(Terrain.FOREST));
    }

    /**
     * Checks that the attack bonus of the infantry unit is 2 in plains
     */
    @Test
    void getAttackBonusInPlains() {
        Unit testUnit = new InfantryUnit("Infantry", 100);
        assertEquals(2,testUnit.getAttackBonus(Terrain.PLAINS));
    }


    /**
     * Checks that the resist bonus of the infantry unit is 2 in hill
     */
    @Test
    void getResistBonusInHill() {
        Unit testUnit = new InfantryUnit("Infantry", 100);
        assertEquals(2,testUnit.getResistBonus(Terrain.HILL));
    }

    /**
     * Checks that the resist bonus of the infantry unit is 4 in forest
     */
    @Test
    void getResistBonusInForest() {
        Unit testUnit = new InfantryUnit("Infantry", 100);
        assertEquals(4,testUnit.getResistBonus(Terrain.FOREST));
    }

    /**
     * Checks that the resist bonus of the infantry unit is 2 in plains
     */
    @Test
    void getResistBonusInPlains() {
        Unit testUnit = new InfantryUnit("Infantry", 100);
        assertEquals(2,testUnit.getResistBonus(Terrain.PLAINS));
    }
}