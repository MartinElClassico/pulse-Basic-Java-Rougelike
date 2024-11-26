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
        // logic to setup the game.
        GameSetup setupDungeon = new GameSetup();
        // prompt user for username and welcome player to game.
        setupDungeon.promptUserName();

        // get data to create gameloop from setup.
        Room[] dungeonRooms = setupDungeon.getRooms();
        Player newPlayer = setupDungeon.getPlayer();
        // create loop.
        GameLoop loop = new GameLoop(newPlayer, dungeonRooms);
        // start a gameloop.
        loop.start();
        // NOTE: we need to sleep a little here otherwise game will just terminate immediately.
    }
}
