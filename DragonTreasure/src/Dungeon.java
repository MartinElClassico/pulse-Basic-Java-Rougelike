/**
 * The Dungeon class keeps track of where in the dungeon the player is and the correlated class instances 
 * such as current room. 
 * 
 * @author annemm-3, tulmar-2, evekho-4
 */
public class Dungeon{
    /**
     * private instance to hold the current room that the player is in.
     */
    private Room currentRoom;
    /**

     * private static final instance to hold the welcome message to display at the start of the game. 
     */
    private static final String WELCOME_MESSAGE = "Välkommen till Dragon Treasure\r\n" 
                                            + "Skriv ditt namn och tryck på [Enter] för att starta ett nytt spel...";

    /**
     * Construct a Dungeon with a given room (the start room).
     * 
     * @param currentRoom
     */
    public Dungeon(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    /**
     * Retrieves the current room object.
     * 
     * @return the current room as a room class object.
     */
    public Room getCurrentRoom(){
        return this.currentRoom;
    }
    
    /**
     * Retrieves the welcome message
     * 
     * @return the welcome message as a string.
     */

    public static String getWelcomeMessage(){
        return WELCOME_MESSAGE;
    }

    /**
     * Sets the current room that the player is in.
     * 
     * @param currentRoom a room class object representing the current room the player is in.
     */
    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }
}
