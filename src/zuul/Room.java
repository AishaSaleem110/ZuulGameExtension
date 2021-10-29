package zuul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Class zuul.Room - a room in an adventure game.
 * <p>
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * A "zuul.Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room {
    public String description;
    private HashMap<Direction, Room> exits;

    // Characters in the room
    private ArrayList<Character> characters;

    private ArrayList<Item> items;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.characters = new ArrayList<>();
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     *
     * @param direction specifies the direction .
     * @param neighbor  specifies the neighboring room
     **/
    public void setExit(Direction direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Character getCharacter(String description) {
        for (Character character : this.characters){
            if(character.getName().equals(description)){
                return character;
            }
        }
        return null;

    }

    public void setCharacter(Character character) {
        this.characters.add(character);
    }

    public Room getExits(Direction direction) {
        return exits.get(direction);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Add an item to the Room
     *
     * @param description The description of the item
     * @param weight      The item's weight
     */
    public void addItem(String description, int weight) {
        this.items.add(new Item(description, weight));

    }

    /**
     * Does the room contain an item
     *
     * @param description the item
     * @ return the item's weight or 0 if none
     */
    public int containsItem(String description) {

        for(Item item: this.items){
            if(item.getDescription().equals(description)){
                return item.getWeight();
            }
        }
        return 0;
    }

    /**
     * Remove an item from the Room
     */
    public String removeItem(String description) {
        Iterator<Item> iterator = this.items.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getDescription().equals(description)){
                iterator.remove();
                return description;
            }
        }
        return "This room does not contain" + description;
    }


    /**
     * returns all exits of the room in a string
     */
    public String getRoomExitDetails() {
        StringBuilder roomDetails = new StringBuilder("Exits: ");
        Set<Direction> roomExitDirections = exits.keySet();
        for (Direction roomExits : roomExitDirections) {
            roomDetails.append(roomExits.toString()).append(" ");
        }
        return roomDetails.toString();
    }

    /**
     * if room contains items then this method returns all details in a string
     **/
    public String getRoomItemDetails() {
        StringBuilder roomItemDetails = new StringBuilder();
        for(Item item : this.items){
            roomItemDetails.append(item.toString()).append(" ");
        }

        return roomItemDetails.toString();
    }
    public String getRoomCharacterDetails(){
        StringBuilder roomCharacterDetails = new StringBuilder();
        for(Character character : this.characters){
            roomCharacterDetails.append(character.toString()).append(" ");
        }

        return roomCharacterDetails.toString();
    }

    @Override
    public String toString() {
        StringBuilder detailedDescription = new StringBuilder();

        detailedDescription.append("You are ")
                .append(getDescription()).append(System.lineSeparator())
                .append(getRoomExitDetails()).append(System.lineSeparator())
                .append("Items: ").append(getRoomItemDetails()).append(System.lineSeparator())
                .append("Characters: ").append(getRoomCharacterDetails());


        return detailedDescription.toString();
    }

}
