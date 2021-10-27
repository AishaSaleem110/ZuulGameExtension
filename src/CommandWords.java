import java.util.Arrays;
import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class CommandWords
{

    private HashMap<String,CommandWord> validCommands;

    public CommandWords()
    {
        validCommands=new HashMap<>();
        validCommands.put("go",CommandWord.GO);
        validCommands.put("quit",CommandWord.QUIT);
        validCommands.put("help",CommandWord.HELP);
        validCommands.put("look",CommandWord.LOOK);
        validCommands.put("take",CommandWord.TAKE);
        validCommands.put("drop",CommandWord.DROP);
        validCommands.put("give",CommandWord.GIVE);

    }


    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command= validCommands.get(commandWord);
        if(validCommands!=null){
            return command;
        }else{
            return CommandWord.UNKNOWN;
        }

    }

    /**
     * This method prints list of all valid commands
     */
    public String printAllCommands(){
        StringBuilder commandListString=new StringBuilder();
        for(String commands:validCommands.keySet()){
            commandListString.append(commands).append(" ");
        }
        return commandListString.toString();
    }
    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return  validCommands.containsKey(aString);

    }
}
