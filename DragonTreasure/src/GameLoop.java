import java.util.Scanner;

import utils.InputHandler;
/**
 * The gameloop class handles the players interactions and room transitions.
 * Holds the main gameplay.
 * 
 * @author annemm-3, tulmar-2, evekho-4
 */
public class GameLoop {

    private Scanner sc; // Scanner for reading user input throughout the game
    /**
     * holds a static final welcome message to print to player.
     */
    private static final String WELCOME_MESSAGE = ("Välkommen till Dragon Treasure\r\n" + 
    "Skriv ditt namn och tryck på [Enter] för att starta ett nytt spel...");

    /**
     * holds a static final quit message to print to player upon quitting game.
     */
    private static final String QUIT_MESSAGE = "Du lämnar spelet!";

    /**
     * holds the player class, currently only used to print player welcome message.
     */
    private Player player;

    /**
     * holds all the room classes that together make up the dungeon except for the player.
     */
    private Room[] dungeonRooms;

    /**
     * boolean value so the method can keep track of if gameloop is running or not (e.g. paused - not yet implemented)
     */
    private boolean running = true; //so that the loop can be quit from outside.
    
     /**
     * private instance to hold the current room that the player is in.
     */
    private Room currentRoom;

    /**
     * Constructor to initialise the gameloop with an Array containing all rooms in the dungeon.
     * @param dungeonRooms Array containing all rooms in the dungeon.
     */
    public GameLoop(Room[] dungeonRooms) {
        this.sc = new Scanner(System.in);
        this.dungeonRooms = dungeonRooms;
    }

    /**
     * prints welcome message to player.
     */
    private void printWelcomeMsg() {
        System.out.println(WELCOME_MESSAGE);
    }

    /**
     * fetches players name from user input.
     * @return a string of the unsanitized user input
     */
    private String fetchPlayerName() {
        // get user rawInput
        // user input is not controlled since only used to print player name. 
        // fetches user input and trims white characters.
        String userInput = sc.nextLine().trim();
        return userInput;
    }
    
    /**
     * main logic for getting username from player:
     * 1. prints welcome message to the game and input prompt.
     * 2. gets player name.
     * 3. prints personal welcome message to the player
     * @return a string with the name of the player.
     */
    private String promptUserName() {
        printWelcomeMsg();
        String playerName = fetchPlayerName();
        return playerName;
    }

    /**
     * create a new player using the returned name from promptUserName().
     * the name is accessed via a private class atttribute.
     */
    private void getAndSetNewPlayer() {
        this.player = new Player(promptUserName());
        player.printWelcomePlayer(); //prints the player name welcome message.
    }

    /**
     * get status of loop from outside class, is the gameloop running?
     * @return boolean true if loop is running, false if paused or terminated.
     */
    public boolean getRunning() {
        return this.running;
    }

    /**
     * prints the description of the current room. The current room is accesed via private class attribute.
     */
    private void printRoomDesc(){
        System.out.println(this.currentRoom.getRoomDesc());
    }

    /**
     * Prints description of all doors in current room. The current room is accesed via private class attribute.
     */
    private void printAllDoorsDescriptions(){
        Door[] allDoorsInRoom = this.currentRoom.getDoors();
        for (Door doorInRoom : allDoorsInRoom) {
            System.out.println(doorInRoom.getDoorPrompt());
        }
    }

    /**
     * Returns the door the user has chosen based on move direction chosen and the doors avaliable in the room.
     * Has try-throw-catch logic to catch if an invalid roomdirection is chosen.
     * This should never happen however as prior to this method call the users choice has been validated via the 
     * InputHandler.java class.
     * @param roomDirection Users chosen direction to move (has been through input handler to ensure valid direction)
     * @param roomDoors all the doors avaliable in the current room the player moves from.
     * @return a Door object instance that contains the chosen door.
     * @throws IllegalArgumentException if no door matches the given direction.
     */
    private Door fetchChoosenDoor(char roomDirection, Door[] roomDoors) {
        // throws an exception later if no door is found.
        for (Door door : roomDoors) {
            if (door.getPosition() == roomDirection) {
                return door;
            }
        }
        // throw error if no door matches (it does not return from if statement)
        throw new IllegalArgumentException("No Door found in for direction: " + roomDirection);

    }

    /**
     * this method starts the game loop and hold the logic related to said game loop.
     * 
     * @param startRoomID the room id that the loop should start from, is usually 0 at start.
     * this does however make it possible for the game loop to be restarted at a different room based on a 
     * not yet implemented save state or pause state.
     */
    public void start(int startRoomID) {
        InputHandler inpHand = new InputHandler(); // instance of class to make sure user input for direction is legal.
        getAndSetNewPlayer(); //creates the new player and handles output and input terminal statements for that end goal.
        this.currentRoom = this.dungeonRooms[startRoomID]; //set current room that the player starts in.
        boolean doorLocked = false; // if door is locked we should'nt print room description until an unlocked door is chosen.
        // start of the loop the player moves in itterations through.
        while (running) {
        // base loop:
            // print room description, but only if an unlocked door was chosen previously:
            if (!doorLocked) {
                printRoomDesc();
            }
            // print out all door desriptions in room.
            printAllDoorsDescriptions();
            // get user input
            char userInp = inpHand.getUserInpMovement(currentRoom.getDoorDirections());
            // if not q then it is a valid door direction.
            if (userInp != 'q') {
                // get the door the player has chosen to move through.
                Door chosenDoor = fetchChoosenDoor(userInp, currentRoom.getDoors());
                //if door is locked, print door peep 
                if (chosenDoor.getLocked()) {
                    doorLocked = true; // set door locked to true as to not print room desciption.
                    System.out.println(chosenDoor.getKeyholeViewDescription());
                } else {
                    doorLocked = false; // needs to be set so room description is displayer if not locked.
                    // else set the current room to the room the chosen door leads to.
                    this.currentRoom = dungeonRooms[chosenDoor.getConnectedRoomID()];
                }
            }
            // exit condition1:
            // user choses 'q' and quits the game.
            if (userInp == 'q'){
                System.out.println(QUIT_MESSAGE); 
                this.running = false;
            }
            // exit condition2:
            // user finds the dungeon exit.
            if (currentRoom.getRoomId() == 7) {
                // win message is printed later outside while loop.
                this.running = false;
            }
            
        }    
        //end of the loop the player moves in itteration through.
        // check if win condition was reason we exited loop (could be because of death or quit)
        if (currentRoom.getRoomId() == 7) {
            // this correspond to win message.
            printRoomDesc();
        }
        // close all scanners to handle input to avoid resource leaks.
        inpHand.closeScanner(); //close scanner in method to handle checks on user input movement.
        sc.close(); // close scanner used to handle creation of player.
    }


}
