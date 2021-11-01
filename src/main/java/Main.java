import com.fasterxml.jackson.databind.ObjectMapper;
import model.Item;
import model.Store;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static repository.SiteRepository.readFromJSON;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        List<Store> stores = new ArrayList<>();

        Item Vase = new Item(1,"Halden Store", "Fin Vase", "Vase", "BildeURL", 299.99);
        Item anotherItem = new Item(2,"Halden Store", "A item", "THe Item Type", "URL", 999.99);
        items.add(Vase);
        items.add(anotherItem);
        Store store = new Store(1,"Halden Store",items);
        stores.add(store);
        User user = new User("UserName", "PassWord");
        writeToJson("Stores.json",stores);

        /*System.out.println("ItemID: ");
        String itemId = sc.next();
        int newItemID = Integer.valueOf(itemId);
        System.out.println("ItemStore: ");
        String ItemStore = sc.next();
        int newItemStore = Integer.valueOf(ItemStore);
        System.out.println("ItemName: ");
        String ItemName = sc.next();
        System.out.println("ItemType: ");
        String itemType = sc.next();
        System.out.println("ItemPictureURL: ");
        String pictureURL = sc.next();
        System.out.println("ItemPrice: ");
        String itemPrice = sc.next();
        double newItemPrice = Double.parseDouble(itemPrice);
        items.add(new Item(newItemID,newItemStore,ItemName,itemType, pictureURL,newItemPrice));
        writeToJson("items.json", items);

        System.out.println(items);*/




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
    public static Store getAStore(String storeName) {
        for(Store store : getAllStores()){
            if(store.getStoreName().equals(storeName)) {
                return store;
            }
        }
        return null;
    }




    public static List<Store> getAllStores() {
        return readFromJSON("Stores.JSON");
    }


    public static Item getAItem(String storeName, String itemName) {
        return getAStore(storeName).getItem(itemName);

    }


    public static List<Item> items(String storeName) {
        return getAStore(storeName).getItems();

    }


    public static List<Item> getAllItems() {
        List<Store> stores = new ArrayList<>(getAllStores());
        List<Item> allItems = new ArrayList<>();
        for (Store stores1 : stores){
            List<Item>currentItemList = items(stores1.getStoreName());
            for(Item items : currentItemList){
                allItems.add(items);
            }
        }
        return allItems;
    }


    public static Item getAItemWithoutStoreName(String itemName) {
        List<Store> stores = new ArrayList<>(getAllStores());
        List<Item> allItems = new ArrayList<>();
        for (Store stores1 : stores){
            List<Item>currentItemList = items(stores1.getStoreName());
            for(Item items : currentItemList){
                if (items.getItemName().equals(itemName)){
                    return items;
                }
            }
        }
        return null;
    }



    public static void createItem(int itemID, String storeName, String itemName, String itemType, String itemPictureURL, double itemPrice) {
        List<Store> stores = new ArrayList<>(getAllStores());
        for(Store stores1 : stores){
            if(storeName.equals(stores1.getStoreName())) {
                stores1.addItem(new Item(itemID, storeName, itemName, itemType, itemPictureURL, itemPrice));
            }
        }
        writeToJson("Stores.json", stores);
    }



    public static void updateItem(int itemID,String currentItemName, String storeName, String itemName, String itemType, String itemPictureURL, double itemPrice) {
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



    public static void removeItem(String storeName, String itemName) {
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
