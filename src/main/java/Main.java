import com.fasterxml.jackson.databind.ObjectMapper;
import model.Item;
import model.Store;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Item Vase = new Item(1,1,"Kola","Vase","FintBildet",299.99);
        items.add(Vase);
        Store store = new Store(1,"Halden Store",items);
        User user = new User("UserName", "PassWord");

        System.out.println("ItemID: ");
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

        System.out.println(items);




    }
    public static void writeToJson(String filename, List<Item> items) {
        try {
            File file = new File(filename);
            ObjectMapper objectMapper = new ObjectMapper();


            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
