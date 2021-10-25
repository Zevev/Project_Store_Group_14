package repository;

import model.Item;
import model.Store;

import java.util.List;

public interface ISiteRepository {
    Store getAStore(String storeName);
    List<Store> getAllStores();
    Item getAItem(String itemName);
}
