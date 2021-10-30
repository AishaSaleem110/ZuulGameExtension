package zuul.Actions;

import zuul.Command;
import zuul.Player;

public class GiveAction implements Action{
    public GiveAction() {
    }

    @Override
    public String  execute(Command command, Player currentPlayer) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to give...
            return "Give what?";

        }
        if (!command.hasThirdWord()) {
            // if there is no third word, we don't to whom to give it...
            return "Give it to who?";

        }

        String item = command.getSecondWord();
        String whom = command.getThirdWord();

        return currentPlayer.give(item, whom);
    }
}
