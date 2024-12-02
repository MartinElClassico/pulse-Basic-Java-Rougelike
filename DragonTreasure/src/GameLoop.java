import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.InputHandler;
/**
 * The gameloop class handles the players interactions and room transitions.
 * Holds the main gameplay.
 */
public class GameLoop {
    private Scanner sc; // Scanner for reading user input throughout the game
    private static String welcomeMessage = ("Välkommen till Dragon Treasure\r\n" + 
    "Skriv ditt namn och tryck på [Enter] för att starta ett nytt spel...");
    private static String quitMessage = "Du lämnar spelet!";
    private Player player;
    private Room[] dungeonRooms;
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
// prints welcome message to player.
    private void printWelcomeMsg() {
        System.out.println(welcomeMessage);
    }
// fetches players name from user input
    private String fetchPlayerName() {
        // create scanner to get input. 
        // get user rawInput
        // TODO: check if we need a loop here to control user input or not. 
        // fetches user input and trims white characters.
        String userInput = sc.nextLine().trim();
        return userInput;
    }

    // print welcomemessage to user:
    private void printWelcomePlayer(String playerName) {
        System.out.printf("Välkommen %s till din skattjakt.%n", playerName);
    }

    // TODO: motivate if this should be public or private with a help method (public).
    // Note: keep public in case called on externally.
    // prompt player to enter username and returns it as a String.
    
    private String promptUserName() {
        printWelcomeMsg();
        String playerName = fetchPlayerName();
        printWelcomePlayer(playerName);
        return playerName;
    }
// create a new player using the returned name from promptUserName().
    private void getAndSetNewPlayer() {
        this.player = new Player(promptUserName());
    }

    public boolean getRunning() {
        return this.running;
    }
// prints the description of the current room.
    private void printRoomDesc(){
        System.out.println(this.currentRoom.getRoomDesc());
    }
// get description of all doors in current room.
    private void printAllDoorsDescriptions(){
        Door[] allDoorsInRoom = this.currentRoom.getDoors();
        for (Door doorInRoom : allDoorsInRoom) {
            System.out.println(doorInRoom.getDoorPrompt());
        }
    }
    
// return an Array with valid directions (doors) in current room
    private char[] validDirectionsInRoom() {
        // create list of characters to store valid directions.
        List<Character> validDirectionsList = new ArrayList<Character>();
        // all door objects in the current room.
        Door[] allDoorsInRoom = this.currentRoom.getDoors();
        // store all door positions of room in list.
        for (Door doorInRoom : allDoorsInRoom) {
            validDirectionsList.add(doorInRoom.getPosition());
        }
        // create char array to store list elements inside of array instead of list.
        char[] validDirectionArray = new char[validDirectionsList.size()];
        // store each element from list in array.
        for (int i = 0; i<validDirectionsList.size(); i++){
            // convert each list element of type Object to char type and store in array.
            validDirectionArray[i] = (char)validDirectionsList.get(i);
        }
        return validDirectionArray;
    }

    private Door fetchChoosenDoor(char roomDirection, Door[] roomDoors) {
        // try-catch in-case the if loop fails to return anything.
        try {
            for (Door door : roomDoors) {
                if (door.getPosition() == roomDirection) {
                    return door;
                }
            }
            // throw error if no door matches (it does not return from if statement)
            throw new IllegalArgumentException("No Door found in for direction: " + roomDirection);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); //show error code.
            return null; // needs a return statement.
        }
    }


    public void start(int startRoomID) {
        InputHandler inpHand = new InputHandler();
        getAndSetNewPlayer();
        this.currentRoom = this.dungeonRooms[startRoomID];
        boolean doorLocked = false; // if door is locked we should'nt print room description until an unlocked door is chosen.
        while (running) {
        // base loop:
            // print room description, but only if an unlocked door was chosen previously:
            if (!doorLocked) {
                printRoomDesc();
            }
            // print out all door desriptions in room.
            printAllDoorsDescriptions();
            // get user input
            char userInp = inpHand.getUserInpMovement(validDirectionsInRoom());
            // TODO: no logic for peeking through locked door (default move).
            // exit condition1:
            // user choses 'q' and quits the game.
            if (userInp == 'q'){
                System.out.println(quitMessage); 
                this.running = false;
            }
            // if not q then it is a valid door direction.
            if (userInp != 'q') {
                doorLocked = false; // always reset locked status first.
                // add logic here for if door is locked.
                Door chosenDoor = fetchChoosenDoor(userInp, currentRoom.getDoors());
                //if door is locked, print door peep 
                if (chosenDoor.getLocked()) {
                    doorLocked = true;
                    System.out.println(chosenDoor.getKeyholeViewDescription());
                } else {
                    // else set the current room to the room the chosen door leads to.
                    this.currentRoom = dungeonRooms[chosenDoor.getConnectedRoomID()];
                }
                //this.currentRoom = fetchNewRoom(userInp, currentRoom.getDoors());
            }
            // exit condition2:
            // user finds the dungeon exit.
            if (currentRoom.getRoomId() == 7) {
                // win message is printed later outside while loop.
                this.running = false;
            }
            
        }    
        if (currentRoom.getRoomId() == 7) {
            // this correspond to win message.
            printRoomDesc();
        }
        inpHand.closeScanner();
        sc.close();
    }


}
