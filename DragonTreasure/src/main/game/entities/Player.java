package main.game.entities;
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
     * Constructs a player with the specified name.
     * 
     * @param name the name of the player.
     */
    public Player(String name, int maxHp) {
        this.name = name;
        this.maxHp = maxHp;
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




    //endregion
}