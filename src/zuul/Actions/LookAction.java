package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

/**
 * "Look" was entered. Report what the player can see in the room
 */
public class LookAction implements Action{
    public LookAction() {
    }

    @Override
    public String execute(Command command, Player currentPlayer)
    {
        return currentPlayer.look();
    }
}
