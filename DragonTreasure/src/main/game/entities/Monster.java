package main.game.entities;

/** 
* This class represents a monster in the game that can take damage, do damage and get dead
* It handles both monster and dragon, differentiating based on the name of the monster
*/

public class Monster {

// constants for messages
    private static final String ATTACK_MONSTER_MESSAGE = "Ett odjur attackerar dig och gör %d skada (hp kvar: %d)%n";
    private static final String ATTACK_DRAGON_MESSAGE = "En drake attackerar dig och gör %d skada (hp kvar: %d)%n";
    private static final String MONSTER_ATTACKED_MESSAGE = "Du attackerar monstret och gör %d skada (hp kvar: %d)%n";
    private static final String DRAGON_ATTACKED_MESSAGE = "Du attackerar draken och gör %d skada (hp kvar: %d)%n";
    private static final String DEFEAT_MONSTER_MESSAGE = "Du besegrar odjuret!";
    private static final String DEFEAT_DRAGON_MESSAGE = "Du besegrar draken!";

    private int damage = 1; // monster/dragon damage, initialized to 1.

    private String name; // differentiates between monster and dragon
    private String monsterDesc; // description of the monster
    private String asciiArt = ""; //placeholder for potential ascii art.
    private int healthPoints; // current health points
    private int maxHealthPoints; // max health points
    private boolean dead; // whether the monster is dead or not
    private boolean isDragon;

    /** 
     * Constructor to create a monster with its name, max health points and description
     * 
     * @param name
     * @param maxHealthpoints
     * @param monsterDesc
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
 * Method for attacking the player
 * @param player The player being attacked
 */
public boolean attackPlayer(Player player) {
    if (!dead) 
    {
        System.out.printf("PLAYER HP: %d%n", player.getHp());
        int playerHP = player.takeDamage(damage); // Calls Player class' takeDamage method
        playerAttackedMessage(playerHP);
        if (player.getHp() <= 0) {
            return false;
        }
        return true;
    }
    else {return true;}
}

private void playerAttackedMessage(int playerHP){
    if (!isDragon) {
        System.out.printf(ATTACK_MONSTER_MESSAGE, damage, playerHP);
    } else {
        System.out.printf(ATTACK_DRAGON_MESSAGE, damage, playerHP);
    }
}

private void printDefeated(){
    if (!isDragon) {
        System.out.println(DEFEAT_MONSTER_MESSAGE);
    } else {
        System.out.println(DEFEAT_DRAGON_MESSAGE);
      }
}

/**
 * Method to handle monster taking damage and mark as dead when healthpoints reach 0
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

private void monsterAttackedMessage(int damageTaken){
    if (!isDragon) {
        System.out.printf(MONSTER_ATTACKED_MESSAGE, damageTaken, healthPoints);
    } else {
        System.out.printf(DRAGON_ATTACKED_MESSAGE, damageTaken, healthPoints);
    }
}

public int getDamage(){
    return this.damage;
}

public void setDamage(int damage){
    this.damage = damage;
}
    
}
