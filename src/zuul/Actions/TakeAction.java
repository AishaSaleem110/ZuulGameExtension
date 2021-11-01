package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class implements Action interface
 * It calls the internal take method for the current player invoking the take command
 *Example of command invocation: take notebook
 * where notebook specifies item
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class TakeAction implements Action {
    public TakeAction() {
    }

    @Override
    public String execute(Command command, Player currentPlayer) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take...
            return "Take what?";
        }

        String item = command.getSecondWord();
        return currentPlayer.take(item);
    }
}
