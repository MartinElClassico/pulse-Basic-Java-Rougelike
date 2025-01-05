package main.game.entities;

/** 
* This class represents a monster in the game that can take damage, do damage and get defeated
* It handles both monster and dragon, differentiating based on the name of the monster
*/

public class Monster {

// constants for messages
    private static final String ATTACKED_MONSTER_MESSAGE = "Du attackerar odjuret och gör %d skada %n";
    private static final String ATTACKED_DRAGON_MESSAGE = "Du attackerar draken och gör %d skada %n";
    private static final String ATTACK_MONSTER_MESSAGE = "Ett odjur attackerar dig och gör %d skada";
    private static final String ATTACK_DRAGON_MESSAGE = "En drake attackerar dig och gör %d skada";
    private static final String DEFEAT_MONSTER_MESSAGE = "Du besegrar odjutet";
    private static final String DEFEAT_DRAGON_MESSAGE = "Du besegrar draken";

    private static final int DAMAGE = 1; // monster/dragon damage is a constant

    private String name; // differentiates between monster and dragon
    private int healthPoints; // current health points
    private int maxHealthPoints; // max health points
    private String monsterDesc; // description of the monster
    private boolean defeated; // whether the monster is defeated or not

    /** 
     * Constructor to create a monster with its name, max health points and description
     * 
     * @param name
     * @param maxHealthpoints
     * @param monsterDesc
    */
    public Monster(String name, int maxHealthPoints, String monsterDesc) {
        this.name = name;
        this.healthPoints = maxHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.monsterDesc = monsterDesc;
        this.defeated = false;
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
    public int getDamage() {
        return DAMAGE;
    }

/**
 * Gets the description of the monster
 * @return The description of the monster
 */
    public String getMonsterDesc() {
        return monsterDesc;
    }

/**
 * Checks if the monster is defeated
 * @return true if the monster is defeated, otherwise false
 */
    public boolean isDefeated() {
        return defeated;
   }

/**
 * Method for attacking the player
 * @param player The player being attacked
 */
public void attackPlayer(Player player) {
    if (!defeated) {
    player.takeDamage(DAMAGE); // Calls Player class' takeDamage method
    if (name.equals("Monster")) {
        System.out.printf(ATTACK_MONSTER_MESSAGE, DAMAGE);
    } else {
        System.out.printf(ATTACK_DRAGON_MESSAGE, DAMAGE);
    }
  }
}

/**
 * Method to handle the monster taking damage and mark as defeated when healthpoints reach 0
 *  */
public void takeDamage(int damage) {
    if (!defeated) {
        healthPoints = healthPoints - damage;

    if (healthPoints <= 0) {
            defeated = true;

    if (name.equals("Monster")) {
        System.out.println(DEFEAT_MONSTER_MESSAGE);
    } else {
        System.out.println(DEFEAT_DRAGON_MESSAGE);
      }
    }
  }
}




    




    
}
