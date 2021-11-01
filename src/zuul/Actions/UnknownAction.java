package zuul.Actions;

import zuul.Command;
import zuul.Players.Player;

public class UnknownAction implements Action{
    public UnknownAction() {
    }

    @Override
    public String execute(Command command, Player currentPlayer) {
        return "I don't know what you mean...";
    }
}
