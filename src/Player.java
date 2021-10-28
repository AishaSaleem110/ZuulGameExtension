import java.util.ArrayList;
import java.util.HashMap;

public class Player {

    private HashMap<String, Integer> items;
    private int totalWeight;
    private final int MAX_WEIGHT = 10;
    private Room currentRoom;
    private int playerId;

    public Player(Room currentRoom,int id) {

        this.items = new HashMap<>();
        this.totalWeight = 0;
        this.currentRoom = currentRoom;
        this.playerId=id;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }


    public String pickItem(String itemDescription) {

        int w = getCurrentRoom().containsItem(itemDescription);
        if (w == 0) {
            // The item is not in the room
            return "No " + itemDescription + " in the room";
        }

        if (checkIfWeightAllowedToPlayer(w)) {
            // The player is carrying too much
            return itemDescription + " is too heavy";

        } else {
            items.put(itemDescription, w);
            totalWeight += w;
            currentRoom.removeItem(itemDescription);
            return "Item has been picked up.";
        }
    }

    public String dropItem(String item) {
        if (!checkPlayerHasItem(item)) {
            return "You don't have the " + item;
        }
        else {

            totalWeight -= items.get(item);
            getCurrentRoom().addItem(item, items.get(item));
            items.remove(item);

            return "Item has been dropped.";
        }

    }

    public String giveItem(String itemDescription, String character) {

        if ((getCurrentRoom().getCharacter() == null) || !(getCurrentRoom().getCharacter().equals(character))) {
            return character + " is not in the room";
        }

        if (!checkPlayerHasItem(itemDescription)) {

            return "You don't have the " + itemDescription;
        } else {

            totalWeight -= items.get(itemDescription);
            items.remove(itemDescription);

            return "Item has been given to " + character;
        }
    }

    private boolean checkPlayerHasItem(String item) {
        return items.containsKey(item);
    }

    private boolean checkIfWeightAllowedToPlayer(int newItemWeight) {
        return (this.totalWeight + newItemWeight >= this.MAX_WEIGHT);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId+
                "items=" + items +
                ", totalWeight=" + totalWeight +
                ", MAX_WEIGHT=" + MAX_WEIGHT +
                ", currentRoom=" + currentRoom +
                '}';
    }
}
