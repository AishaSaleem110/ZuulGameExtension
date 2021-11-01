package zuul.Actions;

import zuul.Command;
import zuul.Enums.CommandWord;
import zuul.Players.Player;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class implements Action interface
 * It is used to quit the game
 * Example of command invocation: quit
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class QuitAction implements Action {

    /**
     * parameter less constructor which creates an instance of QuitAction class
     */
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
