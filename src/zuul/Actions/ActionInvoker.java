package zuul.Actions;

import zuul.Command;
import zuul.CommandWord;
import zuul.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.awt.SystemColor.text;

public class ActionInvoker {
    Action action;
    Command command;
    Player currentPlayer;

    public ActionInvoker(Command command, Player currentPlayer) {
        this.command = command;
        this.currentPlayer = currentPlayer;
    }

    public String executeAction() {
        CommandWord commandWord = command.getCommandWord();
        try {
            Class c = Class.forName("zuul.Actions." + convertToTitleCaseIteratingChars(commandWord.name()) + "Action");
            action = (Action) c.getDeclaredConstructor().newInstance();
            return action.execute(command, currentPlayer);

        } catch (Exception e) {
            UnknownAction unknownAction=new UnknownAction();
            return unknownAction.execute(null,null);

        }


    }

    private static String convertToTitleCaseIteratingChars(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }
}
