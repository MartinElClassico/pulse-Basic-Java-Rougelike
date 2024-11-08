/**
 * The Door class represents a door in the dungeon. It is connected to certain rooms. 
 * It stores basic information about the door such as if it is locked or not.
 * 
 * The Door class is relative to the Room class (thus the Doors are created from Rooms)
 * //TODO: is above description correct as per our interpretation? rewrite into more formal language.
 */
public class Door {
    /**
     * Private instance to hold the Door's position, either w, e, n or s. But as game is in Swedish there are instead: v, ö, n, s.
     */
    private char position; //TODO: why is this here? the position is relative to the room. 
                             // Thus a door by itself always has two chars for position, not one. Possible interpretation:
                             // create the door again for the new room. Perhaps it's only locked from one room for example.
    /**
     * Private instance to hold the Door's locked status.
     * 
     * True means locked. 
     * False means unlocked or not locked anymore.
     */
    private boolean locked;

    /**
     * Constructs a Door with a given position and whether the door is locked or not.
     * 
     * @param position wether the door is to the w, e, n or s.
     * @param locked wether the door is locked or not (false).
     */
    public Door(char position, boolean locked){
        this.position = position;
        this.locked = locked;
    }

    /**
     * Retrieves the door's position.
     * 
     * @return the position of the door.
     */
    public char getPosition(){
        return this.position;
    }

    /**
     * Retrieves the door's locked status
     * 
     * @return true if locked, else false.
     */
    public boolean getLocked(){
        return this.locked;
    }

    // no need to change position of doors, they cannot transport. 

    /**
     * Sets the door's locked status, for example to lock or unlock it based on events.
     * 
     * @param locked true if door should be locked, false if door should be unlocked.
     */
    public void setLocked(boolean locked){
        this.locked = locked;
    }
}