package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

public interface Action {

    public String execute(Command command, Player currentPlayer);
}
