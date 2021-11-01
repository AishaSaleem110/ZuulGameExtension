package zuul;

import zuul.Actions.ActionInvoker;
import zuul.Enums.CommandWord;
import zuul.Enums.Direction;
import zuul.Players.ComputerControlledPlayer;
import zuul.Players.HumanPlayer;
import zuul.Players.Player;
import zuul.Players.PlayerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main class of the "World of Zuul" application. "World of
 * Zuul" is a very simple, text based adventure game. Users can walk around some
 * scenery. That's all. It should really be extended to make it more
 * interesting!
 * <p>
 * To play this game, create an instance of this class and set number of players and call the "play"
 * method.8j
 * <p>
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * * The Game class follows Singleton Design pattern hence only one instance of Game class can be created at a given time.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.31
 *
 */
public class Game {

    private final Parser parser;
    private List<Player> players;
    private Player currentPlayer;
    private static int numberOfPlayers = 1;
    private static Game game = null;

    /**
     * initializes the Game and creates internal map by creating room and players and also set current player to the first player by default
     */
    private Game() {
        parser = Parser.getInstance();
        Room entryRoom = createRooms();
        players = new ArrayList<>();
        createPlayers(HumanPlayer.class.getName(), numberOfPlayers, entryRoom);
        setCurrentPlayer(players.get(0));
    }

    /**
     *
     * @return  instance of a Game if its already created
     * else create an instance of Game class and then return it
     */
    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    /**
     * Sets the numbers of players that are required in the game
     * @param numberOfPlayers -int number of players required in game
     */
    public static void setNumberOfPlayers(int numberOfPlayers) {
        Game.numberOfPlayers = numberOfPlayers;
    }

    /**
     * Getter method for current player in the game
     * @return current player of the game
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Setter method to set the current player of the game
     * @param currentPlayer id which needs to be set as the current player in the game
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * returns list of all current players in the game
     * @return List of Players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Setter method to set a list of players in the game
     * @param players -list of players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Create all the rooms and link their exits together, create items and characters in the room
     * @return Room object which should be the entry room for all players
     */
    private Room createRooms() {
        Room outside, theatre, pub, lab, office;
        // create the rooms
        outside = new Room("You are outside the main entrance of the university");
        theatre = new Room("You are in a lecture theatre");
        pub = new Room("You are in the campus pub");
        lab = new Room("You are in a computing lab");
        office = new Room("You are in the computing admin office");

        // initialise room exits

        outside.setExit(Direction.EAST, theatre);
        outside.setExit(Direction.SOUTH, lab);
        outside.setExit(Direction.WEST, pub);
        outside.addItem("notebook", 2);
        outside.addItem("ball", 2);
        outside.setCharacter(new Character("SecurityGuard", null));
        outside.setCharacter(new Character("Dog", null));

        theatre.setExit(Direction.WEST, outside);
        theatre.setCharacter(new Character("Usher", null));

        pub.setExit(Direction.EAST, outside);

        lab.setExit(Direction.NORTH, outside);
        lab.setExit(Direction.EAST, office);

        office.setExit(Direction.WEST, lab);

        return outside;
    }

    /**
     * Initializes a factory pattern to create players in the game
     * @param player -name of the class whose players should be created
     * @param numberOfPlayers- number of players in the game
     * @param entryRoom - entry /spawning room for all players
     */
    private void createPlayers(String player, int numberOfPlayers, Room entryRoom) {
        PlayerFactory playerFactory = new PlayerFactory();
        List<Player> p = playerFactory.createPlayers(player, numberOfPlayers, entryRoom);
        setPlayers(p);
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();

            finished = processCommand(command);

        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(getCurrentPlayer().getPlayerLocationInfo());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
        ActionInvoker actionInvoker = new ActionInvoker(command, currentPlayer);
        String response = actionInvoker.executeAction();
        if (response != null && response.equals(CommandWord.QUIT.name())) {
            wantToQuit = true;
        } else {
            System.out.println(response);
        }
        return wantToQuit;

    }


}
