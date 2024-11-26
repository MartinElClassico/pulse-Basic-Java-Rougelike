public class GameLoop {
    private Player player;
    private Room[] dungeonRooms;
    private boolean running = true; //so that the loop can be quit from outside.

    public GameLoop(Player player, Room[] dungeonRooms) {
        this.player = player;
        this.dungeonRooms = dungeonRooms;
    }

    public boolean getRunning() {
        return this.running;
    }

    public void start() {
        int roomID = 0;
        while (running) {
        // base loop:
            // print room description (needs roomID)
            // print out all door desriptions in room.
            // get user input
        // exit condition1:
            // user choses 'q' and quits the game.
        // exit condition2:
            // user finds the dungeon exit.
        //basecase:
            // update roomID based on user input
            // start loop again with the choosen room.
        }      
    }

    
}
