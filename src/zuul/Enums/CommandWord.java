package zuul.Enums;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class represents Enumerated Types for the Commands within the zuul game application
 * *
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public enum CommandWord {
    GO("go"),
    QUIT("quit"),
    HELP("help"),
    LOOK("look"),
    TAKE("take"),
    DROP("drop"),
    GIVE("give"),
    PLAYER("player"),
    UNKNOWN("?");

    private String commandValue;

    CommandWord(String commandValue) {
        this.commandValue=commandValue;
    }

    @Override
    public String toString() {
        return commandValue;
    }
}
