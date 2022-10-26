package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtilleryUnitTest {

    /**
     * Checks that the attack bonus of the artillery unit is 10 in hill
     */
    @Test
    void getAttackBonusInHillTest() {
        Unit testUnit = new ArtilleryUnit("Raider", 100);
        assertEquals(10,testUnit.getAttackBonus(Terrain.HILL));
    }

    /**
     * Checks that the attack bonus of the artillery unit is 0 in forest
     */
    @Test
    void getAttackBonusInForestTest() {
        Unit testUnit = new ArtilleryUnit("Raider", 100);
        assertEquals(0,testUnit.getAttackBonus(Terrain.FOREST));
    }

    /**
     * Checks that the attack bonus of the artillery unit is 5 in plains
     */
    @Test
    void getAttackBonusInPlainsTest() {
        Unit testUnit = new ArtilleryUnit("Raider", 100);
        assertEquals(5,testUnit.getAttackBonus(Terrain.PLAINS));
    }

    /**
     * Checks that the resist bonus of the cavalry unit is 10 in hill
     */
    @Test
    void getResistBonusInHill() {
        Unit testUnit = new ArtilleryUnit("Raider", 100);
        assertEquals(10,testUnit.getResistBonus(Terrain.HILL));
    }

    /**
     * Checks that the resist bonus of the artillery unit is 10 in forest
     */
    @Test
    void getResistBonusInForest() {
        Unit testUnit = new ArtilleryUnit("Raider", 100);
        assertEquals(10,testUnit.getResistBonus(Terrain.FOREST));
    }

    /**
     * Checks that the resist bonus of the artillery unit is 5 in plains
     */
    @Test
    void getResistBonusInPlains() {
        Unit testUnit = new ArtilleryUnit("Raider", 100);
        assertEquals(5,testUnit.getResistBonus(Terrain.PLAINS));
    }


    @Test
    void attacksEveryOtherTurn() {
        Unit testUnit = new ArtilleryUnit("Tank", 100);
        Unit testUnit2 = new CommanderUnit("Tank", 10000);
        testUnit.attack(testUnit2,Terrain.HILL);
        System.out.println(testUnit2.getHealth());
        testUnit.attack(testUnit2,Terrain.HILL);
        System.out.println(testUnit2.getHealth());
        testUnit.attack(testUnit2,Terrain.HILL);
        System.out.println(testUnit2.getHealth());

    }


}