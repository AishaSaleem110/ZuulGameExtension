package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class implements Action interface
 * It handles if any unknown command is entered in the game
 * This class is only used for internal handling of unknown commands
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class UnknownAction implements Action{
    /**
     * parameter less constructor which creates an instance of UnknownAction class
     */
    public UnknownAction() {
    }

    @Override
    public String execute(Command command, Player currentPlayer) {
        return "I don't know what you mean...";
    }
}
