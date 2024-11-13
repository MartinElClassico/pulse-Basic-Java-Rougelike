public class GameSetup {
    private Door[] doors;

    private Room[] rooms = new Room[8];

    private String[] roomDescriptions = new String[8];

    // main constructor of the file.
    public GameSetup() {
        populateRoomDescriptions();
        this.rooms[0] = createRoom0();
        this.rooms[1] = createRoom1();
        
    }

    private void populateRoomDescriptions () {
        roomDescriptions[0] = ("Du står utanför en grotta. Det luktar svavel från öppningen\r\n" + //
                        "Grottöppningen är österut. Skriv \"ö\" och tryck på [Enter] för att komma in i grottan");
        roomDescriptions[1] = ("När du går in i grottan kollapsar ingången bakom dig.\r\n" + //
                        "Rummet är upplyst av några ljus som sitter på ett bord framför dig.");
        roomDescriptions[2] = ("Du ser en död kropp på golvet.");
        roomDescriptions[3] = ("Du ser en brinnande fackla i rummets ena hörn och känner en motbjudande stank.");
        roomDescriptions[4] = ("Du kommer in i ett fuktigt rum med vatten sipprandes längs den västra väggen.");
        roomDescriptions[5] = ("Du kommer in i ett rymligt bergrum med en ljusstrimma sipprandes genom en spricka i\r\n" + //
                        "den östra väggen.");
        roomDescriptions[6] = ("");
        roomDescriptions[7] = ("Du lämnar grottan med livet i behåll. Grattis, du förlorade inte!");
    }

    // create the rooms in the dungeon with related doors.
    private Room createRoom0() {
        // create doors for the room firstly.
        Door doorRoom0East = new Door('ö', false, 1);
        doors = new Door[1];
        doors[0] = doorRoom0East; // store in array as that is expected arg.
        // create the room with the created doors as args.
        Room room0 = new Room(this.roomDescriptions[0],0,doors);
        return room0;
    }
    private Room createRoom1() {
        Door doorRoom1North = new Door('n', false,2);
        Door doorRoom1South = new Door('s', false, 5);
        doors = new Door[2];
        doors[0] = doorRoom1North;
        doors[1] = doorRoom1South;
        Room room1 = new Room(this.roomDescriptions[1], 1, doors);
        return room1;
    }
    
}