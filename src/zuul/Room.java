package zuul;

import zuul.Enums.Direction;

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
 * connected to other rooms via exits.  The exits are stored with each Room as a key value pair.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room {
    private String description;
    private HashMap<Direction, Room> exits;
    private ArrayList<Character> characters;
    private ArrayList<Item> items;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * Initializes items and characters are empty for any room
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
     * @param direction specifies the direction as Direction Enum.
     * @param neighbor  specifies the neighboring room
     **/
    public void setExit(Direction direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     *
     * @param direction - exit direction of the Room
     * @return Room present in the requested exit of the current Room
     */
    public Room getExits(Direction direction) {
        return exits.get(direction);
    }

    /**
     *
     * @param description -string description of the character
     * @return the character with the specified description if it is present in the room else returns null
     */
    public Character getCharacter(String description) {
        for (Character character : this.characters) {
            if (character.getName().equals(description)) {
                return character;
            }
        }
        return null;

    }

    /**
     *
     * @param character -sets a charcter in a Room
     */
    public void setCharacter(Character character) {
        this.characters.add(character);
    }


    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description-sets String description of a Room
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Add an item to the Room
     *
     * @param description- The String description of the item
     * @param weight - The item's int weight
     */
    public void addItem(String description, int weight) {
        this.items.add(new Item(description, weight));

    }

    /**
     * Checks if Room contains an item with the given description
     *
     * @param description the item to be checked within room
     * @return the item's weight if found in room or 0 if none
     */
    public int containsItem(String description) {

        for (Item item : this.items) {
            if (item.getDescription().equals(description)) {
                return item.getWeight();
            }
        }
        return 0;
    }

    /**
     *
     * @param description- Remove an item with the specified description from the Room
     * @return the decription of the item being removed or a message specifying item is not found
     */
    public String removeItem(String description) {
        Iterator<Item> iterator = this.items.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getDescription().equals(description)) {
                iterator.remove();
                return description;
            }
        }
        return "This room does not contain this item.";
    }


    /**
     *
     * @return all exits of the room in a string
     */
    private String getRoomExitDetails() {
        StringBuilder roomDetails = new StringBuilder("Exits: ");
        Set<Direction> roomExitDirections = exits.keySet();
        for (Direction roomExits : roomExitDirections) {
            roomDetails.append(roomExits.toString()).append(" ");
        }
        return roomDetails.toString();
    }

    /**
     *
     * @return all items details in the room in a string
     */
    private String getRoomItemDetails() {
        StringBuilder roomItemDetails = new StringBuilder();
        for (Item item : this.items) {
            roomItemDetails.append(item.toString()).append(" ");
        }

        return roomItemDetails.toString();
    }

    /**
     *
     * @return all characters of the room in a string
     */
    private String getRoomCharacterDetails() {
        StringBuilder roomCharacterDetails = new StringBuilder();
        for (Character character : this.characters) {
            roomCharacterDetails.append(character.toString()).append(" ");
        }

        return roomCharacterDetails.toString();
    }

    /**
     * Overriding toString method
     * @return the details of all exits, items and characters of the room in a string literal
     */
    @Override
    public String toString() {
        StringBuilder detailedDescription = new StringBuilder();

        detailedDescription
                .append(getDescription()).append(System.lineSeparator())
                .append(getRoomExitDetails()).append(System.lineSeparator())
                .append("Items: ").append(getRoomItemDetails()).append(System.lineSeparator())
                .append("Characters: ").append(getRoomCharacterDetails());


        return detailedDescription.toString();
    }

}
