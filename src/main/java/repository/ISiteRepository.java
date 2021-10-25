package repository;

import model.Item;
import model.Store;

import java.util.List;

public interface ISiteRepository {
    Store getAStore(String storeName);
    List<Store> getAllStores();
    Item getAItem(String storeName, String itemName);
    List<Item> items(String storeName);
    List<Item> getAllItems();
    Item getAItemWithoutStoreName(String itemName);
    void createItem(int itemID, String storeName, String itemName, String itemType, String itemPictureURL, double itemPrice);
    void updateItem(int itemID, String currentItemName,String storeName, String itemName, String itemType, String itemPictureURL, double itemPrice);
    void removeItem(String storeName, String itemName);
}
