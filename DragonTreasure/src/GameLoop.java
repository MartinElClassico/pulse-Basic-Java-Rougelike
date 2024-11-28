import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.InputHandler;

public class GameLoop {
    private Scanner sc;
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

    public GameLoop(Room[] dungeonRooms) {
        this.sc = new Scanner(System.in);
        this.dungeonRooms = dungeonRooms;
    }

    private void printWelcomeMsg() {
        System.out.println(welcomeMessage);
    }

    private String fetchPlayerName() {
        // create scanner to get input. 
        // get user rawInput
        // TODO: check if we need a loop here to control user input or not. 
        // TODO: motivate why .trim is used (remove leading&trailing whitespaces, return "" string.)
        String userInput = sc.nextLine().trim();
        return userInput;
    }

    // print welcomemessage to user:
    private void printWelcomePlayer(String playerName) {
        System.out.printf("Välkommen %s till din skattjakt.%n", playerName);
    }

    // TODO: motivate if this should be public or private with a help method (public).
    // Note: keep public in case called on externally
    private String promptUserName() {
        printWelcomeMsg();
        String playerName = fetchPlayerName();
        printWelcomePlayer(playerName);
        return playerName;
    }

    private void getAndSetNewPlayer() {
        this.player = new Player(promptUserName());
    }

    public boolean getRunning() {
        return this.running;
    }

    private void printRoomDesc(){
        System.out.println(this.currentRoom.getRoomDesc());
    }

    private void printAllDoorsDescriptions(){
        Door[] allDoorsInRoom = this.currentRoom.getDoors();
        for (Door doorInRoom : allDoorsInRoom) {
            System.out.println(doorInRoom.getDoorPrompt());
        }
    }

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

    private Room fetchNewRoom(char roomDirection, Door[] roomDoors) {
        int newRoomID = 10; // just because IDE doesn't know for loop should always resolve. (:
        for (Door door : roomDoors) {
            if (door.getPosition() == roomDirection) {
                newRoomID = door.getConnectedRoomID();
            }
        }
        return dungeonRooms[newRoomID];
    }

    public void start(int startRoomID) {
        InputHandler inpHand = new InputHandler();
        getAndSetNewPlayer();
        this.currentRoom = this.dungeonRooms[startRoomID];
        while (running) {
        // base loop:
            // print room description
            printRoomDesc();
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
            } else {
                // if not q then it is a valid door direction.
                // case: 
                    // is in roomId 0 and
                    // userInp = 'ö'
                this.currentRoom = fetchNewRoom(userInp, currentRoom.getDoors());
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
