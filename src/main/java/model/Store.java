package model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int storeID;
    private String name;
    private List<Item> items;

    public Store(int storeID, String name, List<Item> items) {
        this.storeID = storeID;
        this.name = name;
        this.items = items;
    }

    public Store() {

    }
    public void addItem(Item item){
        items.add(item);
    }

    public Item getItem(String itemName){
        for(Item item : items){
            if(item.getName().equals(itemName))
                return item;

        }
        return null;
    }

    public List<Item> getItems() {
        return new ArrayList<Item>(items);
    }
    public void removeItem(Item item){items.remove(item);}

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Butikken heter " + getName() + " og har en liste med varer som er " + getItems();
    }
    //return String.format("%s has %d planets that revolve around the star %s", name, planets.size(), centerStar.getName());
}
