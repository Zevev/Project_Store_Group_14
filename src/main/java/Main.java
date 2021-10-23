import model.Item;
import model.Store;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        Item Vase = new Item(1,1,"Kola","Vase","FintBildet",299.99);
        items.add(Vase);
        Store store = new Store(1,"Halden Store",items);
        User user = new User("UserName", "PassWord");

        System.out.println(Vase);
        System.out.println(store);
        System.out.println(user);
    }
}
