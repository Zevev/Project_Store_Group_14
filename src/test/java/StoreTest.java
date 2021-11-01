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
}
