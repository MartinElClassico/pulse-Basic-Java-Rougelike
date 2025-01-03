package main.game.entities;

import java.util.ArrayList;
import java.util.List;

import main.game.items.*;
/**
 * The Player class represents a player in the game.
 * It stores basic informormation about the player, such as it's name.
 * 
 * Player's position within the dungeon is handled by the Dungeon class which also 
 * keeps track of the current room and handles player movement.
 * 
 * @author annemm-3, tulmar-2, evekho-4
 */
public class Player {

    /**
     * Private instance to hold the player's name.
     */
    private String name;

    /**
     * private instance to hold the maximum number of healtPoints the player can have.
     * not static nor predefined so that not limiting in case game be expanded with for example difficulty variables.
     */
    private int maxHp;

    /**
     * private instance to hold the player's health points. Initalized to that of the player's maximum HP.
     */
    private int hp = maxHp;

    /**
     * private instance to hold the damage the player can do. Initalized to 1.
     */
    private int attackDamage = 1;

    /**
     * holds a list of listeners to tell other classes calling this one if player has died or not.
     * use of list makes this class decoupled from having to know how many listeners there are, 
     * it just needs to trigger them. Otherwise we could have used just a sole listener.
     * having a list like this is also more modular as we can create a listener for each event.
     */
    private List<HealthListener> listeners = new ArrayList<>();

    private Inventory inventory;

    /**
     * Constructs a player with the specified name.
     * 
     * @param name the name of the player.
     */
    public Player(String name, int maxHp) {
        this.name = name;
        this.maxHp = maxHp;
        this.inventory = new Inventory();
    }

    /**
     *  Retrieves the player's name.
     * 
     * @return the player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * prints personalized welcome message to user
     */
    public void printWelcomePlayer() {
        System.out.printf("Välkommen %s till din skattjakt.%n", name);
    }
    
    // setName() not included since name shouldn't be able to be changed.

    //region player HP.

    /**
     * Getter for MAX_HP.
     * @return MAX_HP the maximum hp the player can have.
     */
    public int getMaxHp(){
        return maxHp;
    }

    // no setter for player maxHp. 

    /**
     * Gives the players health points.
     * @return hp, the player's current health points (HP).
     */
    public int getHp(){
        return hp;
    }

    /**
     * Sets the players health points.
     * @param newHp the new amount of player health points.
     */
    public void setHp(int newHp){
        this.hp = newHp;
    }

    /** 
     * public method to add a listener from other classes that need it.
     * mainly used when necessary to know if player has died or not.
     */
   public void addHealthListener(HealthListener listener){
    listeners.add(listener);
   }

   /**
    * trigger listener in case health is depleted.
    */
   private void notifyHealthDepleted() {
    for (HealthListener listener : listeners) {
        listener.onHealthDepleted();
    }
   }

   /**
    * Handles a player taking damage, decrements hp and triggers listener if dead.
    * @param damageTaken int of how much damage is being dealt to player.
    * @return playerHP, how much HP the player has left.
    */
   public int takeDamage(int damageTaken){
    this.hp -= damageTaken;
    if (hp <= 0){
        notifyHealthDepleted();
    }
    return this.hp;
   }

   /**
    * heals the player but makes sure player does not get more HP than maximum.
    * @param hpGained how much HP to be added to the player.
    * @return currentHP, returns the HP of the player after having been healed.
    */
   public int heal(int hpGained) {
    this.hp += hpGained;
    // player should not be able to have more hp than maxHp.
    if (maxHp > this.hp) {
        this.hp = maxHp;
    }
    return this.hp;
   }

    //endregion

    //region for handling player damage:

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void incrementAttackDamage(int addAttackDamage) {
        this.attackDamage += addAttackDamage;
    }

    //endregion

    //region player inventory and equip/use functions.

    public Inventory getInventory(){
        return this.inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public void accessInventory(){
        Item chosenItem = this.inventory.manageInventory();
        if (chosenItem != null)
        {
            useItem(chosenItem);
            this.inventory.removeItem(chosenItem.getName());
        }
    }

    private void useItem(Item item) {
        if(item instanceof Potion potion) {
            heal(
                potion.getHealing()
                );
        } else if (item instanceof Weapon weapon) {
            incrementAttackDamage(
                weapon.getIncreaseDamage()
            );
        } else {assert true; } // do nothing if not of these types.
    }

    //endregion
}