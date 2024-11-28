import java.util.Scanner;

public class GameLoop {
    private Scanner sc;
    private static String welcomeMessage = ("Välkommen till Dragon Treasure\r\n" + 
    "Skriv ditt namn och tryck på [Enter] för att starta ett nytt spel...");
    private Player player;
    private Room[] dungeonRooms;
    private boolean running = true; //so that the loop can be quit from outside.

    public GameLoop(Room[] dungeonRooms) {
        this.dungeonRooms = dungeonRooms;
    }

    private void printWelcomeMsg() {
        System.out.println(welcomeMessage);
    }

    private String fetchPlayerName() {
        // create scanner to get input. 
        this.sc = new Scanner(System.in);
        // get user rawInput
        // TODO: check if we need a loop here to control user input or not. 
        // TODO: motivate why .trim is used (remove leading&trailing whitespaces, return "" string.)
        String userInput = sc.nextLine().trim();
        this.sc.close(); // close to not get resource leaks
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

    public void start() {
        getAndSetNewPlayer();
        int roomID = 0;
        while (running) {
        // base loop:
            // print room description (needs roomID)
            // print out all door desriptions in room.
            // get user input
            //COND CHECK:
                // if user input is not 'q' then:
                    // update roomID based on user input
        // exit condition1:
            // user choses 'q' and quits the game.
        // exit condition2:
            // user finds the dungeon exit.
            // e.g. roomID == 7;
        //basecase:
            // start loop again with the choosen room.
        }      
    }


}
