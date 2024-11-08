/**
 * The Dungeon class keeps track of where in the dungeon the player is and the correlated class instances such as current room. 
 */
public class Dungeon{
    /**
     * private instance to hold the current room that the player is in.
     */
    private Room currentRoom;
    /**
     * private instance to hold the welcome message to display at the start of the game. 
     * //TODO: how do we interpret this? as the welcome message as in A (below) or as in B (below):
     *    ... if we choose A or B, where should the other one be handled?
     * A. This needs to be created with the player name as well. As per spec:
     * Välkommen {name} till din skattjakt.
     * B. This does not need to include name but asks for the name to be stored in the "player" class object. as per spec:
     * Välkommen till Dragon Treasure
     *   Skriv ditt namn och tryck på [Enter] för att starta ett
     */
    private String welcomeMessage;

    /**
     * Construct a Dungeon with a given room (the start room) and a welcome message to display.
     * 
     * @param currentRoom
     * @param welcomeMessage
     */
    public Dungeon(Room currentRoom, String welcomeMessage){
        this.currentRoom = currentRoom;
        this.welcomeMessage = welcomeMessage;
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
    public String getWelcomeMessage(){
        return this.welcomeMessage;
    }

    /**
     * Sets the current room that the player is in.
     * 
     * @param currentRoom a room class object representing the current room the player is in.
     */
    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    /**
     * Sets the welcome message for the game.
     * Might be good to be able to be changed based on for example a restart of the game.
     * 
     * @param welcomeMessage a string to set the new welcome message.
     */
    public void setWelcomeMessage(String welcomeMessage){
        this.welcomeMessage = welcomeMessage;
    }
}
