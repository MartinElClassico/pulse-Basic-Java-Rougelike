package tests.main.game.entities;

import main.game.entities.Inventory;
import main.game.entities.ItemNotFoundException;
import main.game.items.*;

public class InventoryTest {
    public static void main(String[] args) {
        // Create an inventory instance
        Inventory inventory = new Inventory();

        // Create and add sample items
        Weapon sword = new Weapon("Sword", "A sharp blade.", 2);
        Key key = new Key("Key", "An old rusty key.", 4, 'o');
        Potion potion = new Potion("Potion", "Heals 50 HP.", 50);

        System.out.println("Adding items to inventory...");
        inventory.addItem(sword);
        inventory.addItem(key);
        inventory.addItem(potion);

        // View inventory
        System.out.println("\n--- Viewing Inventory ---");
        inventory.manageInventory();

        // Test removing an item
        System.out.println("\n--- Removing key ---");
        try {
            inventory.removeItem("Key");
            System.out.println("Key removed successfully.");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // View inventory after removal
        System.out.println("\n--- Viewing Inventory After Removal ---");
        inventory.manageInventory();

        // Test accessing a non-existent item
        System.out.println("\n--- Trying to Get Non-existent Item ---");
        try {
            inventory.getItem("Key");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Test using an item
        System.out.println("\n--- Using an Item ---");
        inventory.manageInventory();
    }
}
