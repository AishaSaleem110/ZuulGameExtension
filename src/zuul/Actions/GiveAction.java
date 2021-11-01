package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class implements Action interface
 * It calls the internal give method for the current player invoking the Give command
 *Example of command invocation: give notebook kiara
 * where notebook specifies item and kiara specifies a character
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class GiveAction implements Action {
    public GiveAction() {
    }

    /**
     *  It calls the internal Give method for the current player invoking the give command
     * @param command - object containing all three command words
     * @param currentPlayer - current player for which drop command needs to be executed
     * @return String message returned from Player class after executing the Give method
     */

    @Override
    public String execute(Command command, Player currentPlayer) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to give...
            return "Give what?";

        }
        if (!command.hasThirdWord()) {
            // if there is no third word, we don't to whom to give it...
            return "Give it to who?";

        }

        String item = command.getSecondWord();
        String whom = command.getThirdWord();

        return currentPlayer.give(item, whom);
    }
}
