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
    private String filename;

    public SiteRepository(String filename) {
        this.filename = filename;
    }

    public static List<Store> readFromJSON(String filename) {
        List<Store> stores = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Store[] storeArray = objectMapper.readValue(new File(filename), Store[].class);

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
            if(store.getName().equals(storeName)) {
                return store;
            }
        }
        return null;
    }



    @Override
    public List<Store> getAllStores() {
        return readFromJSON("Store.JSON");
    }

    @Override
    public Item getAItem(String storeName, String itemName) {
        try {
            return getAStore(storeName).getItem(itemName);
        }
        catch(NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
        return null;

    }

    @Override
    public  List<Item> items(String storeName) {
        return getAStore(storeName).getItems();

    }

    @Override
    public List<Item> getAllItems() {
        List<Store> stores = new ArrayList<>(getAllStores());
        List<Item> allItems = new ArrayList<>();
        for (Store stores1 : stores){
            List<Item>currentItemList = items(stores1.getName());
            for(Item items : currentItemList){
                allItems.add(items);
            }
        }
        return allItems;
    }

    @Override
    public Item getAItemWithoutStoreName(String itemName) {
        List<Store> stores = new ArrayList<>(getAllStores());
        List<Item> allItems = new ArrayList<>();
        for (Store stores1 : stores){
            List<Item>currentItemList = items(stores1.getName());
            for(Item items : currentItemList){
                if (items.getName().equals(itemName)){
                    return items;
                }
            }
        }
        return null;
    }


    @Override
    public void createItem( String storeName, String itemName, String itemType, String itemPictureURL, double itemPrice) {
        List<Store> stores = new ArrayList<>(getAllStores());
        List<Item> items = new ArrayList<>(getAllItems());
        int itemID = items.size()+1;
        for(Store stores1 : stores){
            if(storeName.equals(stores1.getName())) {
                stores1.addItem(new Item(itemID, storeName, itemName, itemType, itemPictureURL, itemPrice));
            }
        }
        writeToJson("Store.json", stores);
    }


    @Override
    public void updateItem(String currentItemName, String storeName, String itemName, String itemType, String itemPictureURL, double itemPrice) {
        List<Store> stores = new ArrayList<>(getAllStores());
        for(Store stores1 : stores){
            if(storeName.equals(stores1.getName())){
                stores1.getItem(currentItemName).setName(itemName);
                stores1.getItem(itemName).setItemType(itemType);
                stores1.getItem(itemName).setPictureUrl(itemPictureURL);
                stores1.getItem(itemName).setItemPrice(itemPrice);
            }
        }
        writeToJson("Store.json", stores);
    }

    @Override
    public void bidItem(String storeName, String itemName, double itemPrice){
        List<Store> stores = new ArrayList<>(getAllStores());
        for(Store stores1 : stores){
            if(storeName.equals(stores1.getName())){

                if(stores1.getItem(itemName).getItemPrice() < itemPrice){
                    stores1.getItem(itemName).setItemPrice(itemPrice);
                }
            }
        }
        writeToJson("Store.json", stores);
    }

    @Override
    public void removeItem(String storeName, String itemName) {
        List<Store> stores = new ArrayList<>(getAllStores());
        for(Store stores1 : stores){
            for(Store stores2 : stores){
                if(storeName.equals(stores2.getName())){
                    stores2.removeItem(stores2.getItem(itemName));
                }
            }
        }
        writeToJson("Store.json", stores);
    }

    @Override
    public void removeStore(String storeName){
        List<Store> stores = new ArrayList<>(getAllStores());
        for(Store stores1 : stores){
            if(storeName.equals(stores1.getName())){
                stores.remove(stores1);
            }
        }

        writeToJson("Store.json", stores);
    }


}
