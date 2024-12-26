package main.game.entities; 

import java.util.ArrayList;
import java.util.List;

import main.game.items.Item;

public class Inventory {
    /**
     * holds the items the player has picked up.
     */
    private List<Item> items;

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


    





}
