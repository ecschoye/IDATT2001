package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
import edu.ntnu.idatt2001.ecschoye.unitfactory.UnitFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class UnitTest
 * @author Edvard Schøyen
 *
 */
public class UnitTest {
    UnitFactory unitFactory = new UnitFactory();

    /**
     * Tests that the attack method reduces the health of the opponent
     * asserts that unit2 has less health than unit1 after the attack
     */
    @Test
    void attackTest() {
        Terrain terrain = Terrain.PLAINS;
        Unit unit1 = unitFactory.singleUnit("infantry","test",100);
        Unit unit2 = unitFactory.singleUnit("infantry","test",100);
        unit1.attack(unit2,terrain);
        assertTrue(unit1.getHealth()>unit2.getHealth() );
    }

    /**
     * Tests the getName method
     * asserts that the name we got is the same as expected
     */
    @Test
    void getNameTest() {
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals("test",unit.getName());
    }

    /**
     * Tests the getHealth method
     * asserts that the health we got is the same as expected
     */
    @Test
    void getHealthTest() {
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals(100,unit.getHealth());
    }

    @Test
    void incrementNumberTimesAttackedTest() {
        Terrain terrain = Terrain.randomTerrain();
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        Unit unit2 = unitFactory.singleUnit("infantry","test",100);
        assertEquals(0, unit.getNumberTimesAtt());
        unit2.attack(unit,terrain);
        assertEquals(1,unit.getNumberTimesAtt());
    }

    @Test
    void getNumberTimesAttTest() {
        Terrain terrain = Terrain.randomTerrain();
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        Unit unit2 = unitFactory.singleUnit("infantry","test",100);
        assertEquals(0, unit.getNumberTimesAtt());
    }

    @Test
    void getAttackTest() {
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals(15, unit.getAttack());
    }

    @Test
    void getArmorTest() {
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals(10, unit.getArmor());
    }

    @Test
    void setHealthTest() {
        Terrain terrain = Terrain.randomTerrain();
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        Unit unit2 = unitFactory.singleUnit("infantry","test",100);
        assertEquals(100, unit.getHealth());
        unit2.attack(unit,terrain);
        assertNotEquals(100,unit.getHealth());
        unit.setHealth(100);
        assertEquals(100, unit.getHealth());
    }

    @Test
    void convertToCsvFormatTest() {
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals("InfantryUnit,test,100",unit.convertToCsvFormat());
    }

    @Test
    void getAttackBonusInPlainsTest() {
        Terrain terrain = Terrain.PLAINS;
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals(2,unit.getAttackBonus(terrain));
    }

    @Test
    void getAttackBonusInForestTest() {
        Terrain terrain = Terrain.FOREST;
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals(4,unit.getAttackBonus(terrain));
    }

    @Test
    void getAttackBonusInHillTest() {
        Terrain terrain = Terrain.HILL;
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals(2,unit.getAttackBonus(terrain));
    }

    @Test
    void getResistBonusInPlainsTest() {
        Terrain terrain = Terrain.PLAINS;
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals(2,unit.getResistBonus(terrain));
    }

    @Test
    void getResistBonusInForestTest() {
        Terrain terrain = Terrain.FOREST;
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals(4,unit.getResistBonus(terrain));
    }

    @Test
    void getResistBonusInHillTest() {
        Terrain terrain = Terrain.HILL;
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals(2,unit.getResistBonus(terrain));
    }

    @Test
    void getUnitTypeTest() {
        Unit unit = unitFactory.singleUnit("infantry","test",100);
        assertEquals("Infantry",unit.getUnitType());
    }
}
