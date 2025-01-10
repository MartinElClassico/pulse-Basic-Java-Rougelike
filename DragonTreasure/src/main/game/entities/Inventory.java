package main.game.entities; 

import java.util.ArrayList;
import java.util.List;

import main.game.items.Item;
import main.game.io.InputHandler;
import main.game.items.Key;
import main.game.items.Treasure;

/**
 * Inventory class to hold and manage items that the player can pick up
 * 
 * @author annemm-3, tulmar-2, evekho-4
 */

public class Inventory {
    /**
     * holds the items the player has picked up.
     */
    private List<Item> items;

    private InputHandler inpHand = new InputHandler(); // Shared InputHandler instance

    /**
     * 
     */
    private static final String ACCESS_INV_PROMPT_MSG = "Du har föremål i din väska. Du kan öppna den och titta [i].";

    /**
     * holds static final message to print when inventory is empty while trying to access it.
     */
    private static final String EMPTY_INV_MESSAGE = "Din väska är tom. Ingenting att se här.";

    /**
     * holds static final message to print on first line when viewing items in inventory.
     */
    private static final String FIRSTLN_INV_MSG = "Din väska innehåller följande:";

    /**
     * holds static final message to print on item selection menu.
     */
    private static final String ITEM_SELECT_PROMPT = "Välj ett föremål genom att trycka på dess nummer. Tryck o för att återgå.";
    
    /**
     * holds static final message to print on no item selected.
     */
    private static final String NO_I_SELECTED_MSG = "Inget valt föremål! Återvänder till rummet.";

    /**
     * holds static final char array of usable commands (except q)
     */
    private static final char[] VIEW_ITEM_COMMANDS = {'v','u'};

    /**
     * holds static final string to format for item selected and actions avaliable.
     */
    private static final String ITEM_USE_PROMPT = "Du valde %s. Tryck [v] för att visa, [u] för att använda eller [q] för att gå tillbaka.";

    /**
     * holds static final char array of usable commands (except q) when item is not usable 
     */
    private static final char[] VIEW_ITEM_COMMANDS_NUSABLE = {'v'};

    /**
     * holds static final string to format for item selected and actions avaliable when item is not usable.
     */
    private static final String ITEM_USE_PROMPT_NUSABLE = "Du valde %s. Tryck [v] för att visa eller [q] för att gå tillbaka.";

    private static final String UNLOCKABLE_DOOR_PROMPT = "Du har nyckeln till dörren och kan låsa upp den [u]!";

    private static final String ITEM_NOT_FOUND_E_MSG = "Föremålet hittades inte i väskan!";
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
            throw new ItemNotFoundException(ITEM_NOT_FOUND_E_MSG);
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
        throw new ItemNotFoundException(ITEM_NOT_FOUND_E_MSG);
    }

    /**
     * prints the items in the inventory with numbering.
     * @return isNotEmpty boolean if inventory is empty return false otherwise true.
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
                System.out.printf("%d. %s - %s%n", i+1, item.getName(), item.getDescription());
            }
            return true;
        }
        }
    
    /**
     * Prints the inventory and handles user chosing an item from the inventory.
     * @return null if no item was chosen or if inventory was empty. 
     * the item selected otherwise.
     */
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

    /**
     * public method accessed from player class to manage inventory. 
     * @return the item chosen, if no item was chosen, it returns null.
     */
    public Item manageInventory() {
        Item chosenItem = accessInventory();
        // did not chose anything, so return null.
        if (chosenItem == null) {
            return null;
        }
        // show menu for what can be done with object and return to main.
        // viz. view item (v) --> return null, or use item (u)--> return item:
        char chosenAction = itemUseMenu(chosenItem);
        if (chosenAction == 'q' || chosenAction == 'v') {return null;} 
        else {return chosenItem;}
    }

    /**
     * does the chosen action with the chosen item.
     * @param chosenItem the Item selected by the player.
     * @param choice legal option (char) for what can be done with the item.
     * @return char, the chosen action of the player.
     */
    private char handleItemMenu (Item chosenItem, char choice) {
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

    /**
     * Handles what a user can do with a chosen item.
     * @param chosenItem Item chosen by the player.
     * @return the legal command that the user wants to do with the item.
     */
    private char itemUseMenu(Item chosenItem) {
        // handle options avalible depending on if item is usable or not.
        if (chosenItem.getUsable()) {
            // prints "you selected {item}" along with keypresses avaliable.
            System.out.printf(ITEM_USE_PROMPT, chosenItem.getName());
            char choice = inpHand.handleCharToken(VIEW_ITEM_COMMANDS, 'q');
            return handleItemMenu(chosenItem, choice);
        } else {
            System.out.printf(ITEM_USE_PROMPT_NUSABLE, chosenItem.getName());
            char choice = inpHand.handleCharToken(VIEW_ITEM_COMMANDS_NUSABLE, 'q');
            return handleItemMenu(chosenItem, choice);
        }
    }

    /**
     * prompt for what to print when a player uses an item.
     * @param item the item chosen by the player.
     */
    private void useItemPrompt(Item item){
        System.out.printf("Du använder %s!%n%n", item.getName().toLowerCase());
    }

    /**
     * prompt for what to print when a player views an item.
     * @param item the item chosen by the player.
     */
    private void viewItem(Item item) {
        System.out.printf("%s - %s%n", item.getName(), item.getDescription());
        System.out.println(item.getAsciiArt());
    }

    /**
     * Prints the inventory and tells if inventory has items in it or not.
     * @return boolean, true if has items, false if empty.
     */
    public boolean printInventoryPrompt(){
        if (!items.isEmpty()){
            System.out.println(ACCESS_INV_PROMPT_MSG);
            return true;
        }
        return false;
    }

    /**
     * method to close io scanner from outside class once done.
     */
    public void closeInput() {
        inpHand.closeScanner(); // Close Scanner only once when done
    }

    /**
     * Method to check if key exists in inventory
     * @return true if key exists in inventory
     */
    public boolean checkKey(){
        for (Item item : items) {
            if (item instanceof Key){
                return true;
            }
        }
        return false;
    }

/**
 * Method to check if treasure exists in inventory
 * @return true if treasure exists in inventory
 */
    public boolean checkTreasure(){
        for (Item item : items) {
            if (item instanceof Treasure){
                return true;
            }
        }
        return false;
    }

/**
 * Method to prompt user to use key. Door unlock is not handled here.
 * @param key the key to be used
 * @return boolean true if key was used, false if not used.
 */
    public boolean keyUsePrompt(Key key) {
        // make key usable.
        key.setUsable(true);
        System.out.println(UNLOCKABLE_DOOR_PROMPT);
        char command = itemUseMenu(key);
        // return key to original state of not usable.
        key.setUsable(false);
        if (command == 'u'){return true;}
        else {
            return false;
        }
    }
}
