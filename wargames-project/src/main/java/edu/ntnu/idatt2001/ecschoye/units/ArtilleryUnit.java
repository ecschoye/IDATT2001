package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;

public class ArtilleryUnit extends Unit{


    /**
     * Constructor for the Artillery unit
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public ArtilleryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for the Cavalry unit
     *
     * @param name
     * @param health
     */
    public ArtilleryUnit(String name, int health) {
        super(name, health, 20, 9);
    }


    @Override
    public int getAttackBonus(Terrain terrain) {
        int attackBonus = 5;
        if (this.getNumberTimesAtt()%2 == 0){
            if (terrain == Terrain.HILL) {
                attackBonus = 10;
                this.incrementNumberTimesAttacked();
            }
            if (terrain == Terrain.FOREST) {
                attackBonus = 0;
                this.incrementNumberTimesAttacked();
            }
        }
        return attackBonus;
    }

    @Override
    public int getResistBonus(Terrain terrain) {
        int resistBonus = 5;
        if (terrain == Terrain.PLAINS) {
            resistBonus = 0;
        }
        return resistBonus;
    }
}
