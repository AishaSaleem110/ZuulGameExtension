package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

/**
 * Try to drop an item, otherwise print an error message.
 */

public class DropAction implements Action {

    public DropAction() {
    }

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
