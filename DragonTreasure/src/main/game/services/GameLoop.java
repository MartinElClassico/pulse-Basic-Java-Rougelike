package main.game.services;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Thread;

import main.game.entities.Player;
import main.game.io.InputHandler;
import main.game.items.Item;
import main.game.world.Door;
import main.game.world.Room;
import main.game.entities.Monster;
import main.game.items.Key;

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

    private static final String GAME_OVER_DIED_MSG = "Du dog i kamp mot ett monster! Game Over!";
    /**
     * holds a static final int of the maximum HP the player has. 
     * used to create player. 
     */
    private static final int MAX_HP = 50;

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
     * @return userInput a string of the unsanitized user input
     */
    private String fetchPlayerName() {
        // get user rawInput
        // user input is not controlled since only used to print player name. 
        // fetches user input and trims white characters.
        return sc.nextLine().trim();
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
        return fetchPlayerName();
    }

    /**
     * create a new player using the returned name from promptUserName().
     * the name is accessed via a private class atttribute.
     */
    private void getAndSetNewPlayer() {
        this.player = new Player(promptUserName(), MAX_HP);
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
     * Helper function to cast List<Character> to char[], viz. a list array of Characters to an array of chars.
     * @param charList List array of Characters
     * @return charArray Array of chars.
     */
    private static char[] listToCharArray(List<Character> charList) {
        char[] charArray = new char[charList.size()]; // Create char array of the same size as list array.
        // populate array with contents in list array.
        for (int i = 0; i < charList.size(); i++) {
            charArray[i] = charList.get(i);
        }
        return charArray;
    }

    private char[] getAvaliableCommands(boolean hasItems){
        List<Character> charCommands = new ArrayList<>();
        if (hasItems) {charCommands.add('i');}
        for(@SuppressWarnings("unused") Item ignored : currentRoom.getItems()){
            charCommands.add('p');
        }
        for(char chardoor : currentRoom.getDoorDirections()){
            charCommands.add(chardoor);
        }
        return listToCharArray(charCommands);
    }

    private boolean playerRoomChange(char userInp) {
        // get the door the player has chosen to move through.
        Door chosenDoor = fetchChoosenDoor(userInp, currentRoom.getDoors());
        //if door is locked, print door peep 
        if (chosenDoor.getLocked()) {
            // logic to check for key in inventory and print out options.
            boolean unlockDoor = checkLockedDoor(chosenDoor);
            if (unlockDoor){
                //Key is automatically used to unlock the door
                System.out.println("Du använder nyckeln och låser upp dörren.");
                //Move through the previously locked door
                this.currentRoom = dungeonRooms[chosenDoor.getConnectedRoomID()];
                return false; // set locked door to false to print room description
            }
            else{
                System.out.println(chosenDoor.getKeyholeViewDescription());
                return true;// set door locked to true as to not print room desciption.
            }
        } else {
            // else set the current room to the room the chosen door leads to.
            this.currentRoom = dungeonRooms[chosenDoor.getConnectedRoomID()];
            return false; // needs to be set so room description is displayer if not locked.
        }
    }

    /**
     * Adds items in current room to the player inventory and deletes them from the room.
     */
    private void addItemToPlayerInventory(){
        // since we remove items we need to use an itterator to not get read/write conflicts.
        Iterator<Item> iterator = currentRoom.getItems().iterator();
        // access items in room until there is none left.
        while(iterator.hasNext()){
            // get next item in the list.
            Item item = iterator.next();
            // add item to player inventory.
            player.getInventory().addItem(item);
            // delete item from the room as it has been picked up.
            iterator.remove();
            // print item picked up prompt.
            System.out.println(item.getPickedUpItemPrompt());
        }
    }

    private char playerChoice(InputHandler inpHand){
        //print out inventory access if avaliable
        boolean invHasItems = player.getInventory().printInventoryPrompt();
        //print out all item prompts in room.
        this.currentRoom.printAllItemDescriptions();
        // print out all door desriptions in room.
        this.currentRoom.printAllDoorsDescriptions();
        // get user input
        char userInp = inpHand.handleCharToken(getAvaliableCommands(invHasItems), 'q');
        return userInp;
    }

    private boolean doBattle(Monster monster) {
        boolean monsterAlive = true;
        boolean playerAlive = true;
        while (monsterAlive && playerAlive) {
            playerAlive = monster.attackPlayer(player);
            sleep(200);
            if (playerAlive){
                monsterAlive = monster.attackMonster(player.getAttackDamage());
                sleep(200);
            }
        }
        return playerAlive;
        
    }

    private boolean faceMonster() {
        // since we remove monsters we need to use an itterator to not get read/write conflicts.
        Iterator<Monster> iterator = currentRoom.getMonsters().iterator();
        boolean playerAlive = true;
        // access monsters in room until there is none left.
        while(iterator.hasNext()){
            if (playerAlive) {
                // get next monster in the list.
                Monster monster = iterator.next();
                //print ascii art of enemy
                System.out.println(monster.getAsciiArt());
                //print monster descriptor
                System.out.println(monster.getMonsterDesc() + " dyker upp framför dig!");
                //battle with monster.
                playerAlive = doBattle(monster); // battle outcome message is handled in doBattle unless player died.
                // remove monster from room.
                if (playerAlive) {iterator.remove();}
            }
        }
        return playerAlive;
        
    }

    /**
     * Method to get delays in the program
     * @param milliSeconds to sleep
     */
    private void sleep(int milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        //catch to clear interrupted message, if the thread is interrupted while sleeping
        } catch (InterruptedException e) {
            //Restore interrupt flag
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Method to call for the door to be unlocked if the player has a key in their inventory
     * @param lockedDoor
     * @return boolean true if the door is unlocked, false if not
     */
    private boolean checkLockedDoor(Door lockedDoor){
        boolean hasKey = player.getInventory().checkKey();
        if (hasKey){
            Item item = player.getInventory().getItem("Nyckel");
            if(item instanceof Key key) {
                boolean unlockedDoor = player.getInventory().keyUsePrompt(key);
                if (unlockedDoor){
                    lockedDoor.unlockDoor("Du kan gå österut [o]");
                    return true;
                }
            }
        }
        return false;
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
        boolean playerAlive = true;
        // start of the loop the player moves in itterations through.
        while (running && playerAlive) {
        // base loop:
            if (!currentRoom.getMonsters().isEmpty()) {
                playerAlive = faceMonster();
                if (!playerAlive) {break;}
            }
            // print room description, but only if an unlocked door was chosen previously:
            if (!doorLocked) {
                printRoomDesc();
            }
            char userInp = playerChoice(inpHand);
            // if not q then it is a valid door direction.
            if (userInp != 'q') {
                if (userInp == 'i') {
                    player.accessInventory();
                }
                else if (userInp == 'p') {
                    addItemToPlayerInventory();
                } else {
                    // changes the room and tells wether the door the user wanted to access is still locked or not.
                    doorLocked = playerRoomChange(userInp);
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
        if (!playerAlive) {
            System.out.println(GAME_OVER_DIED_MSG);
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
