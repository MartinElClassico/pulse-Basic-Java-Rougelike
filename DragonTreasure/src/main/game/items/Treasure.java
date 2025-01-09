package main.game.items;
public class Treasure extends Item {
    private static final String TREASURE_PICKED_UP_PROMPT = "Du tog upp skatten.";
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
    public Treasure (String name, String description, String itemPrompt, int goldValue){
        super(name, description, false, itemPrompt, TREASURE_PICKED_UP_PROMPT);
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