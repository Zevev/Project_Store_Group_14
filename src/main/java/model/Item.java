package model;

public class Item {
    private int itemID;
    private String storeName,itemName, itemType, itemPictureURL;
    private double itemPrice;

    public Item(int itemID, String storeName, String itemName, String itemType, String itemPictureURL, double itemPrice) {
        this.itemID = itemID;
        this.storeName = storeName;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
        return "Varen heter " + getItemName() + " og er av typen " + getItemType() + ". Denne varen koster: " + getItemPrice();
    }
}
