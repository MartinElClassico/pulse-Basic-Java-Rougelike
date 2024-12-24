package main.game.utils;

import java.util.Scanner;

/**
 * Class to handle user input and return user input when user input is correct.
 * 
 * @author annemm-3, tulmar-2, evekho-4
 */
public class InputHandler{
    /**
     * Scanner to handle user input.
     */
    private Scanner scanner;

    /**
     * message to be displayed to player if no right choice was taken.
     */
    private static final String WRONG_INPUT_MESSAGE = "ogiltigt val. Försök igen.";

    /**
     * constructor. Creates scanner automatically upon creation.
     */
    public InputHandler(){
        this.scanner = new Scanner(System.in);
    } 

    /**
     * this class does not know when the method should stop to be called.
     * Thus the scanner should be able to be closed from outside once work is done.
     */
    public void closeScanner() {
        scanner.close();
    }

    /**
     * Method that only allows user to return once a valid user input command has been chosen.
     * @param validDirections the valid user command for the player to chose from (excluding 'q')
     * @return the valid chosen command of the player.
     */
    public char getUserInpMovement(char[] validDirections){
        while (true) {
            // get user rawInput
            String input = scanner.nextLine().trim().toLowerCase();
            // convert input to character command, use char null symbol if empty (viz. wrong input).
            // we need to do this as to not create an out of range error if input is an empty string.
            char command = input.isEmpty() ? '\0' : input.charAt(0);
            // check all valid commands.
            for (char direction : validDirections) {
                // if chosen commmand is among valid ones then return.
                if (command == direction) {
                    return command;
                }
            }
            // q is also a valid command (quit)
            if (command == 'q') {
                return 'q';
            }
            // if no valid command chosen, tell user to restart and repeat loop.
            System.out.println(WRONG_INPUT_MESSAGE);
        }
    }
    


}