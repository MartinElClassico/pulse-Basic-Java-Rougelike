/**
 * The Room class represents a room in the dungeon. 
 * It stores basic information about the room such as the room description and it's assigned ID. 
 * 
 * Room also stores an array of Door objects that is given as arguments to the constructor. 
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
     * private instance to hold the doors in an array that are connected to the room.
     * 
     */
    private Door[] doors;

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
    public String getRoomDesc (){
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
     * Retrivies the room's doors
     * 
     * @return an array of Door class instances
     */
    public Door[] getDoors() {
        return this.doors;
    }

    // no need to recreate doors unless they should be able to disappear. 

    /**
     * Sets the room's description. In case it need to be modified for an event for example.
     * 
     * @param roomDesc
     */
    public void setRoomDesc (String roomDesc){
        this.roomDesc = roomDesc;
    }

    // room ID shouldn't need to be changed after having been initalized.
}