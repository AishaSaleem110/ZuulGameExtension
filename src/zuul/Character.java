package zuul;

import java.util.ArrayList;

public class Character {
    private String name;
    private ArrayList<Item> items;

    public Character(String name, Item item) {
        this.name = name;
        this.items = new ArrayList<>();
        this.items.add(item);
    }

    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String speak(){
    return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
