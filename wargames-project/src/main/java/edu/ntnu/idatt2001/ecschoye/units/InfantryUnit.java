package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;

/**
 * Class InfantryUnit
 * @author Edvard Schøyen
 *
 */
public class InfantryUnit extends Unit{
    /**
     * Constructor for the Infantry unit
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }


    /**
     * Constructor for the Infantry unit
     * @param name
     * @param health
     */
    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);
    }


    /**
     * Gets the attack bonus
     * if the terrain is forest the attack bonus will be 4
     * if it's any other terrain the bonus will be 2
     * @param terrain
     * @return int, attackBonus
     */
    @Override
    public int getAttackBonus(Terrain terrain) {
        int attackBonus = 0;
        if (terrain == Terrain.FOREST) {
            attackBonus = 4;
        } else {
            attackBonus = 2;
        }
        return attackBonus;
    }

    /**
     * Gets the resist bonus
     * if the terrain is forest the resist bonus will be 4
     * if it's any other terrain the bonus will be 2
     * @param terrain
     * @return int, resistBonus
     */
    @Override
    public int getResistBonus(Terrain terrain) {
        int resistBonus = 0;
        if (terrain == Terrain.FOREST) {
            resistBonus = 4;
        } else {
            resistBonus = 2;
        }
        return resistBonus;
    }
}
