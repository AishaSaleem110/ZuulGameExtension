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

    private String description;
    private int weight;

    /**
     * parameterless constructor
     */
    public Item() {
    }

    /**
     * parameterized constructor
     * @param description
     * @param weight
     */
    public Item(String description, int weight) {
        this.description = description;
        this.weight = weight;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return description + "(" + weight + ")";
    }



}
