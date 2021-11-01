package zuul;

import java.util.Scanner;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a three word command. It returns the command
 * as an object of class zuul.Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * The parser follows Singleton Design pattern hence only one instance of Parser class can be created at a given time.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Parser 
{
    private CommandWordsOperations commands;  // holds all valid command words
    private Scanner reader;         // source of command input
    private static Parser parser=null;
    /**
     * Create a parser to read from the terminal window.
     */
    private Parser()
    {
        commands = new CommandWordsOperations();
        reader = new Scanner(System.in);
    }

    /**
     *
     * @return instance of a Parser if its already created
     * else create an instance of Parser class and then return it
     */
    public static Parser getInstance() {
        if (parser == null) {
            parser=new Parser();
        }
        return parser;
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;
        String word3 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
            }
            if(tokenizer.hasNext()) {
                word3 = tokenizer.next();      // get third word
                // note: we just ignore the rest of the input line.
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).

        return new Command(commands.getCommandWord(word1), word2, word3);

    }

    /**
     *
     * @return as String literal the list of all valid commands from the CommandWordsOperations class
     */
    public String showAllCommands(){
        return commands.printAllCommands();
    }
}
