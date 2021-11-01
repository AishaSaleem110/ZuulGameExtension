package zuul.Actions;

import zuul.Command;
import zuul.Enums.CommandWord;
import zuul.Players.Player;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class represents an implementation of Command design pattern to invoke commands within the game application
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class ActionInvoker {
    Action action;
    Command command;
    Player currentPlayer;

    /**
     *
     * @param command- command object containing details of command
     * @param currentPlayer- current player invoking command
     */
    public ActionInvoker(Command command, Player currentPlayer) {
        this.command = command;
        this.currentPlayer = currentPlayer;
    }

    /**
     * It internally calls the execute method of the action object which in turn executes the command
     * @return string returned from execute command
     */
    public String executeAction() {
        CommandWord commandWord = command.getCommandWord();
        try {

            Class c = Class.forName(this.getClass().getPackage().getName() + "." + convertToTitleCase(commandWord.name()) + "Action");
            action = (Action) c.getDeclaredConstructor().newInstance();
            return action.execute(command, currentPlayer);

        } catch (Exception e) {
            UnknownAction unknownAction = new UnknownAction();
            return unknownAction.execute(null, null);

        }
    }

    private static String convertToTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }
}
