package utils;

import java.util.Scanner;

/**
 * Class to handle user input and return user input when user input is correct.
 */
public class InputHandler{
    private Scanner scanner;

    public InputHandler(){
        this.scanner = new Scanner(System.in);
    } //empty constructor. 

    public void closeScanner() {
        scanner.close();
    }

    public char getUserInpMovement(char[] validDirections){
        while (true) {
            // get user rawInput
            String input = scanner.nextLine().trim().toLowerCase();
            // convert input to character command, use char null symbol if empty (viz. wrong input).
            // we need to do this as to not create an out of range error if input is an empty string.
            char command = input.isEmpty() ? '\0' : input.charAt(0);

            for (char direction : validDirections) {
                if (command == direction) {
                    return command;
                }
            }
            if (command == 'q') {
                return 'q';
            }
            System.out.println("ogiltigt val. Försök igen.");
        }
    }
    


}