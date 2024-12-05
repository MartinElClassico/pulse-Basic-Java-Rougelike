/**
 * Main class of the game. The game starts from here. 
 * The game is setup from here, and the game is ended from here.
 * 
 * @author annemm-3, tulmar-2, evekho-4
 */
public class DragonTreasure{

    /*
        private void setupGame() --> we migrate this to it's own java object because of it's size.
        It is now in a class called GameSetup.java
        */  

    public static void main(String[] args){
        // logic to setup the game.
        GameSetup setupDungeon = new GameSetup();
        // get data to create gameloop from setup.
        Room[] dungeonRooms = setupDungeon.getRooms();
        // create loop.
        GameLoop loop = new GameLoop(dungeonRooms);
        // start a gameloop.
        loop.start(0);
        // NOTE: we need to sleep a little here otherwise game will just terminate immediately.
        // method --> keep pr
    }
}
