package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;

/**
 * Class CavalryUnit
 * @author Edvard Schøyen
 *
 */
public class CavalryUnit extends Unit{
    /**
     * Constructor for the Cavalry unit
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for the Cavalry unit
     *
     * @param name
     * @param health
     */
    public CavalryUnit(String name, int health) {
        super(name, health, 20, 12);
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
        this.incrementNumberTimesAttacked();
        int attackBonus = 0;
        if (terrain == Terrain.PLAINS) {
            attackBonus = this.getNumberTimesAtt() <= 1 ? 8 : 4;
        } else {
            attackBonus = this.getNumberTimesAtt() <= 1 ? 6 : 2;
        }
        return attackBonus;
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
        int resistBonus = 0;
        if (!(terrain == Terrain.FOREST)) {
            resistBonus = 2;
        }
        return resistBonus;
    }
}
