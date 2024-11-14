package utils;

import java.util.Scanner;

/**
 * Class to handle user input and return user input when user input is correct.
 */
public class InputHandler{
    private Scanner scanner;

    private void printAvaliableDirections(char[] validDirections) {
        // TODO: add to readme that we only had "gå" as it seemed random as to if "gå" or "åker" was used or possibly binded to room.
        // iterate through all avaliable directions:
        for (char direction : validDirections) {
            switch(direction) {
                case 'n':
                    System.out.println("Du kan gå norrut [n]"); 
                    break;
                case 's':
                    System.out.println("Du kan gå söderut [s]"); 
                    break;
                case 'ö':
                    System.out.println("Du kan gå österut [ö]"); 
                    break;
                case 'v':
                    System.out.println("Du kan gå västerut [v]");
                    break;
                default:
                    break; // do nothing if direction is invalid as per above.
            }
        }
    }
        

    public char getUserInpMovement(char[] validDirections){
        // create scanner to get input. 
        this.scanner = new Scanner(System.in);
        while (true) {
            // show avaliable directions user can go:
            printAvaliableDirections(validDirections);

            // get user rawInput
            String input = scanner.nextLine().trim().toLowerCase();
            // convert input to character command, use char null symbol if empty (viz. wrong input).
            // we need to do this as to not create an out of range error if input is an empty string.
            char command = input.isEmpty() ? '\0' : input.charAt(0);

            for (char direction : validDirections) {
                if (command == direction) {
                    this.scanner.close(); // close to not get resource leaks
                    return command;
                }
            }

            if (command == 'q') {
                this.scanner.close(); // close to not get resource leaks
                return 'q';
            }

            System.out.println("ogiltigt val. Försök igen.");
        }
    }
    


}