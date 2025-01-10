package main.game.items;
/** 
* This class represents a Weapon, which is an item in the game
* It holds the amount of damage it increases
* 
* @author annemm-3, tulmar-2, evekho-4
*/
public class Weapon extends Item {
    private static final String WEAPON_PICKED_UP_PROMPT = "Du tog upp svärdet.";
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
    public Weapon (String name, String description, String itemPrompt, int increaseDamage){
        super(name, description, true, itemPrompt, WEAPON_PICKED_UP_PROMPT);
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
}