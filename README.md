## Title: 
pulse-Basic-Java-Rougelike


## Description:
A very basic rougelike game to show fundamental Java programming concepts.
Built using openjdk 21.0.5 2024-10-15 LTS 


## Specific descriptions and delimitations:
The game is small enough for it to not need any functionality to change a players name.

The game does not have a function to save, pause or load game.

The game is in Swedish, but is using 'o' instead of 'ö' for user input to avoid language errors.

The doors are created in the rooms, hence there is technically 2 version of each door, with different locations. Can be locked/unlocked with no need for them to be the same.

Comments in the code assume functions that have yet not been implemented, such as 'in case of pause' while there is no pause funtion. This is set assuming the need for future developments.


## Class responsibilities
Door.java
The Door class represents the doors and each doors connection to a room in the dungeon. Holds information whether the door is locked or not.

DragonTreasure.java
The main class of the game, from which the game starts and ends.

Dungeon.java
This class is responsible for keeping track of the dungeon the player is currently in.

GameLoop.java
The class responsible for the main gameplay, it handles the players interactions with doors, monsters, items and room transitions.

GameSetup.java
This class creates the game, as it initialises the game environment such as rooms, items, monsters and their descriptions. It places them accordingly.

Player.java
This class represents a player in the game, and holds player information such as health point, damage and inventory.

Monster.java
This class represents a monster in the game, and stores information such as damage, health point, ascii art and description.

Inventory.java
This class represents an inventory in the game, holds the logic to interact with items

Room.java
This class represents a room in the game as well as stores information about the room and its contents.

Item.java
This class represents an item in the game, and the methods to interact with it.
A superclass to:

Key.java
This class represents a key in the game, can unlock doors

Potion.java
This class represents a potion in the game, can be used to increase health points

Treasure.java
This class represents a treasure in the game with a gold value

Weapon.java
This class represent a weapon in the game, can be used to increase players damage


## Folder structure
1. Entities
Holds entities, viz. "living" things in the world. 
May also hold some basic files whos logic is closely related to this.

2. IO
Holds io (input output) handling logic, 
that is to say to make sure the player input is handled correctly and 
that the player is informed when incorrect input is given (output).

3. Items
Holds items that exists in the world.

4. Resources
Holds static java objects that basically do not have any logic but has content.
e.g. art or pictures or in this case, ASCII-art.

5. Services
Logic heavy code is stored here.

6. World
This stores classes needed for the world in which the player exists.


## Deviations and additional classes
InputHandler.java
A separate class in utils to handle user input and return user input.

ItemNotFoundException.java
Class to throw an exception when item is not found

AsciiArt.java
A separate class to hold and handle the ascii art

GameSetup and DragonTreasure
The game set up that was originally set to be in the class DragonTresure, is instead done in a separate class to improve readability and modularity of the game by following the single responsibility principle. The GameSetup class creates the rooms in the game, each room description and the belonging doors.

The DragonTreasure class remains the main class of the game that holds the logic to set up the game.

GameLoop and Dungeon
The gameplay logic was originally set in the class Dungeon, however to improve clarity and modularity, we chose to separate the responsibilities of the gameplay logic into two classes, Dungeon and GameLoop.

The GameLoop class focuses and handles player interactions, room transitions and the main gameplay.
The Dungeon class keeps track of the room the player is in.

Inventory as a separate class. Separates inventory handling from player class. Keeps the modularity.


## How to install and run

Windows:

1. Make sure Java Development Kit is installed on your machine. Also make sure the PATH directory is added on windows systems.
2. We included BASH scripts to help you run it on Windows, but all files need to be compiled firstly and then DragonTreasure.class needs to be executed with java in a terminal if you want to do it manual or on another OS.
On windows: run compile_and_run.bat or alternatively if you only want to compile it, run: compile.bat

Linux/iOS:

1. 


## How to play:
Enter your player name and click enter.
Use commands (s, n , o, v) + enter to navigate.
Use command q + enter to quit the game.
Use i to access inventory.
Use p to pickup an item.
Use u to use an item.
Use v to view an item.


## Future developments
Further potential development of the game.
Include save, pause and load funtion.
Develop the game further by implementing more rooms and contents such as items and monster.
Include different types of monsters with different functions using subclasses.
Adding an element of randomized attack damage.
Developing an active combat.


## Credits:
Authors: annemm-3, tulmar-2, evekho-4
Course: Programutveckling med Java H24, Luleå Tekniska Universitet
Examinationsuppgift del 2, Dragon Treasure


## Tests:
Testing was done to make sure door interactions and room transitions function correctly.
Testing was done to make sure interactions with items and monsters function correctly.
The testing included multiple trials of invalid user input to ensure the game can sustain variations in user input.
Testing was also done using test files.