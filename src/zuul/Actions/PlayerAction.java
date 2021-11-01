package zuul.Actions;

import zuul.Command;
import zuul.Game;
import zuul.Players.Player;

public class PlayerAction implements Action{
    Game game;

    public PlayerAction() {
        this.game = Game.getInstance();
    }

    @Override
    public String execute(Command command, Player currentPlayer) {
        if (!command.hasSecondWord()) {
           return "switch to?";
        }

        int playerToSwitch=Integer.parseInt(command.getSecondWord());
        if((playerToSwitch>=game.getPlayers().size())){
            return "Player requested is not in the game.";

        }
        game.setCurrentPlayer(game.getPlayers().get(playerToSwitch));
        return game.getCurrentPlayer().getPlayerLocationInfo();

    }
}
