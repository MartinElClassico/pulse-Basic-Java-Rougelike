## Title: 
pulse-Basic-Java-Rougelike


## Description:
A very basic rougelike game to show fundamental Java programming concepts.
Built using openjdk 21.0.5 2024-10-15 LTS 


## Specific descriptions and delimitations:
The game is small enough for it to need any functionality to change a players name.

The game does not have a function to save, pause or load game.

The game is in Swedish, but is using 'o' instead of 'ö' for user input to avoid language errors.

The doors are created in the rooms, hence there is technically 2 version of each door, with different locations. Can be locked/unlocked with no need for them to be the same.

Comments in the code assume functions that have yet not been implemented, such as 'in case of pause' while there is no pause funtion. This is set assuming the need for future developments.

## Class responsibilities
Door.java
The Door class represents the doors and each doors connection to a room in the dungeon.

DragonTreasure.java
The main class of the game, from which the game starts and ends.

Dungeon.java
This class is responsible for keeping track of the dungeon the player is currently in.

GameLoop.java
The class responsible for the main gameplay, it handles the players interactions with doors and room transitions.

GameSetup.java
This class creates the game, as it initialises the game environment such as rooms, their descriptions and specific doors to each room.

Player.java
This class is responsible for storing the players name.

Room.java
This class represents a room in the game as well as stores information about the room.

## Deviations and additional classes
InputHandler.java
A separate class in utils to handle user input and return user input.

GameSetup and DragonTreasure
The game set up that was originally set to be in the class DragonTresure, is instead done in a separate class to improve readability and modularity of the game by following the single responsibility principle. The GameSetup class creates the rooms in the game, each room description and the belonging doors.

The DragonTreasure class remains the main class of the game that holds the logic to set up the game.

GameLoop and Dungeon
The gameplay logic was originally set in the class Dungeon, however to improve clarity and modularity, we chose to separate the responsibilities of the gameplay logic into two classes, Dungeon and GameLoop.

The GameLoop class focuses and handles player interactions, room transitions and the main gameplay.
The Dungeon class keeps track of the room the player is in.


## How to install and run

1. Make sure Java Development Kit is installed on your machine. Also make sure the PATH directory is added on windows systems.
2. We included BASH scripts to help you run it on Windows, but all files need to be compiled firstly and then DragonTreasure.class needs to be executed with java in a terminal if you want to do it manual or on another OS.
On windows: run compile_and_run.bat or alternatively if you only want to compile it, run: compile.bat

## How to play:
Enter your player name and click enter.
Use commands (s, n , o, v) + enter to navigate.
Use command q + enter to quit the game.


## Future developments
Further potential development of the game.
Add monster, combat and inventory/player health systems.
Include save, pause and load funtion.


## Credits:
Authors: annemm-3, tulmar-2, evekho-4
Course: Programutveckling med Java H24, Luleå Tekniska Universitet
Examinationsuppgift del 1, Dragon Treasure


## Tests:
Testing was done to make sure door interactions and room transitions function correctly.
The testing included multiple trials of invalid user input to ensure the game can sustain variations in user input.
