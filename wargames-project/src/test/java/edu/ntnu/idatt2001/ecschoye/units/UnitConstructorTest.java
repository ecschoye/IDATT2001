package edu.ntnu.idatt2001.ecschoye.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class UnitConstructorTest
 * @author Edvard Schøyen
 *
 */
public class UnitConstructorTest {
    /**
     * Tests if creating a unit with a blank name will throw an IllegalArgumentException
     */
    @Test
    void exceptionUnitTestingWithBlankName(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new InfantryUnit("", 100));
        assertEquals("Name can not be blank.", exception.getMessage());
    }
    /**
     * Tests if creating a unit with a whitespace name will throw an IllegalArgumentException
     */
    @Test
    void exceptionUnitTestingWithWhitespaceName(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new InfantryUnit("       ", 100));
        assertEquals("Name can not be blank.", exception.getMessage());
    }
    /**
     * Tests if creating a unit with a regular name will throw an IllegalArgumentException
     */
    @Test
    void exceptionUnitTestingWithRegularName(){
        InfantryUnit unit = assertDoesNotThrow(() -> new InfantryUnit("Footsoldier", 100));
        assertEquals("Footsoldier", unit.getName());
    }
    /**
     * Tests if creating a unit with negative health will throw an IllegalArgumentException
     */
    @Test
    void exceptionUnitTestingWithNegativeHealth(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new InfantryUnit("Footsoldier", -10));
        assertEquals("Health can not be less than 0.", exception.getMessage());
    }
}
