package main.game.entities;

/** 
* This class represents a monster in the game that can take damage, do damage and get dead
* It handles both monster and dragon, differentiating based on the name of the monster
* 
* @author annemm-3, tulmar-2, evekho-4
*/

public class Monster {

    // constants for messages
    private static final String ATTACK_MONSTER_MESSAGE = "Ett skelett attackerar dig och gör %d skada (hp kvar: %d)%n";
    private static final String ATTACK_DRAGON_MESSAGE = "En drake attackerar dig och gör %d skada (hp kvar: %d)%n";
    private static final String MONSTER_ATTACKED_MESSAGE = "Du attackerar skelettet och gör %d skada (hp kvar: %d)%n";
    private static final String DRAGON_ATTACKED_MESSAGE = "Du attackerar draken och gör %d skada (hp kvar: %d)%n";
    private static final String DEFEAT_MONSTER_MESSAGE = "Du besegrar skelettet!";
    private static final String DEFEAT_DRAGON_MESSAGE = "Du besegrar draken!";

    private int damage = 1; // monster/dragon damage, initialized to 1.

    private String name; // differentiates between monster and dragon
    private String monsterDesc; // description of the monster
    private String asciiArt = ""; //placeholder for potential ascii art.
    private int healthPoints; // current health points
    private int maxHealthPoints; // max health points
    private boolean dead; // whether the monster is dead or not
    private boolean isDragon; // whether the monster is a dragon or not

    /** 
     * Constructor to create a monster with its name, max health points and description
     * 
     * @param name name of the monster.
     * @param maxHealthpoints maximum health of the monster.
     * @param monsterDesc the description of the monster.
     * @param isDragon boolean to say if the monster is a dragon or not.
    */
    public Monster(String name, int maxHealthPoints, String monsterDesc, boolean isDragon) {
        this.name = name;
        this.healthPoints = maxHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.monsterDesc = monsterDesc;
        this.isDragon = isDragon;
        this.dead = false;
    }

    /**
     * Gets the name of the monster
     * @return The name of the monster
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the current health points of the monster
     * @return The current health points of the monster
     */
    public int getHealthPoints() {
       return healthPoints;  
    }

    /**
     * Gets the max health points of the monster
     * @return The max health points of the monster
     */
    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    /**
     * Gets the damage of the monster
     * @return The damage of the monster
     */
    public int getAttackDamage() {
        return damage;
    }

    /**
     * Gets the description of the monster
     * @return The description of the monster
     */
    public String getMonsterDesc() {
        return monsterDesc;
    }

    /**
     * Gets ascii art for the monster, if none it just returns an empty string.
     * @return ascii art or if none, empty string
     */
    public String getAsciiArt(){
        return this.asciiArt;
    }

    /**
     * Set ascii art to be used for the monster.
     * @param ascii ascii art to be used to represent monster.
     */
    public void setAsciiArt(String ascii){
        this.asciiArt = ascii;
    }

    /**
     * Checks if the monster is dead
     * @return true if the monster is dead, otherwise false
     */
    public boolean isDefeated() {
        return dead;
   }

    /**
     * Method for attacking the player and mark as defeated if healthpoints reach 0.
     * @param player The player being attacked
     * @return boolean, true if player is alive, false if player is dead.
     */
    public boolean attackPlayer(Player player) {
        if (!dead) 
        {
            int playerHP = player.takeDamage(damage); // Calls Player class' takeDamage method
            playerAttackedMessage(playerHP);
            if (player.getHp() <= 0) {
                return false;
            }
            return true;
        }
        else {return true;}
    }

    /**
     * Method to handle text output when monster attacks player.
     * @param playerHP The players health points
     */
    private void playerAttackedMessage(int playerHP){
        if (!isDragon) {
            System.out.printf(ATTACK_MONSTER_MESSAGE, damage, playerHP);
        } else {
            System.out.printf(ATTACK_DRAGON_MESSAGE, damage, playerHP);
        }
    }

    /**
     * Method to print out the monster defeated message
     */
    private void printDefeated(){
        if (!isDragon) {
            System.out.println(DEFEAT_MONSTER_MESSAGE);
        } else {
            System.out.println(DEFEAT_DRAGON_MESSAGE);
        }
        System.out.println();
    }

    /**
     * Method to handle monster being attacked and mark as dead when healthpoints reach 0
     * and print defeated message if monster is killed.
     * @param damageTaken the damage to be done to the monster.
     * @return boolean, true if monster alive, false if dead.
     */
    public boolean attackMonster(int damageTaken) {
        healthPoints -= damageTaken;
        monsterAttackedMessage(damageTaken);
        if (healthPoints <= 0) {   
            dead = true;
            printDefeated();
            return false; //to answer if the monster is alive
        }
        return true; //to answer if the monster is alive
    }

    /**
     * Method to handle output when the monster is attacked.
     * @param damageTaken the damage taken by the monster
     */
    private void monsterAttackedMessage(int damageTaken){
        if (!isDragon) {
            System.out.printf(MONSTER_ATTACKED_MESSAGE, damageTaken, healthPoints);
        } else {
            System.out.printf(DRAGON_ATTACKED_MESSAGE, damageTaken, healthPoints);
        }
    }

    /**
     * Method to get the damage the monster does.
     * @return the damage of the monster
     */
    public int getDamage(){
        return this.damage;
    }

    /**
     * Method to set the damage the monster does.
     * @param damage the damage to be set
     */
    public void setDamage(int damage){
        this.damage = damage;
    }
    
}
