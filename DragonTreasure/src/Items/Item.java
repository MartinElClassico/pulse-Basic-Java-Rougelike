package Items;
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
     * Constructor
     * @param String name of the item
     * @param String description of the item
     */
    public Item(String name, String description){
        this.name = name;
        this.description = description;
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
}