package main.game.items;
public class Weapon extends Item {
    /**
     * Holds the amount of damage increase the weapon gives
     */
    private int increaseDamage;

    /**
     * Constructor
     * @param String name of the weapon
     * @param String decription of the weapon
     * @param int amount of damage increase the weapon gives
     */
    public Weapon (String name, String description, int increaseDamage){
        super(name, description);
        this.increaseDamage = increaseDamage;
    }

    /**
     * Sets the increase in damage that the weapon gives
     * @param int new increase in damage
     */
    public void setIncreaseDamage(int increaseDamage){
        this.increaseDamage = increaseDamage;
    }

    /**
     * Gets the weapons increase in damage
     * @return int weapons increase in damage
     */
    public int getIncreaseDamage(){
        return this.increaseDamage;
    }

    /**
     * Calculates the damage the player does when this weapon is used
     * @param int damage the player does without the weapon
     * @return int damage with the weapon
     */
    public int calculateDamage(int playerDamage){
        return playerDamage +  this.increaseDamage;
    }
}