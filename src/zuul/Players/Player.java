package zuul.Players;

import zuul.Enums.Direction;
import zuul.Room;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class represents an abstract Player within the Game class
 * This class enforces a structure and functionality that every player class should have
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public abstract class Player {
    Room currentRoom;
    int playerId;

    /**
     * Parameter less constructor of Player class that creates an instance of a Player
     */
    public Player() {
        this.currentRoom = null;
    }

    /**
     * @param currentRoom - Every player must have a current room
     * @param playerId    - int id of a Player to identify the player
     */
    public Player(Room currentRoom, int playerId) {
        this.currentRoom = currentRoom;
        this.playerId = playerId;
    }

    /**
     * @return int player id
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * @param playerId -sets int player id
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    /**
     * @return current Room of the player
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * @param currentRoom -sets specified room as current room of the player
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * @return all details of player id, all exits, items and characters of the current room of the player as a string literal
     */
    public String getPlayerLocationInfo() {

        StringBuilder locationString = new StringBuilder();
        return locationString.append("Player")
                .append(getPlayerId())
                .append(System.lineSeparator())
                .append(getCurrentRoom().toString()).toString();
    }

    /**
     * @param direction - exit direction where player needs to move if there is an exit, enter the new room
     * @return a string message specifying if player moved successfully otherwise return an error message
     */
    abstract public String move(Direction direction);

    /**
     * @return as String literal what the player can see in the room
     */
    abstract public String look();

    /**
     * @param itemDesc - description of an item to take from the current room
     * @return as String if operation successful else return error
     */
    abstract public String take(String itemDesc);

    /**
     * @param itemDesc -item that a player wants to drop
     * @return as String if action successful else return error message
     */
    abstract public String drop(String itemDesc);

    /**
     * @param itemDesc- String description of item to give to a character
     * @param whom      - String name of the character who should be given the specified item
     * @return - if operation successful else return error message
     */
    abstract public String give(String itemDesc, String whom);


}
