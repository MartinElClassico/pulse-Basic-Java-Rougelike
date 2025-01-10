package main.game.items;
/** 
* This class represents a Key, which is an item in the game
* It validates the room ID and door direction when created
* 
* @author annemm-3, tulmar-2, evekho-4
*/
public class Key extends Item {
    private static final String KEY_PICKED_UP_PROMPT = "Du tog upp nyckeln.";

    /**
     * Information necessary to knowing which door should be able to be unlocked by the key.
     * holds the roomID in which room the door is that is to be unlocked.
     */
    private int targetRoom;

    /**
     * Information necessary to knowing which door should be able to be unlocked by the key.
     * holds the door orientation in the room that should be unlocked.
     */
    private char targetDoor ;
    /**
     * Constructor, with argument checks for last two arguments.
     * @param name name of the key
     * @param description description of the key
     * @param itemPrompt prompt for when encountering item.
     * @param roomIdToUnlock roomIdToUnlock the ID of the room containing the door the key unlocks.
     * @param doorDirectionToUnlock char doorDirectionToUnlock the orientation of the door the key unlocks (n, s, o, v).
     * @throws IllegalArgumentException if the room ID is negative or the door direction is invalid
     */
    public Key (String name, String description, String itemPrompt, int roomIdToUnlock, char doorDirectionToUnlock){
        super(name, description, false, itemPrompt, KEY_PICKED_UP_PROMPT);
        // first check that argument is legal.
        validateRoomId(roomIdToUnlock);
        this.targetRoom = roomIdToUnlock;
        // first check that argument is legal.
        validateDoorDirection(doorDirectionToUnlock);
        this.targetDoor  = doorDirectionToUnlock;
    }

    /**
     * Validates that the room ID is non-negative.
     * @param roomIdToUnlock the ID of the room to validate
     * @throws IllegalArgumentException if the room ID is negative
     */
    private void validateRoomId(int roomIdToUnlock){
        if (roomIdToUnlock < 0){
            throw new IllegalArgumentException("Room ID must be non-negative.");
        }
    }

    /**
     * Validates that the door direction is valid (n, s, o, v).
     * @param doorDirectionToUnlock the direction of the door to validate
     * @throws IllegalArgumentException if the direction is invalid
     */
    private void validateDoorDirection(char doorDirectionToUnlock){
        // indexOf returns the index of the character inside the string, if none is found it returns -1.
        if ("nsvo".indexOf(doorDirectionToUnlock) == -1){
            throw new IllegalArgumentException("Invalid door direction, must be n (north), s (south), o (east), v (west)");
        }
    }

    /**
     * Gets the target room ID which has door to be unlocked.
     * @return the ID of the target room
     */
    public int getTargetRoom(){
        return this.targetRoom;
    }

    /**
     * Gets the target door direction of door to be unlocked.
     * @return the direction of the target door
     */
    public char getTargetDoor(){
        return this.targetDoor;
    }
}