public class GameSetup {
    private Door[] doors;

    private Room[] rooms = new Room[8];

    private String[] roomDescriptions = new String[8];

    // main constructor of the file.
    public GameSetup() {
        populateRoomDescriptions();
        this.rooms[0] = createRoom0();
        this.rooms[1] = createRoom1();
        this.rooms[2] = createRoom2();
        this.rooms[3] = createRoom3();
        this.rooms[4] = createRoom4();
    }

    private void populateRoomDescriptions () {
        roomDescriptions[0] = ("Du står utanför en grotta. Det luktar svavel från öppningen\r\n");
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

    // create the rooms in the dungeon with related doors.
    private Room createRoom0() {
        // create doors for the room firstly.
        Door doorRoom0East = new Door('ö', false, 1, 
        "Grottöppningen är österut. Skriv \"ö\" och tryck på [Enter] för att komma in i grottan");
        doors = new Door[1];
        doors[0] = doorRoom0East; // store in array as that is expected arg.
        // create the room with the created doors as args.
        Room room0 = new Room(this.roomDescriptions[0],0,doors);
        return room0;
    }

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

    private Room createRoom2() {
        Door doorRoom2South = new Door('s', false, 1,
        "Du kan åka söderut [s]");
        Door doorRoom2East = new Door('ö', false, 3,
        "Du kan gå österut [s]");
        doors = new Door[2];
        doors[0] = doorRoom2South;
        doors[1] = doorRoom2East;
        Room room2 = new Room(this.roomDescriptions[2], 2, doors);
        return room2;
    }

    private Room createRoom3() {
        Door doorRoom3East = new Door('ö', false, 7,
        "Du ser en utgång österut [ö]");
        Door doorRoom3West = new Door('v', false, 2,
        "Du kan gå värsterut [v]");
        Door doorRoom3South = new Door('s', false, 2,
        "Du kan åka söderut [s]");
        doors = new Door[3];
        doors[0] = doorRoom3East;
        doors[1] = doorRoom3West;
        doors[2] = doorRoom3South;
        Room room3 = new Room(this.roomDescriptions[3], 3, doors);
        return room3;
    }

    private Room createRoom4() {
        Door doorRoom4East = new Door('ö', false, 6,
        "Du ser en låst dörr i öster [ö]");
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
    
}