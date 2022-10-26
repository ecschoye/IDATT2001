package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;

/**
 * Class RangedUnit
 * @author Edvard Schøyen
 *
 */
public class RangedUnit extends Unit{

    /**
     * Constructor for the Ranged unit
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for the Ranged unit
     * @param name
     * @param health
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
    }


    /**
     * Gets attack bonus
     * if the terrain is hill, the attack bonus will be 5
     * if the terrain is forest, the attack bonus will be 2
     * if the terrain is any other terrain, the attack bonus will be 3
     * @param terrain
     * @return int, attackBonus
     */
    @Override
    public int getAttackBonus(Terrain terrain){
        int attackBonus = 0;
        switch (terrain){
            case HILL -> attackBonus = 5;
            case FOREST -> attackBonus = 2;
            default -> attackBonus = 3;
        }
        return attackBonus;
    }

    /**
     * Gets resist bonus
     * returns 6 if the number of times been attacked < 1
     * returns 4 if the number of times been attacked < 2
     * else it returns 2
     * @param terrain
     * @return int
     */
    @Override
    public int getResistBonus(Terrain terrain){
        if (this.getNumberTimesBeenAtt() < 1){
            return 6;
        }else if (this.getNumberTimesBeenAtt() < 2){
            return 4;
        }else {
            return 2;
        }
    }
}
