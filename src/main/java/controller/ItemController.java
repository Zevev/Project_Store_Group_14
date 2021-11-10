package controller;

import model.Item;
import model.Store;
import org.jetbrains.annotations.NotNull;
import repository.ISiteRepository;
import repository.SiteRepository;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;


public class ItemController {
private ISiteRepository siteRepository;
    public ItemController(ISiteRepository siteRepository){
        this.siteRepository = siteRepository;
    }

    public void getItems(Context context){
        String storeName = context.pathParam("store-id");

        List<Item> items = siteRepository.items(storeName);

        context.json(items);
    }

    public void getSpecificItem(Context context){
        String storeName = context.pathParam("store-id");
        String itemName = context.pathParam("item-id");
        Item item = new Item();
        item = siteRepository.getAItem(storeName, itemName);

        context.json(item);
    }

    public void getAllItems(Context context){
        List<Item> itemList = siteRepository.getAllItems();
        context.json(itemList);
    }

    public void createItem(Context context){
       String storeName = context.pathParam("store-id");
       String itemName = context.formParam("name");
       String itemType = context.formParam("itemType");
       String pictureUrl = context.formParam("pictureUrl");
       String itemPrice = context.formParam("itemPrice");
       siteRepository.createItem(storeName,itemName,itemType,pictureUrl,Double.parseDouble(itemPrice));

        context.redirect("/stores/" + storeName);
    }

    public void deleteItems(Context context){
        String storeName = context.pathParam("store-id");
        String itemName = context.pathParam("item-id");

        siteRepository.removeItem(storeName, itemName);

    }

    public void bidItem(Context context){
        String storeName = context.pathParam("store-id");
        String itemName = context.pathParam("item-id");
        String itemPrice = context.formParam("itemPrice");
        siteRepository.bidItem(storeName,itemName,Double.parseDouble(itemPrice));
        context.redirect("/stores/" + storeName + "/items/" + itemName + "/bid");

    }

}

