public class Weapon extends Item {
    /**
     * Holds the amount of damage increase the weapon gives
     */
    private int increaseDamage;

    /**
     * Constructor
     * @param String name of the weapon
     * @param String decription of the weapon
     * @param int amount of damage increase the weapon gives
     */
    public Key (String name, String description, int increaseDamage){
        super.name = name;
        super.description = description;
        this.increaseDamage = increaseDamage;
    }
}