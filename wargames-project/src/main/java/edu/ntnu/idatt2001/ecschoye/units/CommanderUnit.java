package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;

/**
 * Class CommanderUnit
 * @author Edvard Schøyen
 *
 */
public class CommanderUnit extends CavalryUnit {
    /**
     * Constructor for the Commander unit
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for the Commander unit
     * @param name
     * @param health
     */
    public CommanderUnit(String name, int health) {
        super(name, health,25, 5);
    }


    /**
     * Gets attack bonus
     * increments number of times attacked each time it's attacked
     * if the terrain is plains its first attack will be 8 instead of 6
     * if it has attacked the attack bonus drops from 8 to 4 if the terrain is plains,
     * and 6 to 2 if not plains
     * @param terrain
     * @return int, attack bonus
     */
    @Override
    public int getAttackBonus(Terrain terrain){
        return super.getAttackBonus(terrain);
    }

    /**
     * Gets resist bonus
     * Gets no resist bonus if the terrain is forest
     * if terrain is not forest it gets +2 resist bonus
     * @param terrain
     * @return int, resist bonus
     */
    @Override
    public int getResistBonus(Terrain terrain){
        return super.getResistBonus(terrain);
    }
}
