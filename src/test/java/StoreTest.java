import model.Store;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreTest {
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

    @Test
    public void Remove_A_Store_With_Store_Name(){
         boolean storeExists = true;
         List<Store> stores = new ArrayList<>(Main.readFromJSON("Safety.json"));
        Store tempSave =  Main.getAStore("Halden Store");
        Main.removeStore("Halden Store");
        for(Store store : stores){
            if(store.getName() != "Halden Store"){

                storeExists = false;
            }
        }
        stores.add(tempSave);
        Main.writeToJson("Safety.json",stores);
        //assertFalse(storeExists);
    }
}
