
import model.Item;
import model.Store;
import org.junit.jupiter.api.Test;
import repository.SiteRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


import static org.junit.Assert.*;

public class ItemTest {


    @Test
    public void Get_All_Items_With_Store_Name(){
        List<Item> gettingItems = new ArrayList<>();
        gettingItems = Main.items("Halden Store");
        for (Item items : gettingItems){
            assertNotNull(items);
        }
    }

    @Test
    public void Get_All_Items_Without_Store_Name(){
        List<Item> getItems = new ArrayList<>();
        getItems = Main.getAllItems();
        for (Item items : getItems){
            assertNotNull(items);
        }
    }

    @Test
    public void Get_A_Item_With_Store_Name(){
        assertNotNull(Main.getAItem("Halden Store", "Fin Vase"));
    }

    @Test
    public void Get_A_Item_Without_Store_Name(){
        assertNotNull(Main.getAItemWithoutStoreName("A item"));
    }

    @Test
    public void Get_A_Store_Using_A_Store_Name(){
        assertNotNull(Main.getAStore("Halden Store"));
    }

    @Test
    public void Get_All_Stores(){
        List<Store> stores = new ArrayList<>();
        stores = Main.getAllStores();
        for(Store stores1 : stores){
            assertNotNull(stores1);
        }
    }



}
