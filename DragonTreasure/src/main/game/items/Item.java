package main.game.items;
public abstract class Item {
    /**
     * Holds the items name
     */
    private String name;

    /**
     * Holds the description of the item
     */
    private String description;

    /**
     * Holds information of if item can be used or not.
     * Key and Treasure for example is not usable.
     */
    private boolean usable;
    /**
     * holds non obligatory (not part of constructor argument) 
     * ascii art related to the object.
     */
    private String asciiArt = "";

    /**
     * prompt for what the player sees in the world when encountering the item.
     */
    private String  itemPrompt;

    private String pickedUpItemPrompt;

    /**
     * Constructor, protected since should only be able to be used via inheritance.
     * @param String name of the item
     * @param String description of the item
     * @param boolean if item is usable or not.
     * @param String prompt for what the player sees when encountering the item.
     */
    protected Item(String name, String description, boolean usable, String itemPrompt, String pickedUpItemPrompt){
        this.name = name;
        this.description = description;
        this.usable = usable;
        this.itemPrompt = itemPrompt;
        this.pickedUpItemPrompt = pickedUpItemPrompt;
    }

    /**
     * Sets the name of the item
     * @param String of the new name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Gets the name of the item
     * @return String of the items name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Sets the description of the item
     * @param String of the new description
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Gets the description of the item
     * @return String of the items description
     */
    public String getDescription(){
        return this.description;
    }
   
    /**
     * Sets the ascii art of the item
     * @param String of ascii art
     */
    public void setAsciiArt(String asciiArt){
        this.asciiArt = asciiArt;
    }

    /**
     * Gets the ascii art of the item
     * @return String of the ascii art for the object.
     * if there are none, it will return null.
     */
    public String getAsciiArt(){
        return this.asciiArt;
    }

    public boolean getUsable(){
        return this.usable;
    }

    public void setUsable(boolean usable){
        this.usable = usable;
    }

    public String getitemPrompt(){
        return this.itemPrompt;
    }

    public void setitemPrompt(String itemPrompt){
        this.itemPrompt = itemPrompt;
    }

    public String getPickedUpItemPrompt() {
        return this.pickedUpItemPrompt;
    }

    public void setPickedUpItemPrompt(String pickedUpItemPrompt) {
        this.pickedUpItemPrompt = pickedUpItemPrompt;
    }
}