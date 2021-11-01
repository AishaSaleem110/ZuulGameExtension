package zuul.Actions;

import zuul.Command;
import zuul.Enums.Direction;
import zuul.Players.Player;


/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class implements Action interface
 * It calls the internal move method for the current player invoking the go command
 * Example of command invocation: go east
 *  * where east specifies a direction/exit of a Room
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class GoAction implements Action {

    public GoAction() {
    }

    /**
     *  It calls the internal Give method for the current player invoking the give command
     * @param command - object containing all three command words
     * @param currentPlayer - current player for which go command needs to be executed
     * @return String message returned from Player class after executing the move method
     */
    @Override
    public String execute(Command command, Player currentPlayer) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Go where?";

        }
        String directionString = command.getSecondWord();

        Direction direction = Direction.getDirectionEnum(directionString);
        if (direction.equals(Direction.UNKNOWN)) {
            return "That is not a direction...";

        }
        return currentPlayer.move(direction);

    }
}
