package zuul.Players;


import zuul.Room;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class represents an implementation of Factory design pattern to create players within the game application
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */
public class PlayerFactory {

    /**
     *
     * @param playerType - String name of the class of the type of the Player to be created, will always be a concrete implementation of abstract Player class
     * @param count- int number of players to be created
     * @param currentRoom - entry room to be assigned to the player
     * @return List of the created players
     */
    public List<Player> createPlayers(String playerType, int count, Room currentRoom) {
        List<Player> playerList = new ArrayList<>();
        try {
            Class c = Class.forName(playerType);

            for (int i = 0; i < count; i++) {
                Player p = (Player) c.getDeclaredConstructor().newInstance();
                p.setCurrentRoom(currentRoom);
                p.setPlayerId(i);
                playerList.add(p);

            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return playerList;
        }

        return playerList;


    }
}
