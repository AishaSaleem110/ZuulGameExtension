import java.util.HashMap;
import java.util.Set;

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

/*    // Exits from the room
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
*/

    private HashMap<String,Room> exits;
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
        this.exits=new HashMap<>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direction specifies the direction .
     * @param neighbor specifies the neighboring room
     **/
    public void setExit(String direction,Room neighbor)
    {
       exits.put(direction,neighbor);
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
       return exits.get(direction);
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

    /**
     *
     * returns all exits of the room in a string
     */
    public String getRoomExitDetails(){
        StringBuilder roomDetails=new StringBuilder("Exits: ");
        Set<String> roomExitDirections=exits.keySet();
        for(String roomExits:roomExitDirections){
            roomDetails.append(roomExits).append(" ");
        }
        return roomDetails.toString();
    }

    /**
     *
     * returns all details of a room including its all exits in all directions and items and weights of those items
     */
    public String getDetailedDescription(){
        StringBuilder detailedDescription=new StringBuilder();

        detailedDescription.append("You are ").append(getDescription()).append("\n").append(getRoomExitDetails()).append("\n")
                .append("Items: ");

        if (getItemDescription() != null) {
            detailedDescription.append(getItemDescription()).append('(').append(getItemWeight()).append(')');
        }
       return detailedDescription.toString();
    }
    
}
