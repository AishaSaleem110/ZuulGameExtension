import java.util.ArrayList;

public class Player {

    private ArrayList items;
    private ArrayList weights;
    private int totalWeight;
    private final int MAX_WEIGHT = 10;

    public Player() {

        this.items = new ArrayList();
        this.weights = new ArrayList();
        this.totalWeight = 0;
    }

    //should improve to send string from here instead of Game class
    public boolean pickItem(String itemDescription,int itemWeight){
        if (this.totalWeight + itemWeight >= this.MAX_WEIGHT) {
            // The player is carrying too much
            return false;

        }else
        {
            items.add(itemDescription);
            weights.add(itemWeight);
            totalWeight += itemWeight;
            return true;
        }
    }

    public boolean dropItem(String item){

        int i = items.indexOf(item);
        if (i == -1) {
            return false;

        }
        items.remove(i);
        int w = (Integer) weights.remove(i);
        totalWeight -= w;
        return true;
    }
}
