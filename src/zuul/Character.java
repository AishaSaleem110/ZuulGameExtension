package zuul;

import java.util.ArrayList;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class represents Character that can be used in zuul.Room class
 * Characters have a name and can also have items
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public class Character {
    private String name;
    private ArrayList<Item> items;

    /**
     * Creates an instance of Character class
     * @param name - string name of the Character
     * @param item - Item type item that a character can store
     */
    public Character(String name, Item item) {
        this.name = name;
        this.items = new ArrayList<>();
        this.items.add(item);
    }

    /**
     * creates an instance of a Character
     */
    public Character() {
        this.items = new ArrayList<>();
    }

    /**
     *
     * @return String name of a character
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name- sets string name of a character
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return lists of items that a character has
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     *
     * @param item - add an item to the list of Items that a character holds
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     *
     * @return a String literal
     */
    public String speak(){
    return "I am a character";
    }

    /**
     *
     * @return name of the character as a string
     */
    @Override
    public String toString() {
        return name;
    }
}
