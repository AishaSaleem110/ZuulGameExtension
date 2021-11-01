package zuul;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class represents items that can be used in zuul.Room class
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class Item {

    private String description;
    private int weight;

    /**
     * parameterless constructor
     */
    public Item() {
    }

    /**
     * parameterized constructor
     *
     * @param description - String describes the item
     * @param weight      - specifies the int weight of the item
     */
    public Item(String description, int weight) {
        this.description = description;
        this.weight = weight;
    }


    /**
     * @return int weight of an item
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight- sets the specified weight to an item
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return string description of an item
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description -sets the specified String description of an item
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return item class field values in a formatted String literal
     */
    @Override
    public String toString() {
        return description + "(" + weight + ")";
    }


}
