/**
 * The Room class represents a room in the dungeon. 
 * It stores basic information about the room such as the room description and it's assigned ID. 
 * 
 * //TODO: does it room know which door it is linked to or does each door know which rooms it's linked to? 
 * or does dungeon create a type of map for this? Perhaps room can have an instance to hold an array of which direction it has doors.
 * thus room creates it own door instances. Think this works as per the class diagram of the assignment spec as well.
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
     * Constructs a Room with a given room description and roomID. 
     * 
     * @param roomDesc
     * @param roomId
     */
    public Room (String roomDesc, int roomId){
        this.roomDesc = roomDesc;
        this.roomId = roomId;
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
    public int getRoomId (){
        return this.roomId;
    }

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