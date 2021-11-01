package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class implements Action interface
 * It calls the internal look method for the current player invoking the look command
 * Example of command invocation: look
 * @author Aisha Saleem
 * @version 2021.10.25
 */
public class LookAction implements Action {
    public LookAction() {
    }

    /**
     *  It calls the internal look method for the current player invoking the look command
     * @param command - object containing all three command words
     * @param currentPlayer - current player for which go command needs to be executed
     * @return String returned from Player class after executing the look method
     */
    @Override
    public String execute(Command command, Player currentPlayer) {
        return currentPlayer.look();
    }
}
