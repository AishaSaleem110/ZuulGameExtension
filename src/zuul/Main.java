package zuul;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rej
 */
public class Main {

    /**
     * @param args the command line arguments
     * Sets the number of player required in the Game
     * Creates an instance of the Game
     * Starts playing game
     */
    public static void main(String[] args) {

        Game.setNumberOfPlayers(5);
        Game game=Game.getInstance();
        game.play();
    }
}
