
import model.Item;
import model.Store;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import repository.ISiteRepository;
import repository.SiteRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


import static org.junit.Assert.*;


public class ItemTest {
    private ISiteRepository siteRepository;

    public ItemTest(ISiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    @Test
    public void Get_All_Items(){
        List<Item> gettingItems = new ArrayList<>();
        gettingItems = siteRepository.items("Halden Store");
        for (Item items : gettingItems){
            assertNotNull(items);
        }
    }

    @Test
    public void Get_One_Item_Without_Store_Name(){
        Item oneItem = siteRepository.getAItemWithoutStoreName("Fin Vase");
        assertNotNull(oneItem);

    }
}
