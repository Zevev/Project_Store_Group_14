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
        Scanner sc = new Scanner(System.in);
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

    public static List<Item> items(String storeName) {
        return getAStore(storeName).getItems();

    }
}
