import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * This class represents items that can be used in Room class
 *
 * @author  Aisha Saleem
 * @version 2021.10.25
 */

public class Item {

    // An item in the room
    private String itemDescription;
    private int itemWeight;

    /**
     * parameterless constructor
     */
    public Item() {
    }

    /**
     * parameterized constructor
     * @param itemDescription
     * @param itemWeight
     */
    public Item(String itemDescription, int itemWeight) {
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
    }


    /**
     * Getter setter methods for item's weight field
     * @return
     */
    public int getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    /**
     * Item's description getter method
     * @return
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Item's description setter method
     * @return
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    /**
     *
     * @return an item's details including its weight and description in a property
     */
    public String getItemsDetailString(){
        StringBuilder detailString=new StringBuilder();
        detailString.append(itemDescription).append('(').append(itemWeight).append(')');
        return detailString.toString();
    }

    /**
     *
     * @param iterator to access the collection of items
     * @param itemDescription to find an item with this description
     * @return instance of an item if a match is found in the collection with the required description or null in case no item found
     */
/*    public Item findAnItem(String itemDescription) {
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (item.itemDescription.equals(itemDescription)) {
                return item;
            }
        }
        //in case no item with the required description is found
        return null;
    }*/

}
