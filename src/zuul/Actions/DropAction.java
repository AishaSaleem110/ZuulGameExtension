package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class implements Action interface
 * It calls the internal drop method for the current player invoking the Drop command
 * Example of command invocation: drop notebook
 * where notebook specifies item
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class DropAction implements Action {

    public DropAction() {
    }

    /**
     *  It calls the internal drop method for the current player invoking the Drop command
     * @param command - object containing all three command words
     * @param currentPlayer - current player for which drop command needs to be executed
     * @return String message returned from Player class after executing the Drop method
     */
    @Override
    public String execute(Command command, Player currentPlayer) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop...
            return "Drop what?";
        }
        String item = command.getSecondWord();
        return currentPlayer.drop(item);
    }
}
