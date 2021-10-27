import java.util.ArrayList;

public class Player {

    private ArrayList items;
    private ArrayList weights;
    private int totalWeight;
    private final int MAX_WEIGHT = 10;
    private Room currentRoom;

    public Player(Room currentRoom) {

        this.items = new ArrayList();
        this.weights = new ArrayList();
        this.totalWeight = 0;
        this.currentRoom=currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


    public String pickItem(String itemDescription){

        int w = getCurrentRoom().containsItem(itemDescription);
        if (w == 0) {
            // The item is not in the room
           return "No " + itemDescription + " in the room";
        }

        if (checkIfWeightAllowedToPlayer(w)) {
            // The player is carrying too much
            return itemDescription +" is too heavy";

        }else
        {
            items.add(itemDescription);
            weights.add(w);
            totalWeight += w;
            currentRoom.removeItem(itemDescription);
            return "Item has been picked up.";
        }
    }

    public String dropItem(String item){
        int itemIndex=checkPlayerHasItem(item);
        if(itemIndex==-1){
            return "You don't have the " + item;
        }

        else {
            items.remove(itemIndex);
            int w = (Integer) weights.remove(itemIndex);
            totalWeight -= w;
            getCurrentRoom().addItem(item, w);
            return "Item has been dropped.";
        }

    }

    public String giveItem(String itemDescription,String character){

        if (getCurrentRoom().getCharacter().equals(character)) {
            // cannot give it if the chacter is not here
            return character + " is not in the room";
        }

        int itemIndex=checkPlayerHasItem(itemDescription);
        if(itemIndex==-1){
            return "You don't have the " + itemDescription;
        }
        else{
            items.remove(itemIndex);
            int w = (Integer) weights.remove(itemIndex);
            totalWeight -= w;

            return "Item has been given to"+character;
        }


    }

    private int checkPlayerHasItem(String item){
        int i = this.items.indexOf(item);
        return i;
    }

    private boolean checkIfWeightAllowedToPlayer(int newItemWeight){
        return (this.totalWeight + newItemWeight >= this.MAX_WEIGHT);
    }
}
