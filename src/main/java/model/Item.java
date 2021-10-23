package model;

public class Item {
    private int itemID, itemStore;
    private String itemName, itemType, itemPictureURL;
    private double itemPrice;

    public Item(int itemID, int itemStore, String itemName, String itemType, String itemPictureURL, double itemPrice) {
        this.itemID = itemID;
        this.itemStore = itemStore;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemPictureURL = itemPictureURL;
        this.itemPrice = itemPrice;
    }
    public Item(){

    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getItemStore() {
        return itemStore;
    }

    public void setItemStore(int itemStore) {
        this.itemStore = itemStore;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemPictureURL() {
        return itemPictureURL;
    }

    public void setItemPictureURL(String itemPictureURL) {
        this.itemPictureURL = itemPictureURL;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", itemStore=" + itemStore +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemPictureURL='" + itemPictureURL + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
