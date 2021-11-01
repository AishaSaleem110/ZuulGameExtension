package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

/**
 * Try to take an item from the current room, otherwise print an error
 * message.
 */

public class TakeAction implements Action{
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
