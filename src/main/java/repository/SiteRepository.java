package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Item;
import model.Store;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SiteRepository implements ISiteRepository {

    public List<Store> readFromJSON(String filnavn) {
        List<Store> stores = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Store[] storeArray = objectMapper.readValue(new File(filnavn), Store[].class);

            stores = Arrays.asList(storeArray);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return stores;
    }

    public static void writeToJson(String filename, List<Store> stores) {
        try {
            File file = new File(filename);
            ObjectMapper objectMapper = new ObjectMapper();


            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, stores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Store getAStore(String storeName) {
        for(Store store : getAllStores()){
            if(store.getStoreName().equals(storeName)) {
                return store;
            }
        }
        return null;
    }



    @Override
    public List<Store> getAllStores() {
        return readFromJSON("Stores.JSON");
    }

    @Override
    public Item getAItem(String storeName, String itemName) {
        return getAStore(storeName).getItem(itemName);

    }

    @Override
    public List<Item> items(String storeName) {
        return getAStore(storeName).getItems();

    }

    @Override
    public void createItem(int itemID, String storeName, String itemName, String itemType, String itemPictureURL, double itemPrice) {
        List<Store> stores = new ArrayList<>(getAllStores());
        for(Store stores1 : stores){
            if(storeName.equals(stores1.getStoreName())) {
                stores1.addItem(new Item(itemID, storeName, itemName, itemType, itemPictureURL, itemPrice));
            }
        }
        writeToJson("Stores.json", stores);
    }


    @Override
    public void updateItem(int itemID,String currentItemName, String storeName, String itemName, String itemType, String itemPictureURL, double itemPrice) {
        List<Store> stores = new ArrayList<>(getAllStores());
        for(Store stores1 : stores){
            if(storeName.equals(stores1.getStoreName())){
                stores1.getItem(currentItemName).setItemName(itemName);
                stores1.getItem(itemName).setItemType(itemType);
                stores1.getItem(itemName).setItemPictureURL(itemPictureURL);
                stores1.getItem(itemName).setItemPrice(itemPrice);
            }
        }
        writeToJson("Store.json", stores);
    }


    @Override
    public void removeItem(String storeName, String itemName) {
        List<Store> stores = new ArrayList<>(getAllStores());
        for(Store stores1 : stores){
            for(Store stores2 : stores){
                if(storeName.equals(stores2.getStoreName())){
                    stores2.removeItem(stores2.getItem(itemName));
                }
            }
        }
        writeToJson("Store.json", stores);
    }


}
