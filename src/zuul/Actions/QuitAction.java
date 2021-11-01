package zuul.Actions;

import zuul.Command;
import zuul.Enums.CommandWord;
import zuul.Players.Player;

/**
 * "Quit" was entered. Check the rest of the command to see whether we
 * really quit the game.
 *
 * @return true, if this command quits the game, false otherwise.
 */

public class QuitAction implements Action{
    public QuitAction() {
    }

    @Override
    public String execute(Command command, Player currentPlayer) {
        if (command.hasSecondWord()) {
            return "Quit what?";

        } else {
            return CommandWord.QUIT.name();  // signal that we want to quit
        }
    }
}
