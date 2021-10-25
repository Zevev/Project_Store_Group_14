package controller;
import io.javalin.http.Context;
import model.Store;
import org.jetbrains.annotations.NotNull;
import repository.ISiteRepository;
import repository.SiteRepository;

import java.util.ArrayList;
import java.util.List;

public class StoreController {
    private SiteRepository siteRepository;

    public StoreController(SiteRepository siteRepository) {
        this.siteRepository = new SiteRepository();
    }
    public void createStore(Context context){
        // method for create store //
    }

    public void getAStore(@NotNull Context context) {
        String storeName = context.pathParam("storeID");
        context.json(siteRepository.getAStore(storeName));
    }
    public void getAllStores(@NotNull Context context){
        context.json(siteRepository.getAllStores());
        String sortBy = context.queryParam("sort_by");
        // sort function here//
    }
    public void  getAItem(@NotNull Context context){
        context.json(siteRepository.getAItem("storeName","itemName"));


    }

}




