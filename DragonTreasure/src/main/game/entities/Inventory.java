package main.game.entities; 

import java.util.ArrayList;
import java.util.List;

import main.game.items.Item;
import main.game.io.InputHandler;
import main.game.entities.ItemNotFoundException;

public class Inventory {
    /**
     * holds the items the player has picked up.
     */
    private List<Item> items;

    private InputHandler inpHand = new InputHandler(); // Shared InputHandler instance

    /**
     * holds static final message to print when inventory is empty while trying to access it.
     */
    private static final String EMPTY_INV_MESSAGE = "Your inventory is empty. Nothing to see here.";

    /**
     * holds static final message to print on first line when viewing items in inventory.
     */
    private static final String FIRSTLN_INV_MSG = "Your inventory contains:";

    private static final String ITEM_SELECT_PROMPT = "Choose an item by pressing its number. Press 0 to return.";
    
    private static final String NO_I_SELECTED_MSG = "No item selected! Returning from inventory.";

    private static final char[] VIEW_ITEM_COMMANDS = {'v','u'};

    private static final String ITEM_USE_PROMPT = "You selected %s. Press v to view it, u to use or q to go back.";


    /**
     * contructor, initalizes inventory.
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /**
     * add an Item to the inventory.
     * @param item Item instance to be added to inventory.
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * removes a stored Item object from the inventory.
     * @param itemName the name of the object to be removed.
     * @throws ItemNotFoundException if the item to be removed is not found, it will throw an error.
     */
    public void removeItem(String itemName) {
        boolean success = false;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                items.remove(item);
                success = true;
                break;
            }
        }
        if (!success) {
            throw new ItemNotFoundException("Item not found in inventory!");
        }
    }

    /**
     * fetches an item from the inventory.
     * @param itemName the name of the item to be fetched from the inventory.
     * @return foundItem the item found in the inventory.
     * @throws ItemNotFoundException if the item to be fetched is not found, it will throw an error.
     */
    public Item getItem(String itemName) {
        for (Item item: items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        throw new ItemNotFoundException("Item not found in inventory!");
    }

    /**
     * 
     */
    private boolean printInventory() {
        // handle if item is empty otherwise print all items:
        if (items.isEmpty()) {
            System.out.println(EMPTY_INV_MESSAGE);
            return false;
        } else {
            System.out.println(FIRSTLN_INV_MSG);
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                // print out the items with index first (+1), so that player can access them through index later.
                System.out.printf("%d. %s%n", i+1, item.getName());
            }
            return true;
        }
        }
    
    private Item accessInventory() {
        boolean hasItems = printInventory();
        if (hasItems) {
            System.out.println(ITEM_SELECT_PROMPT);
            // handle user input and get user output.
            int choice = inpHand.handleIntToken(0+1, items.size(), 0);
            // act according to what the user chose to do:
            if (choice == 0) {
                System.out.println(NO_I_SELECTED_MSG);
                return null;
            } else {
                return items.get(choice - 1);
            }
        } else {
            return null;
        }
    }

    public Item manageInventory() {
        Item chosen_item = accessInventory();
        // did not chose anything, so return null.
        if (chosen_item == null) {
            return null;
        }
        // show menu for what can be done with object and return to main.
        // viz. view item (v) --> return null, or use item (u)--> return item:
        char chosen_action = itemUseMenu(chosen_item);
        if (chosen_action == 'q') {return null;} 
        else {return chosen_item;}
    }

    private char itemUseMenu(Item chosenItem) {
        // prints "you selected {item}" along with keypresses avaliable.
        System.out.printf(ITEM_USE_PROMPT, chosenItem.getName());
        char choice = inpHand.handleCharToken(VIEW_ITEM_COMMANDS, 'q');
        switch (choice) {
            case 'v':
                viewItem(chosenItem);
                return 'v';
            case 'q':
                return 'q';
            default:
                useItemPrompt(chosenItem);
                return 'u';
        }
    }

    private void useItemPrompt(Item item){
        System.out.printf("You use %s!", item.getName());

    }

    private void viewItem(Item item) {
        System.out.printf("%s - %s%n", item.getName(), item.getDescription());
        System.out.println(item.getAsciiArt());
    }

    public void closeInput() {
        inpHand.closeScanner(); // Close Scanner only once when done
    }

    // TODO: add useItem private method, perhaps should be in Player.java?

    // TODO: make public method called "manageInventory" and make it so that it can use the items therein.
    // alternatively, add this functionality to player.


}
