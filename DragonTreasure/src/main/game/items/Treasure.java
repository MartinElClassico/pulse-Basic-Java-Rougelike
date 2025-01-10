package main.game.items;
/** 
* This class represents a Treasure, which is an item in the game
* It holds the amount of gold the treasure is worth
* 
* @author annemm-3, tulmar-2, evekho-4
*/
public class Treasure extends Item {
    private static final String TREASURE_PICKED_UP_PROMPT = "Du tog upp skatten.";
    /**
     * Holds the gold value of the treasure
     */
    private int goldValue;

    /**
     * Constructor
     * @param name name of the treasure
     * @param description decription of the treasure
     * @param itemPrompt the prompt for when encountering the item.
     * @param goldValue gold value of the treasure
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