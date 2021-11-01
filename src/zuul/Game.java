package zuul;

import zuul.Actions.Action;
import zuul.Actions.ActionInvoker;
import zuul.Actions.DropAction;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main class of the "World of Zuul" application. "World of
 * Zuul" is a very simple, text based adventure game. Users can walk around some
 * scenery. That's all. It should really be extended to make it more
 * interesting!
 * <p>
 * To play this game, create an instance of this class and call the "play"
 * method.8j
 * <p>
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {

    private final Parser parser;
    private List<Player> players;
    private Player currentPlayer;
    private static int numberOfPlayers =1;
    private static Game game = null;

    /**
     * Create the game and initialise its internal map.
     */
    private Game() {
        Room entryRoom = createRooms();
        players = new ArrayList<>();
        createPlayers(HumanPlayer.class.getName(),numberOfPlayers,entryRoom);
        Player p=players.get(0);
        setCurrentPlayer(p);
        parser = Parser.getInstance();
    }


    public static Game getInstance() {
        if (game == null) {
            game=new Game();
        }
         return game;
    }

    public static void setNumberOfPlayers(int numberOfPlayers) {
        Game.numberOfPlayers = numberOfPlayers;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Create all the rooms and link their exits together.
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
        outside.setCharacter(new Character("SecurityGuard",null));
        outside.setCharacter(new Character("Dog",null));

        theatre.setExit(Direction.WEST, outside);
        theatre.setCharacter(new Character("Usher",null));

        pub.setExit(Direction.EAST, outside);

        lab.setExit(Direction.NORTH, outside);
        lab.setExit(Direction.EAST, office);

        office.setExit(Direction.WEST, lab);


        return outside;
    }

    private void createPlayers(String player, int numberOfPlayers, Room entryRoom){
        PlayerFactory playerFactory=new PlayerFactory();
        List<Player> p=playerFactory.createPlayers(player,numberOfPlayers,entryRoom);
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

    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;
        ActionInvoker actionInvoker=new ActionInvoker(command,currentPlayer);
        String response=actionInvoker.executeAction();
        if(response.equals(CommandWord.QUIT.name())){
            wantToQuit=true;
        }
        else{
            System.out.println(response);
        }
        return wantToQuit;

    }


}
