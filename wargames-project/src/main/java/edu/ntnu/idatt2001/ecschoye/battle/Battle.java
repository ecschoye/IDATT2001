package edu.ntnu.idatt2001.ecschoye.battle;

import edu.ntnu.idatt2001.ecschoye.terrain.Terrain;
import edu.ntnu.idatt2001.ecschoye.units.Unit;

import java.util.Random;

/**
 * Class Battle
 * @author Edvard Schøyen
 *
 */
public class Battle {
    private final Army armyOne;
    private final Army armyTwo;
    private final Terrain terrain;

    private Random random;
    private static StringBuilder battleStats = new StringBuilder();
    /**
     * Constructor for Battle
     * Takes in armyOne and ArmyTwo as parameters
     * @param armyOne
     * @param armyTwo
     */
    public Battle(Army armyOne, Army armyTwo, Terrain terrain) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
        this.terrain = terrain;
    }

    /**
     * Simulates war between two armies
     * A random Army gets selected to attack the other Army
     * A random unit from that selected army attacks a random unit from the other army
     * If the attacked units health < 0 it gets removed
     * This goes on until one army is out of units
     * Then checks what army who won
     */
    public void simulate(){
        random = new Random();
        battleStats.setLength(0);
        while (armyOne.hasUnits() && armyTwo.hasUnits()){
            if (getRandomBoolean()){
                Unit striker = armyOne.getRandom();
                Unit defender2 = armyTwo.getRandom();
                battleStats(striker, defender2, terrain);
                striker.attack(defender2, terrain);
                if (isDead(defender2)){
                    armyTwo.remove(defender2);
                }
            }
            else {
                Unit striker2 = armyTwo.getRandom();
                Unit defender = armyOne.getRandom();
                battleStats(striker2, defender, terrain);
                striker2.attack(defender, terrain);
                if (isDead(defender)){
                    armyOne.remove(defender);
                }
            }
        }
        checkWhoWon(armyOne, armyTwo);
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }

    /**
     * Checks which army has units left
     * @param armyOne
     * @param armyTwo
     */
    public static void checkWhoWon(Army armyOne, Army armyTwo){
        if (armyOne.hasUnits()){
            battleStats.append("\n").append(armyOne).append(" \nwon!");
        }else if(armyTwo.hasUnits()){
            battleStats.append("\n").append(armyTwo).append(" \nwon!");
        }else {
            battleStats.append("Both armies lost!");
        }
    }

    /**
     * adds info about the battle to the stringbuilder
     * @param striker
     * @param defender
     */
    public static void battleStats(Unit striker, Unit defender, Terrain terrain){
        battleStats
                .append("Attacker ")
                .append(striker)
                .append(" with ")
                .append(striker.getHealth())
                .append("hp attacks ")
                .append(defender)
                .append(" with ")
                .append(defender.getHealth())
                .append("hp\n").append(defender)
                .append(" lost ")
                .append(striker.getAttack() + striker.getAttackBonus(terrain))
                .append("hp\n");
    }

    /**
     * Checks if the unit is dead
     * adds info about the units health to the stringbuilder
     * @param defender
     * @return
     */
    public static boolean isDead(Unit defender){
        if (defender.getHealth() <= 0){
            battleStats.append(defender).append("has been defeated.\n");
            return true;
        }else {
            battleStats.append(defender.getName()).append("'s health is now ").append(defender.getHealth()).append(".\n");
            return false;
        }
    }


    /**
     * Returns a random boolean.
     * Used to determine which army gets to attack.
     * @return boolean
     */
    public boolean getRandomBoolean(){
        return random.nextBoolean();
    }

    public StringBuilder getBattleStats() {
        System.out.println(battleStats.toString());
        return battleStats;
    }

    /**
     * prints stringbuilder
     * @param stringBuilder
     */
    public static void out(StringBuilder stringBuilder){
        System.out.println(stringBuilder.toString());
    }


}
