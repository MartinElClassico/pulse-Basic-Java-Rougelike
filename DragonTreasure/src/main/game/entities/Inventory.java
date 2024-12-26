package main.game.entities; 

import java.util.ArrayList;
import java.util.List;

import main.game.items.Item;
import main.game.io.InputHandler;

public class Inventory {
    /**
     * holds the items the player has picked up.
     */
    private List<Item> items;

    /**
     * holds static final message to print when inventory is empty while trying to access it.
     */
    private static final String EMPTY_INV_MESSAGE = "Your inventory is empty. Nothing to see here.";

    /**
     * holds static final message to print on first line when viewing items in inventory.
     */
    private static final String FIRSTLN_INV_MSG = "Your inventory contains:";

    private static final String NO_I_SELECTED_MSG = "No item selected! Returning from inventory.";

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
     * @throws IllegalArgumentException if the item to be removed is not found, it will throw an error.
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
            throw new IllegalArgumentException("Item not found in inventory!");
        }
    }

    /**
     * fetches an item from the inventory.
     * @param itemName the name of the item to be fetched from the inventory.
     * @return foundItem the item found in the inventory.
     * @throws IllegalArgumentException if the item to be fetched is not found, it will throw an error.
     */
    public Item getItem(String itemName) {
        for (Item item: items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Item not found in inventory!");
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
                System.out.printf("%d.%t %s%n", i+1, item.getName());
            }
            return true;
        }
        }

    public Item accessInventory() {
        boolean hasItems = printInventory();
        if (hasItems) {
            InputHandler inpHand = new InputHandler(); // instance of class to make sure input is legal.
            int choice = inpHand.handleIntToken(0+1, items.size(), 0);
            // handle user input and get user output.
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

}
