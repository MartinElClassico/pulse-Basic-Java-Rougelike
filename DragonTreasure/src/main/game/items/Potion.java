package main.game.items;
public class Potion extends Item {
    /**
     * Holds the amount of hp the potion heals
     */
    private int healing;
  
    /**
     * Constructor
     * @param String name of the potion
     * @param String decription of the potion
     * @param int number of hp the potion heals
     */
    public Potion (String name, String description, int healing){
        super(name, description);
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