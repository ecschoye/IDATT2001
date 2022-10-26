package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class CavalryUnitTest
 * @author Edvard Schøyen
 *
 */
public class CavalryUnitTest {


    /**
     * Checks that the attack bonus of the cavalry unit is 6 in hill
     */
    @Test
    void getAttackBonusInHill() {
        Unit testUnit = new CavalryUnit("Raider", 100);
        assertEquals(6,testUnit.getAttackBonus(Terrain.HILL));
    }

    /**
     * Checks that the attack bonus of the cavalry unit is 6 in forest
     */
    @Test
    void getAttackBonusInForest() {
        Unit testUnit = new CavalryUnit("Raider", 100);
        assertEquals(6,testUnit.getAttackBonus(Terrain.FOREST));
    }

    /**
     * Checks that the attack bonus of the cavalry unit is 8 in plains
     */
    @Test
    void getAttackBonusInPlains() {
        Unit testUnit = new CavalryUnit("Raider", 100);
        assertEquals(8,testUnit.getAttackBonus(Terrain.PLAINS));
    }

    /**
     * Checks that the resist bonus of the cavalry unit is 2 in hill
     */
    @Test
    void getResistBonusInHill() {
        Unit testUnit = new CavalryUnit("Raider", 100);
        assertEquals(2,testUnit.getResistBonus(Terrain.HILL));
    }

    /**
     * Checks that the resist bonus of the cavalry unit is 0 in forest
     */
    @Test
    void getResistBonusInForest() {
        Unit testUnit = new CavalryUnit("Raider", 100);
        assertEquals(0,testUnit.getResistBonus(Terrain.FOREST));
    }

    /**
     * Checks that the resist bonus of the cavalry unit is 2 in plains
     */
    @Test
    void getResistBonusInPlains() {
        Unit testUnit = new CavalryUnit("Raider", 100);
        assertEquals(2,testUnit.getResistBonus(Terrain.PLAINS));
    }

    /**
     * test to check cavalry units bonus damage
     * will have 6 attack bonus in the first attack, then 2 attack bonus in the later attacks
     */
    @Test
    public void bonusAttackDoesExtraDamage(){
        Unit testUnit = new CavalryUnit("Orc", 25);
        assertEquals(8, testUnit.getAttackBonus(Terrain.PLAINS));
        assertEquals(4, testUnit.getAttackBonus(Terrain.PLAINS));
        assertNotEquals(8, testUnit.getAttackBonus(Terrain.PLAINS));
    }


    /**
     * Checks if cavalry unit's bonus damage is reduced from 6 to 2 after one attack
     */
    @Test
    void CavalryBonusDamageAfterOneAttackTest(){
        Unit testUnit1 = new CavalryUnit("Knight", 100);
        Unit testUnit2 = new CavalryUnit("Raider", 100);
        testUnit1.attack(testUnit2,Terrain.PLAINS);
        assertEquals(4, testUnit1.getAttackBonus(Terrain.PLAINS));
    }

    /**
     * Checks if cavalry unit's bonus damage is still 2 after two attacks
     */
    @Test
    void CavalryBonusDamageAfterTwoAttacksTest(){
        Unit testUnit1 = new CavalryUnit("Knight", 100);
        Unit testUnit2 = new CavalryUnit("Raider", 100);
        testUnit1.attack(testUnit2,Terrain.PLAINS);
        testUnit1.attack(testUnit2,Terrain.PLAINS);
        assertEquals(4, testUnit1.getAttackBonus(Terrain.PLAINS));
    }

}
