package main.game.items;
/** 
* This class represents a Potion, which is an item in the game
* It holds the amount of healing the potion gives
* 
* @author annemm-3, tulmar-2, evekho-4
*/
public class Potion extends Item {
    private static final String POTION_PICKED_UP_PROMPT = "Du tog upp hälsodrycken.";
    /**
     * Holds the amount of hp the potion heals
     */
    private int healing;
  
    /**
     * Constructor
     * @param name name of the potion
     * @param description decription of the potion
     * @param itemPrompt prompt when encountering item in the world.
     * @param healing number of hp the potion heals
     */
    public Potion (String name, String description, String itemPrompt, int healing){
        super(name, description, true, itemPrompt, POTION_PICKED_UP_PROMPT);
        this.healing = healing;
    }

    /**
     * Sets the amount of healing the potion does
     * @param int new amount of healing
     */
    public void setHealing(int healing){
        this.healing = healing;
    }

    /**
     * Gets the amount of healing the potion does
     * @return int amount of healing
     */
    public int getHealing(){
        return this.healing;
    }
}