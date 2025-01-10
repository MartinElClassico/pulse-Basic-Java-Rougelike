package main.game.io;

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
     * @return the valid chosen command of the player or the quit command.
     */
    public char handleCharToken(char[] validChars, char quitInput){
        while (true) {
            // get user rawInput
            String input = scanner.nextLine().trim().toLowerCase();
            // convert input to character command, use char null symbol if empty (viz. wrong input).
            // we need to do this as to not create an out of range error if input is an empty string.
            char command = input.isEmpty() ? '\0' : input.charAt(0);
            // check all valid commands.
            for (char direction : validChars) {
                // if chosen commmand is among valid ones then return.
                if (command == direction) {
                    return command;
                }
            }
            // q is also a valid command (quit)
            if (command == quitInput) {
                return command;
            }
            // if no valid command chosen, tell user to restart and repeat loop.
            System.out.println(WRONG_INPUT_MESSAGE);
        }
    }

/**
 * Method 
 */
    public int handleIntToken(int validMinInt, int validMaxInt, int quitInput) {
        while (true){
            try {
                int command = Integer.parseInt(scanner.nextLine());
                boolean isInValidRange = (command >= validMinInt && command <= validMaxInt);
                if ((command == quitInput) || (isInValidRange)) {
                    return command;
                }    
                // has not returned, thus no correct input was chosen.
                System.out.println(WRONG_INPUT_MESSAGE);
                // catch exception if user provides a token that is not an int.
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT_MESSAGE);
            }
        }      
    }


    


}