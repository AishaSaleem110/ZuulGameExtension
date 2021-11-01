package zuul;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {

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
            e.printStackTrace();
        }

        return playerList;


    }
}
