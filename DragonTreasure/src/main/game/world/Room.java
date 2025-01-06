package main.game.world;
import java.util.ArrayList;
import java.util.List;

/**
 * The Room class represents a room in the dungeon. 
 * It stores basic information about the room such as the room description and it's assigned ID. 
 * 
 * Room also stores an array of Door objects that is given as arguments to the constructor. 
 * 
 * @author annemm-3, tulmar-2, evekho-4
 */
public class Room {

    /**
     * private instance to hold the room description, such as: "Du står utanför en grotta. Det luktar svavel från öppningen"
     */
    private String roomDesc;

    /**
     * private instance to hold the room ID, a unique ID. To help with keeping track of the room for map handling. 
     */
    private int roomId;

    /**
     * private instance to hold the directions of all the doors in the room
     */
    private char[] doorDirections;

    /**
     * private instance to hold the doors in an array that are connected to the room.
     * 
     */
    private Door[] doors;

    private List<Item> items;

    private List<Monster> monsters;

    /**
     * Constructs a Room with a given room description and roomID. 
     * 
     * @param roomDesc the description of the room, to be printed upon entering said room
     * @param roomId an ID to keep track of where the room is. 
     * @param doors an array that holds door instances connected to the room. needs to be at least one.
     */
    public Room (String roomDesc, int roomId, Door[] doors){
        this.roomDesc = roomDesc;
        this.roomId = roomId;
        this.doors = doors; 
        this.doorDirections = validDirectionsInRoom();
        this.items = new ArrayList<>();
        this.monsters = new ArrayList<>();
    }

    /**
     * Gets an array with all the directions the player can move based on the current room the player is in.
     * @return an array of characters with valid player movement prompts for the current room's doors.
     */
    private char[] validDirectionsInRoom() {
        // create list of characters to store valid directions.
        List<Character> validDirectionsList = new ArrayList<>();
        // all door objects in the current room.
        Door[] allDoorsInRoom = this.doors;
        /* Store all door positions of room in list: 
         * > loop through all doors the current room.
         * > Store the direction (s,n, e, w) of each door in a list.
         * > the list then holds each valid movement direction for said room.
        */
        for (Door doorInRoom : allDoorsInRoom) {
            validDirectionsList.add(doorInRoom.getPosition());
        }
        // create char array to store list elements inside of array instead of list.
        char[] validDirectionArray = new char[validDirectionsList.size()];
        // store each element from list in array.
        for (int i = 0; i<validDirectionsList.size(); i++){
            // convert each list element of type Object to char type and store in array.
            validDirectionArray[i] = validDirectionsList.get(i);
        }
        return validDirectionArray;
    }

    /**
     * Gets the directions that a player can move to get to doors in the room.
     * e.g. "o,v,s,n" (eng.: "e,w,s,n")
     * 
     * @return an array of directions the player can move to get to doors.
     * e.g. "o,v,s,n" (eng.: "e,w,s,n")
     */
    public char[] getDoorDirections(){
        return this.doorDirections;
    }
    
    /**
     * method to print out the room description and other data connected to the room.
     */
    public void doNarrative (){
        // print the roomDesc with printf to add other contexts.
    }

    /**
     * Retrivies the room's description 
     * 
     * @return the room's description.
     */
    public String getRoomDesc () {
        return this.roomDesc;
    }

    /**
     * Retrivies the room's ID
     * 
     * @return the room's ID.
     */

    public int getRoomId () {
        return this.roomId;
    }

    /**
     * returns all the door class instances that are connected to the room.
     * 
     * @return an array of door class instances.
     */
    public Door[] getDoors () {
        return this.doors;
    }

    /**
     * Sets the room's description. In case it need to be modified for an event for example.
     * 
     * @param roomDesc
     */
    public void setRoomDesc (String roomDesc){
        this.roomDesc = roomDesc;
    }

    //setRoomID() not includese since it shouldn't need to be changed after having been initalized.

    /**
     * Adds an item to the room
     * 
     * @param i5tem to add
     */
    public void addItem (Item item){
        items.add(item);
    }

    /**
     * Adds a monster to the room
     * 
     * @param monster to add
     */
    public void addMonster (Monster monster){
        monsters.add(monster);
    }
}