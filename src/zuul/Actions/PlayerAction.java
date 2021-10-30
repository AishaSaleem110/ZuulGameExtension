package zuul.Actions;

import zuul.Command;
import zuul.Game;
import zuul.HumanPlayer;
import zuul.Player;

public class PlayerAction implements Action{
    Game game;

    public PlayerAction() {
        this.game = new Game();
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
        return currentPlayer.getPlayerLocationInfo();

    }
}
