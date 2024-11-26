/**
 * Main class of the game. The game starts from here. 
 * The game is setup from here, and the game is ended from here.
 */
public class DragonTreasure{

    //  private void setupGame() --> we migrate this to it's own java object because of it's size.

    //private void endGame(){
        // logic to end game.
    //}

    public static void main(String[] args){
        // logic to setup the game. e.g.:
        // GameSetup setup = new GameSetup();
        //setup.initalize();
        GameSetup setupDungeon = new GameSetup();
        setupDungeon.promptUserName();
        Room[] dungeonRooms = setupDungeon.getRooms();
        Player newPlayer = setupDungeon.getPlayer();

        // logic to start the game loop (as a loop datatype?)
        // optional: make it exit loop on quit game command and/or death condition.
        // e.g.:
        // GameLoop loop = New GameLoop(setup.getPlayer(), setup.getDungeon());
        // loop.start()
    }
}
