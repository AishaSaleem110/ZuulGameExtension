package zuul.Players;

import zuul.Enums.Direction;
import zuul.Room;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This ComputerControlledPlayer class represents an implementation of abstract Player class that can be used in the game as player
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class ComputerControlledPlayer extends Player {
    /**
     * Parameter less constructor that creates an instance of a ComputerControlledPlayer
     */
    ComputerControlledPlayer() {
        super();
    }

    /**
     * @param currentRoom - Every player must have a current room
     * @param playerId    - int id of a Player to identify the player
     */
    public ComputerControlledPlayer(Room currentRoom, int playerId) {
        super(currentRoom, playerId);
    }

    /**
     * @param direction - exit direction where player needs to move if there is an exit, enter the new room
     * @return a string message specifying if player moved successfully otherwise return an error message
     */
    @Override
    public String move(Direction direction) {
        return null;
    }

    /**
     * @return as String literal what the player can see in the room
     */
    @Override
    public String look() {
        return null;
    }

    /**
     * @param itemDesc - description of an item to take from the current room
     * @return as String if operation successful else return error
     */
    @Override
    public String take(String itemDesc) {
        return null;
    }

    /**
     * @param itemDesc -item that a player wants to drop
     * @return as String if action successful else return error message
     */
    @Override
    public String drop(String itemDesc) {
        return null;
    }

    /**
     * @param itemDesc- String description of item to give to a character
     * @param whom      - String name of the character who should be given the specified item
     * @return - if operation successful else return error message
     */
    @Override
    public String give(String itemDesc, String whom) {
        return null;
    }


}
