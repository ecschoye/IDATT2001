package edu.ntnu.idatt2001.ecschoye.filehandling;

import edu.ntnu.idatt2001.ecschoye.battle.Army;
import edu.ntnu.idatt2001.ecschoye.unitfactory.UnitFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FilehandlerTest {

    /**
     * Test to read army from file
     * asserts that the army it reads from the file has units
     */
    @Test
    void readFromFileTest() {
        Filehandler filehandler = new Filehandler();
        Army army = filehandler.readFromFile("src/main/resources/Test/ReadFromFileArmy.csv");
        boolean hasUnits = army.hasUnits();
        assertTrue(hasUnits);
    }

    /**
     * Test to write army to file
     * writes army to file then reads it to a new army object
     * then asserts that the read army has units
     * then asserts that the written army and read army have the same amount of units
     */
    @Test
    void writeArmyToFileTest() {
        Filehandler filehandler = new Filehandler();
        Army TestWriteArmyToFileArmy = new Army("TestWriteArmyToFileArmy");
        UnitFactory unitFactory = new UnitFactory();
        TestWriteArmyToFileArmy.addAll(unitFactory.multipleUnits("infantry","Footsoldier",100,150));
        TestWriteArmyToFileArmy.addAll(unitFactory.multipleUnits("ranged","Archer",100,69));
        filehandler.writeArmyToFile(TestWriteArmyToFileArmy,"src/main/resources/Test/WriteToFileTestArmy.csv");

        Army army = filehandler.readFromFile("src/main/resources/Test/WriteToFileTestArmy.csv");
        boolean hasUnits = army.hasUnits();
        assertTrue(hasUnits);
        assertEquals(TestWriteArmyToFileArmy.getAmountOfTotalUnits(),army.getAmountOfTotalUnits());
    }

}