
import java.util.ArrayList;

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
    private final Player player;


    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        Room entryRoom = createRooms();
        player = new Player(entryRoom);
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private Room createRooms() {
        Room outside, theatre, pub, lab, office;
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // initialise room exits

        outside.setExit(Direction.NORTH, null);
        outside.setExit(Direction.EAST, theatre);
        outside.setExit(Direction.SOUTH, lab);
        outside.setExit(Direction.WEST, pub);
        outside.addItem("notebook", 2);

        theatre.setExit(Direction.NORTH, null);
        theatre.setExit(Direction.EAST, null);
        theatre.setExit(Direction.SOUTH, null);
        theatre.setExit(Direction.WEST, outside);

        pub.setExit(Direction.NORTH, null);
        pub.setExit(Direction.EAST, outside);
        pub.setExit(Direction.SOUTH, null);
        pub.setExit(Direction.WEST, null);

        lab.setExit(Direction.NORTH, outside);
        lab.setExit(Direction.EAST, office);
        lab.setExit(Direction.SOUTH, null);
        lab.setExit(Direction.WEST, null);

        office.setExit(Direction.NORTH, null);
        office.setExit(Direction.EAST, null);
        office.setExit(Direction.SOUTH, null);
        office.setExit(Direction.WEST, lab);

        //currentRoom = outside;  // start game outside
        return outside;
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
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        CommandWord commandWord = command.getCommandWord();
        switch (commandWord) {
            case UNKNOWN: {
                System.out.println("I don't know what you mean...");
                break;
            }
            case HELP: {
                printHelp();
                break;
            }
            case GO: {
                goRoom(command);
                break;
            }
            case QUIT: {
                wantToQuit = quit(command);
                break;
            }
            case LOOK: {
                look();
                break;
            }
            case TAKE: {
                take(command);
                break;
            }
            case DROP: {
                drop(command);
                break;
            }
            case GIVE: {
                give(command);
                break;
            }

        }
        return wantToQuit;
    }

// implementations of user commands:

    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.showAllCommands());

    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String directionString = command.getSecondWord();

        Direction direction = Direction.getDirectionEnum(directionString);
        if (direction == Direction.UNKNOWN) {
            System.out.println("That is not a direction...");
            return;
        }

        // Try to leave current room.
        Room nextRoom = null;

        switch (direction) {
            case NORTH: {
                nextRoom = this.player.getCurrentRoom().getExits(Direction.NORTH);
                break;
            }
            case EAST: {
                nextRoom = this.player.getCurrentRoom().getExits(Direction.EAST);
                break;
            }
            case SOUTH: {
                nextRoom = this.player.getCurrentRoom().getExits(Direction.SOUTH);
                break;
            }
            case WEST: {
                nextRoom = this.player.getCurrentRoom().getExits(Direction.WEST);
                break;
            }
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            this.player.setCurrentRoom(nextRoom);
            printLocationInfo();
        }
    }

    /**
     * "Look" was entered. Report what the player can see in the room
     */
    private void look() {
        printLocationInfo();
    }

    /**
     * Try to take an item from the current room, otherwise print an error
     * message.
     */
    private void take(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }

        String item = command.getSecondWord();
        System.out.println(player.pickItem(item));


    }

    /**
     * Try to drop an item, otherwise print an error message.
     */
    private void drop(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop...
            System.out.println("Drop what?");
            return;
        }
        String item = command.getSecondWord();
        System.out.println(player.dropItem(item));
    }

    /**
     * Try to drop an item, otherwise print an error message.
     */
    private void give(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to give...
            System.out.println("Give what?");
            return;
        }
        if (!command.hasThirdWord()) {
            // if there is no third word, we don't to whom to give it...
            System.out.println("Give it to who?");
            return;
        }

        String item = command.getSecondWord();
        String whom = command.getThirdWord();

        System.out.println(this.player.giveItem(item, whom));


    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    private void printLocationInfo() {
        System.out.println(this.player.getCurrentRoom().getRoomDetailedDescription());
    }
}
