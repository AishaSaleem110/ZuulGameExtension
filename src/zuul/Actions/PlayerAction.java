package zuul.Actions;

import zuul.Command;
import zuul.Game;
import zuul.Players.Player;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class implements Action interface
 * It switches the current player of game to the specified player
 * Example of command invocation: player 1
 * where 1 specifies the player id of the player to be switched
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class PlayerAction implements Action{
    Game game;

    /**
     * parameter less constructor which creates an instance of PlayerAction class
     */
    public PlayerAction() {
        this.game = Game.getInstance();
    }

    /**
     *
     * @param command - object containing all three command words
     * @param currentPlayer - current player for which command needs to be executed
     * @return string message after performing the action or any error message
     */
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
