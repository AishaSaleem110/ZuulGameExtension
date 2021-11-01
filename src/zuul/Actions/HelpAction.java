package zuul.Actions;

import zuul.Command;
import zuul.Parser;
import zuul.Player;

/**
 * Print out some help information. Here we print some stupid, cryptic
 * message and a list of the command words.
 */

public class HelpAction implements Action{
    Parser parser;

    public HelpAction() {
        this.parser = Parser.getInstance();
    }

    @Override
    public String execute(Command command, Player currentPlayer) {
        StringBuilder helpString=new StringBuilder();
        helpString.append("You are lost. You are alone. You wander \n around at the university. \n \n Your command words are:")
                         .append(parser.showAllCommands());
        return helpString.toString();
    }
}
