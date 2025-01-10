package main.game.entities;

/**
 * Exception that is thrown when an item is not found in the game
 * Extends RuntimeException
 * 
 * @author annemm-3, tulmar-2, evekho-4
 */

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
