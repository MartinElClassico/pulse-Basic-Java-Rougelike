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
     * Constructs a player with the specified name.
     * 
     * @param name the name of the player.
     */
    public Player(String name) {
        this.name = name;
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
}