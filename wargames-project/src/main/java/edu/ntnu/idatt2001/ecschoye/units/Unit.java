package edu.ntnu.idatt2001.ecschoye.units;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;

/**
 * Class Unit
 * @author Edvard Schøyen
 *
 */
public abstract class Unit {
    /**
     * name, health, attack, armor are variables given in the class diagram provided by the exercise
     *
     *
     */
    private final String name;
    private int health;
    private final int attack;
    private final int armor;
    private int numberTimesAtt = 0;
    private int numberTimesBeenAtt = 0;
    private Terrain terrain;

    /**
     * Constructor for Unit class
     * @param name
     * @param health
     * @param attack
     * @param armor
     * @throws IllegalArgumentException
     */
    public Unit(String name, int health, int attack, int armor) throws IllegalArgumentException{
        if (name.isBlank()) throw new IllegalArgumentException("Name can not be blank.");
        if (health <= 0) throw new IllegalArgumentException("Health can not be less than 0.");
        if (attack < 0) throw new IllegalArgumentException("Attack can not be less than 0");
        if (armor < 0) throw new IllegalArgumentException("Armor can not be less than 0");
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }


    /**
     * Calculates damage done in an attack
     * @param opponent
     */
    public void attack(Unit opponent, Terrain terrain) {
        opponent.incrementNumberTimesBeenAttacked();
        opponent.setHealth(opponent.getHealth()
                - (this.getAttack() + this.getAttackBonus(terrain))
                + (opponent.getArmor() + opponent.getResistBonus(terrain)));
    }

    /**
     * Gets name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets health
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     * Increments number of times attacked
     * @return
     */
    public int incrementNumberTimesAttacked(){
        return numberTimesAtt++;
    }

    /**
     * Gets number of times attacked
     * @return
     */
    public int getNumberTimesAtt(){
        return numberTimesAtt;
    }

    /**
     * Increments number of times been attacked
     * @return
     */
    public int incrementNumberTimesBeenAttacked(){
        return numberTimesBeenAtt++;
    }

    /**
     * Gets number of times been attacked
     * @return
     */
    public int getNumberTimesBeenAtt(){
        return numberTimesBeenAtt;
    }



    /**
     * Gets attack
     * @return
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Gets armor
     * @return
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Sets health
     * Sets health to 0 if it's less than 0
     * @param health
     */
    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public String getUnitType(){
        return this.getClass().getSimpleName().replaceAll("Unit","");
    }

    public String convertToCsvFormat(){
        return this.getClass().getSimpleName() + "," + this.getName() + "," + this.getHealth() + "\n";
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name + " ";
    }


    /**
     * Gets attack bonus
     * @param terrain
     * @return int, attackBonus
     */
    public abstract int getAttackBonus(Terrain terrain);

    /**
     * Gets resist bonus
     * @param terrain
     * @return int, resistBonus
     */
    public abstract int getResistBonus(Terrain terrain);
}
