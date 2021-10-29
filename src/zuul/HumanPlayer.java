package zuul;

import java.util.HashMap;

public class HumanPlayer extends Player{

    private HashMap<String, Integer> items;
    private int totalWeight;
    private final int MAX_WEIGHT = 10;


    public HumanPlayer(Room currentRoom, int id) {
        super(currentRoom,id);
        this.items = new HashMap<>();
        this.totalWeight = 0;
        this.currentRoom = currentRoom;
    }

    private boolean checkPlayerHasItem(String item) {
        return items.containsKey(item);
    }

    private boolean checkIfWeightAllowedToPlayer(int newItemWeight) {
        return (this.totalWeight + newItemWeight >= this.MAX_WEIGHT);
    }

    @Override
    public String toString() {
        return "zuul.Player: " +
                "playerId=" + playerId+
                "items=" + items +
                ", totalWeight=" + totalWeight +
                ", MAX_WEIGHT=" + MAX_WEIGHT +
                ", currentRoom=" + currentRoom ;
    }


    @Override
    public String move(Direction direction) {
        return null;
    }

    @Override
    public String look() {
        return null;
    }

    @Override
    public String take(String itemDesc) {
        int w = getCurrentRoom().containsItem(itemDesc);
        if (w == 0) {
            // The item is not in the room
            return "No " + itemDesc + " in the room";
        }

        if (checkIfWeightAllowedToPlayer(w)) {
            // The player is carrying too much
            return itemDesc + " is too heavy";

        } else {
            items.put(itemDesc, w);
            totalWeight += w;
            currentRoom.removeItem(itemDesc);
            return "zuul.Item has been picked up.";
        }
    }

    @Override
    public String drop(String itemDesc) {
        if (!checkPlayerHasItem(itemDesc)) {
            return "You don't have the " + itemDesc;
        }
        else {

            totalWeight -= items.get(itemDesc);
            getCurrentRoom().addItem(itemDesc, items.get(itemDesc));
            items.remove(itemDesc);

            return "zuul.Item has been dropped.";
        }
    }

    @Override
    public String give(String itemDesc, String whom) {
        if ((getCurrentRoom().getCharacter() == null) || !(getCurrentRoom().getCharacter().equals(whom))) {
            return whom + " is not in the room";
        }

        if (!checkPlayerHasItem(itemDesc)) {

            return "You don't have the " + itemDesc;
        } else {

            totalWeight -= items.get(itemDesc);
            items.remove(itemDesc);

            return "zuul.Item has been given to " + whom;
        }
    }
}
