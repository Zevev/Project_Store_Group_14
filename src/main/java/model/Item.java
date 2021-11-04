package model;

public class Item {
    private int itemID;
    private String  storeName, name, itemType, pictureUrl;
    private double itemPrice;


    public Item(int itemID, String storeName, String name, String itemType, String pictureUrl, double itemPrice) {
        this.itemID = itemID;
        this.storeName = storeName;
        this.name = name;
        this.itemType = itemType;
        this.pictureUrl = pictureUrl;
        this.itemPrice = itemPrice;
    }

    public Item() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }



    @Override
    public String toString() {
        return String.format(name, storeName, itemType, pictureUrl, itemPrice);
    }


}
