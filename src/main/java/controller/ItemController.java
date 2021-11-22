package controller;

import model.Item;
import model.Store;
import org.jetbrains.annotations.NotNull;
import repository.ISiteRepository;
import repository.SiteRepository;
import io.javalin.http.Context;

import java.util.*;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class ItemController {
private ISiteRepository siteRepository;
    public ItemController(ISiteRepository siteRepository){
        this.siteRepository = siteRepository;
    }

    public void getItems(Context context){
        String storeName = context.pathParam("store-id");
        String sortBy = context.queryParam("sort_by");

        List<Item> items = new ArrayList<>(siteRepository.items(storeName));
        /*if (sortBy != null) {
            switch (sortBy) {
                case "name":
                    items = items.stream().sorted().collect(Collectors.toList());

                    break;
                case "type":

                    break;
                case "price":
                    items.sort((o1, o2) -> (int) (o1.getItemPrice() - o2.getItemPrice()));
                    break;
            }
        }*/

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

    public void updateItem(Context context){
        String storeName = context.pathParam("store-id");
        String itemName = context.formParam("name");
        String itemType = context.formParam("itemType");
        String pictureUrl = context.formParam("pictureUrl");
        String itemPrice = context.formParam("itemPrice");
        siteRepository.updateItem(itemName,storeName,itemName,itemType,pictureUrl,Double.parseDouble(itemPrice));
        context.redirect("/stores/" + storeName + "/items/" + itemName);
    }

    public void deleteItems(Context context){
        String storeName = context.pathParam("store-id");
        String itemName = context.pathParam("item-id");

        siteRepository.removeItem(storeName, itemName);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        context.redirect("/purchase/");

    }

    public void bidItem(Context context){
        String storeName = context.pathParam("store-id");
        String itemName = context.pathParam("item-id");
        String itemPrice = context.formParam("itemPrice");
        siteRepository.bidItem(storeName,itemName,Double.parseDouble(itemPrice));
        context.redirect("/stores/" + storeName + "/items/" + itemName + "/bid");

    }

}

