public class Treasure extends Item {
    /**
     * Holds the gold value of the treasure
     */
    private int goldValue;

    /**
     * Constructor
     * @param String name of the treasure
     * @param String decription of the treasure
     * @param int gold value of the treasure
     */
    public Key (String name, String description, int goldValue){
        super.name = name;
        super.description = description;
        this.goldValue = goldValue;
    }
}