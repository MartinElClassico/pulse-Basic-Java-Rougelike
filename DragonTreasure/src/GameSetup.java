import utils.DragonTreasure; //import local help function for room 4 door.

/**
 * The GameSetup class creates the game
 * Creates rooms with descriptions and doors in those rooms
 * 
 * @author annemm-3, tulmar-2, evekho-4
 */
public class GameSetup {
    /** 
     * Private instance array to hold door objects
     * Defined in each room to hold the specific rooms doors
     */
    private Door[] doors;
    
    /**
     * Private instance array to hold the eight rooms of the game
     */
    private Room[] rooms = new Room[8];

    /**
     * Private instance array to hold descriptions of the eight rooms
     */
    private String[] roomDescriptions = new String[8];

    /** 
     * Main constructor of the game
     * Calls upon other methods to create rooms and stores them in an array, creates room descriptions 
     */
    public GameSetup() {
        populateRoomDescriptions();
        this.rooms[0] = createRoom0();
        this.rooms[1] = createRoom1();
        this.rooms[2] = createRoom2();
        this.rooms[3] = createRoom3();
        this.rooms[4] = createRoom4();
        this.rooms[5] = createRoom5();
        this.rooms[6] = createRoom6();
        this.rooms[7] = createRoom7();
    }

    /**
     * Adds all room descriptions to an array
     */
    private void populateRoomDescriptions () {
        roomDescriptions[0] = ("Du står utanför en grotta. Det luktar svavel från öppningen");
        roomDescriptions[1] = ("När du går in i grottan kollapsar ingången bakom dig.\r\n" + 
                        "Rummet är upplyst av några ljus som sitter på ett bord framför dig.");
        roomDescriptions[2] = ("Du ser en död kropp på golvet.");
        roomDescriptions[3] = ("Du ser en brinnande fackla i rummets ena hörn och känner en motbjudande stank.");
        roomDescriptions[4] = ("Du kommer in i ett fuktigt rum med vatten sipprandes längs den västra väggen.");
        roomDescriptions[5] = ("Du kommer in i ett rymligt bergrum med en ljusstrimma sipprandes genom en spricka i\r\n" + 
                        "den östra väggen.");
        roomDescriptions[6] = ("");
        roomDescriptions[7] = ("Du lämnar grottan med livet i behåll. Grattis, du förlorade inte!");
    }

    /**
     * Create doors for room 0 and add those to an array
     * Create room 0 and use the door array in the args
     * @return Room 0
     */
    private Room createRoom0() {
        // create doors for the room firstly.
        Door doorRoom0East = new Door('o', false, 1, 
        "Grottöppningen är österut. Skriv \"o\" och tryck på [Enter] för att komma in i grottan");
        doors = new Door[1];
        doors[0] = doorRoom0East; // store in array as that is expected arg.
        // create the room with the created doors as args.
        Room room0 = new Room(this.roomDescriptions[0],0,doors);
        return room0;
    }

    /**
     * Create doors for room 1 and add those to an array
     * Create room 1 and use the door array in the args
     * @return Room 1
     */
    private Room createRoom1() {
        Door doorRoom1North = new Door('n', false,2,
        "Du kan gå norrut [n]");
        Door doorRoom1South = new Door('s', false, 5,
        "Du kan gå söderut [s]");
        doors = new Door[2];
        doors[0] = doorRoom1North;
        doors[1] = doorRoom1South;
        Room room1 = new Room(this.roomDescriptions[1], 1, doors);
        return room1;
    }

    /**
     * Create doors for room 2 and add those to an array
     * Create room 2 and use the door array in the args
     * @return Room 2
     */
    private Room createRoom2() {
        Door doorRoom2South = new Door('s', false, 1,
        "Du kan åka söderut [s]");
        Door doorRoom2East = new Door('o', false, 3,
        "Du kan gå österut [o]");
        doors = new Door[2];
        doors[0] = doorRoom2South;
        doors[1] = doorRoom2East;
        Room room2 = new Room(this.roomDescriptions[2], 2, doors);
        return room2;
    }

    /**
     * Create doors for room 3 and add those to an array
     * Create room 3 and use the door array in the args
     * @return Room 3
     */
    private Room createRoom3() {
        Door doorRoom3East = new Door('o', false, 7,
        "Du ser en utgång österut [o]");
        Door doorRoom3West = new Door('v', false, 2,
        "Du kan gå värsterut [v]");
        Door doorRoom3South = new Door('s', false, 4,
        "Du kan åka söderut [s]");
        doors = new Door[3];
        doors[0] = doorRoom3East;
        doors[1] = doorRoom3West;
        doors[2] = doorRoom3South;
        Room room3 = new Room(this.roomDescriptions[3], 3, doors);
        return room3;
    }

    /**
     * Create doors for room 4 and add those to an array
     * Add desc for looking through the keyholw of locked door
     * Create room 4 and use the door array in the args
     * @return Room 4
     */
    private Room createRoom4() {
        Door doorRoom4East = new Door('o', true, 6,
        "Du ser en låst dörr i öster [o]");
        //Add description for looking through the keyhole since the door is locked
        doorRoom4East.setKeyholeViewDescription(
            "Du kikar genom nyckelhålet och ser en skattkista full med guld.\n"
            + DragonTreasure.getTreasure());
        Door doorRoom4North = new Door('n', false, 3,
        "Du kan gå norrut [n]");
        Door doorRoom4West = new Door('v', false, 5,
        "Du kan gå västerut [v]");
        doors = new Door[3];
        doors[0] = doorRoom4East;
        doors[1] = doorRoom4North;
        doors[2] = doorRoom4West;
        Room room4 = new Room(this.roomDescriptions[4], 4, doors);
        return room4;
    }

    /**
     * Create doors for room 5 and add those to an array
     * Create room 5 and use the door array in the args
     * @return Room 5
     */
    private Room createRoom5() {
        Door doorRoom5North = new Door('n', false,1,
        "Du kan gå norrut [n]");
        Door doorRoom5East = new Door('o', false,4,
        "Du kan åka österut [o]");
        doors = new Door[2];
        doors[0] = doorRoom5North;
        doors[1] = doorRoom5East;
        Room room5 = new Room(this.roomDescriptions[5], 5, doors);
        return room5;
    }

    /**
     * Create doors for room 6 and add those to an array
     * Create room 6 and use the door array in the args
     * @return Room 6
     */
    private Room createRoom6() {
        Door doorRoom6West = new Door('v', false, 4,
        "Du kan gå västerut [v]");
        doors = new Door[1];
        doors[0] = doorRoom6West;
        Room room6 = new Room(this.roomDescriptions[6], 6, doors);
        return room6;
    }

    /**
     * Create doors for room 7 and add those to an array
     * Create room 7 and use the door array in the args
     * @return Room 7
     */
    private Room createRoom7() {
        Door doorRoom7West = new Door('v', false, 3,
        "Du ser utgången från grottan västerut [v]");
        doors = new Door[1];
        doors[0] = doorRoom7West;
        Room room7 = new Room(this.roomDescriptions[7], 7, doors);
        return room7;
    }
    
    /**
     * Gets the array that holds all of the rooms of the game
     */
    public Room[] getRooms() {
        return this.rooms;
    }


}