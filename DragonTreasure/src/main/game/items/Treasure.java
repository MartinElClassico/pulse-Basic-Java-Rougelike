package main.game.items;
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
    public Treasure (String name, String description, int goldValue){
        super(name, description, false);
        this.goldValue = goldValue;
    }

    /**
     * Sets the gold value of the treasure
     * @param int new golvd value
     */
    public void setGoldValue(int goldValue){
        this.goldValue = goldValue;
    }

    /**
     * Gets the gold value of the treasure
     * @return int gold value
     */
    public int getGoldValue(){
        return this.goldValue;
    }
}