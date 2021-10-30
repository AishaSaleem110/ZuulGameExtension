package zuul.Actions;

import zuul.Command;
import zuul.Direction;
import zuul.Player;
/**
 * Try to go to one direction. If there is an exit, enter the new room,
 * otherwise print an error message.
 */
public class GoAction implements Action{

    public GoAction() {
    }

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
