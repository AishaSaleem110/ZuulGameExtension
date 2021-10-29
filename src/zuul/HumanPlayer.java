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

    private boolean checkPlayerHasItem(String item)
    {
        return items.containsKey(item);
    }

    private boolean checkAllowedWeight(int newItemWeight) {
        return (this.totalWeight + newItemWeight >= this.MAX_WEIGHT);
    }

    @Override
    public String move(Direction direction)
    {
        // Try to leave current room.
        Room nextRoom = getCurrentRoom().getExits(direction);


        if (nextRoom == null) {
            return "There is no door!";
        } else {
            setCurrentRoom(nextRoom);
            return getPlayerLocationInfo();
        }
    }

    @Override
    public String look()
    {
        return getPlayerLocationInfo();
    }

    @Override
    public String take(String itemDesc) {
        int w = getCurrentRoom().containsItem(itemDesc);
        if (w == 0) {
            // The item is not in the room
            return "Item is not in the room.";
        }

        if (checkAllowedWeight(w)) {
            // The player is carrying too much
            return "Item is too heavy";

        } else {
            items.put(itemDesc, w);
            totalWeight += w;
            currentRoom.removeItem(itemDesc);
            return "Item has been picked up.";
        }
    }

    @Override
    public String drop(String itemDesc) {
        if (!checkPlayerHasItem(itemDesc)) {
            return "You don't have this item.";
        }
        else {

            totalWeight -= items.get(itemDesc);
            getCurrentRoom().addItem(itemDesc, items.get(itemDesc));
            items.remove(itemDesc);

            return "Item has been dropped.";
        }
    }

    @Override
    public String give(String itemDesc, String whom) {
        if (getCurrentRoom().getCharacter(whom) == null) {
            return "This character is not in the room.";
        }

        if (!checkPlayerHasItem(itemDesc)) {

            return "You don't have this item.";
        } else {
            int w=this.items.get(itemDesc);
            totalWeight -= w;
            getCurrentRoom().getCharacter(whom).addItem(new Item(itemDesc,w));
            items.remove(itemDesc);

            return "Item has been given to the requested character.";
        }
    }

}
