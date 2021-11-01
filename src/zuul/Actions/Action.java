package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

/**
 * This interface is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This interface should be implemented by every command within the game application
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */
public interface Action {

    /**
     *
     * @param command - object containing all three command words
     * @param currentPlayer - current player for which command needs to be executed
     * @return String message after command execution
     */
    public String execute(Command command, Player currentPlayer);
}
