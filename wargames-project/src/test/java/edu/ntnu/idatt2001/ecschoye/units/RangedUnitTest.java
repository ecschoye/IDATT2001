package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class RangedUnitTest
 * @author Edvard Schøyen
 *
 */
class RangedUnitTest {
    /**
     * Checks that the attack bonus of the ranged unit is 5 in hill
     */
    @Test
    void getAttackBonusInHill() {
        Unit testUnit = new RangedUnit("Ranger", 100);
        assertEquals(5,testUnit.getAttackBonus(Terrain.HILL));
    }

    /**
     * Checks that the attack bonus of the ranged unit is 2 in forest
     */
    @Test
    void getAttackBonusInForest() {
        Unit testUnit = new RangedUnit("Ranger", 100);
        assertEquals(2,testUnit.getAttackBonus(Terrain.FOREST));
    }

    /**
     * Checks that the attack bonus of the ranged unit is 3 in plains
     */
    @Test
    void getAttackBonusInPlains() {
        Unit testUnit = new RangedUnit("Ranger", 100);
        assertEquals(3,testUnit.getAttackBonus(Terrain.PLAINS));
    }



    /**
     * Checks that the resist bonus of the ranged unit is 6,
     * then it gets attacked once and checks if the resist bonsus is reduced to 4.
     * It is then attacked once again to see if the resist bonus is reduced to its minimum, 2.
     */
    @Test
    void getResistBonusInHill() {
        Unit testUnit = new RangedUnit("Ranger", 100);
        Unit testUnit2 = new RangedUnit("Ranger", 100);
        assertEquals(6,testUnit.getResistBonus(Terrain.HILL));
        testUnit2.attack(testUnit,Terrain.HILL);
        assertEquals(4,testUnit.getResistBonus(Terrain.HILL));
        testUnit2.attack(testUnit,Terrain.HILL);
        assertEquals(2,testUnit.getResistBonus(Terrain.HILL));
    }

    /**
     * Checks that the resist bonus of the ranged unit is 6,
     * then it gets attacked once and checks if the resist bonsus is reduced to 4.
     * It is then attacked once again to see if the resist bonus is reduced to its minimum, 2.
     */
    @Test
    void getResistBonusInForest() {
        Unit testUnit = new RangedUnit("Ranger", 100);
        Unit testUnit2 = new RangedUnit("Ranger", 100);
        assertEquals(6,testUnit.getResistBonus(Terrain.HILL));
        testUnit2.attack(testUnit,Terrain.HILL);
        assertEquals(4,testUnit.getResistBonus(Terrain.HILL));
        testUnit2.attack(testUnit,Terrain.HILL);
        assertEquals(2,testUnit.getResistBonus(Terrain.HILL));
    }

    /**
     * Checks that the resist bonus of the ranged unit is 6,
     * then it gets attacked once and checks if the resist bonsus is reduced to 4.
     * It is then attacked once again to see if the resist bonus is reduced to its minimum, 2.
     */
    @Test
    void getResistBonusInPlains() {
        Unit testUnit = new RangedUnit("Ranger", 100);
        Unit testUnit2 = new RangedUnit("Ranger", 100);
        assertEquals(6,testUnit.getResistBonus(Terrain.HILL));
        testUnit2.attack(testUnit,Terrain.HILL);
        assertEquals(4,testUnit.getResistBonus(Terrain.HILL));
        testUnit2.attack(testUnit,Terrain.HILL);
        assertEquals(2,testUnit.getResistBonus(Terrain.HILL));
    }
}