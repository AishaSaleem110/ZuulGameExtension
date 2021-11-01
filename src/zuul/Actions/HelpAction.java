package zuul.Actions;

import zuul.Command;
import zuul.Parser;
import zuul.Players.Player;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class implements Action interface
 * It returns some help information. Here we print some stupid, cryptic
 *  message and a list of the command words
 * Example of command invocation: help
 * @author Aisha Saleem
 * @version 2021.10.25
 */

/**
 * Print out some help information. Here we print some stupid, cryptic
 * message and a list of the command words.
 */

public class HelpAction implements Action {
    Parser parser;

    public HelpAction() {
        this.parser = Parser.getInstance();
    }

    /**
     *
     * @param command - object containing all three command words
     * @param currentPlayer - current player for which command needs to be executed
     * @return as string some help information. Here we print some stupid, cryptic
     * message and a list of the command words
     */
    @Override
    public String execute(Command command, Player currentPlayer) {
        StringBuilder helpString = new StringBuilder();
        helpString.append("You are lost. You are alone. You wander").append(System.lineSeparator()).append("around at the university.")
                .append(System.lineSeparator()).append("Your command words are:")
                .append(parser.showAllCommands());
        return helpString.toString();
    }
}
