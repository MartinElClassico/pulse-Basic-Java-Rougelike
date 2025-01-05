package tests.main.game.entities;

import main.game.entities.Player;
import main.game.entities.Inventory;
import main.game.items.*;
import main.game.entities.HealthListener;

public class PlayerTest {

    public static void main(String[] args) {
        System.out.println("--- Testing Player Class ---");

        // Test 1: Player Initialization
        System.out.println("Test 1: Initializing Player...");
        Player player = new Player("Hero", 100);
        System.out.println("Player Name: " + player.getName());
        System.out.println("Player Max HP: " + player.getMaxHp());
        System.out.println("Player Current HP: " + player.getHp());
        System.out.println("Player Attack Damage: " + player.getAttackDamage());
        assert player.getName().equals("Hero");
        assert player.getMaxHp() == 100;
        assert player.getHp() == 100;
        assert player.getAttackDamage() == 1;

        // Test 2: Taking Damage
        System.out.println("\nTest 2: Taking Damage...");
        int remainingHp = player.takeDamage(30);
        System.out.println("Player HP after taking 30 damage: " + remainingHp);
        assert remainingHp == 70;

        // Test 3: Healing
        System.out.println("\nTest 3: Healing...");
        int healedHp = player.heal(20);
        System.out.println("Player HP after healing 20: " + healedHp);
        assert healedHp == 90;

        // Test 4: Overhealing
        System.out.println("\nTest 4: Overhealing...");
        int overhealedHp = player.heal(50);
        System.out.println("Player HP after overhealing: " + overhealedHp);
        assert overhealedHp == 100;

        // Test 5: Health Depletion Listener
        System.out.println("\nTest 5: Health Depletion Listener...");
        player.addHealthListener(() -> System.out.println("Health depleted! Player is dead."));
        player.takeDamage(100); // Trigger listener
        assert player.getHp() <= 0;

        // Test 6: Inventory Management
        System.out.println("\nTest 6: Inventory Management...");
        Inventory inventory = player.getInventory();
        Item potion = new Potion("Health Potion", "Restores 50 HP.", 50);
        potion.setAsciiArt("ASCII ART PLACEHOLDER");
        Item weapon = new Weapon("Sword", "Increases attack damage.", 10);
        weapon.setAsciiArt("ASCII ART PLACEHOLDER");
        Item treasure = new Treasure("Treasure", "A treasure filled with gold!", 100000);
        treasure.setAsciiArt("ASCII ART PLACEHOLDER");
        inventory.addItem(potion);
        inventory.addItem(weapon);
        inventory.addItem(treasure);

        System.out.println("Inventory contains:");
        inventory.manageInventory(); // View items in inventory

        // Use items in inventory
        System.out.println("\nUsing items in inventory...");
        System.out.println("\nUSE POTION TO PASS TEST!");
        player.accessInventory(); // Use potion
        assert player.getHp() == 100; // Should be fully healed
        System.out.println("\nUSE WEAPON TO PASS TEST!");
        player.accessInventory(); // Use weapon
        assert player.getAttackDamage() == 11; // Should increase attack damage by 10

        // Test 7: Modifying Attack Damage
        System.out.println("\nTest 7: Modifying Attack Damage...");
        player.setAttackDamage(5);
        System.out.println("Player Attack Damage set to: " + player.getAttackDamage());
        assert player.getAttackDamage() == 5;

        player.incrementAttackDamage(3);
        System.out.println("Player Attack Damage after incrementing by 3: " + player.getAttackDamage());
        assert player.getAttackDamage() == 8;

        System.out.println("\nAll tests passed!");
    }
}
