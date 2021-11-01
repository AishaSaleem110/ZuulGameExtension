package zuul.Players;

import zuul.Enums.Direction;
import zuul.Item;
import zuul.Room;
import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This HumanPlayer class represents an implementation of abstract Player class that can be used in the game as player
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class HumanPlayer extends Player {

    private HashMap<String, Integer> items;
    private int totalWeight;
    private final int MAX_WEIGHT = 10;

    /**
     * @param currentRoom - Every player must have a current room
     * @param id - int id of a Player to identify the player
     */
    public HumanPlayer(Room currentRoom, int id) {
        super(currentRoom, id);
        this.items = new HashMap<>();
        this.totalWeight = 0;
        this.currentRoom = currentRoom;
    }

    /**
     * Parameter less constructor that creates an instance of a HumanPlayer
     */
    public HumanPlayer() {
        super();
        this.items = new HashMap<>();
        this.totalWeight = 0;
    }

    /**
     *
     * @param item - String description of the item to be searched
     * @return true if item found else returns false
     */
    private boolean checkPlayerHasItem(String item) {
        return items.containsKey(item);
    }

    /**
     *
     * @param newItemWeight- int weight of the new item to be picked
     * @return true if player is allowed to take new item according to its maximum weight requirements
     */
    private boolean checkAllowedWeight(int newItemWeight) {
        return (this.totalWeight + newItemWeight >= this.MAX_WEIGHT);
    }

    /**
     * @param direction - exit direction where player needs to move if there is an exit, enter the new room
     * @return a string message specifying if player moved successfully otherwise return an error message
     */
    @Override
    public String move(Direction direction) {
        // Try to leave current room.
        Room nextRoom = getCurrentRoom().getExits(direction);


        if (nextRoom == null) {
            return "There is no door!";
        } else {
            setCurrentRoom(nextRoom);
            return getPlayerLocationInfo();
        }
    }

    /**
     * @return as String literal what the player can see in the room
     */
    @Override
    public String look() {
        return getPlayerLocationInfo();
    }


    /**
     * @param itemDesc - description of an item to take from the current room
     * @return as String if operation successful else return error
     */
    @Override
    public String take(String itemDesc) {
        int w = getCurrentRoom().containsItem(itemDesc);
        if (w == 0) {
            // The item is not in the room
            return "Item is not in the room.";
        }

        if (checkAllowedWeight(w)) {
            // The player is carrying too much
            return "Item is too heavy";

        } else {
            items.put(itemDesc, w);
            totalWeight += w;
            currentRoom.removeItem(itemDesc);
            return "Item has been picked up.";
        }
    }

    /**
     * @param itemDesc -item that a player wants to drop
     * @return as String if action successful else return error message
     */
    @Override
    public String drop(String itemDesc) {
        if (!checkPlayerHasItem(itemDesc)) {
            return "You don't have this item.";
        } else {

            totalWeight -= items.get(itemDesc);
            getCurrentRoom().addItem(itemDesc, items.get(itemDesc));
            items.remove(itemDesc);

            return "Item has been dropped.";
        }
    }

    /**
     * @param itemDesc- String description of item to give to a character
     * @param whom      - String name of the character who should be given the specified item
     * @return - if operation successful else return error message
     */
    @Override
    public String give(String itemDesc, String whom) {
        if (getCurrentRoom().getCharacter(whom) == null) {
            return "This character is not in the room.";
        }

        if (!checkPlayerHasItem(itemDesc)) {

            return "You don't have this item.";
        } else {
            int w = this.items.get(itemDesc);
            totalWeight -= w;
            getCurrentRoom().getCharacter(whom).addItem(new Item(itemDesc, w));
            items.remove(itemDesc);

            return "Item has been given to the requested character.";
        }
    }

}
