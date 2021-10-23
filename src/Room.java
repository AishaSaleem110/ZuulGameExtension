/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    public String description;

    // Exits from the room
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    // An item in the room
    private String itemDescription;

     private int itemWeight;

    // Characters in the room
    private String character;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    /**
     * Items are returned
     * @return
     */
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * @param direction
     * @return
     */

    public Room getExits(String direction){
        if(direction.equals("north")){
            return northExit;
        }
        else if(direction.equals("east")){
            return eastExit;
        }
        else if(direction.equals("south")){
            return southExit;
        }
        else if(direction.equals("west")){
            return westExit;
        }else{
            return null;
        }
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Add an item to the Room
     * @param description The description of the item
     * @param weight The item's weight
     */
    public void addItem(String description, int weight) {
        itemDescription = description;
        itemWeight = weight;               
    }
    
    /**
     * Does the room contain an item
     * @param description the item
     * @ return the item's weight or 0 if none
     */
    public int containsItem(String description) {
        if (itemDescription.equals(description)) 
            return itemWeight;
        else return 0;
    }
    
    /**
     * Remove an item from the Room
     */
    public String removeItem(String description) {
        if (itemDescription.equals(description)) {
            String tmp = itemDescription;
            itemDescription = null;
            return tmp;
        }
        else {
            System.out.println("This room does not contain" + description);
            return null;
        }
    }
    
}
