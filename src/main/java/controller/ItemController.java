package controller;

import model.Item;
import model.Store;
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
        String itemName = context.pathParam("");
        String storeName = context.pathParam("");

        Item itemInfo = siteRepository.getAItem(storeName, itemName);
        context.json(itemInfo);
    }

    public void getAllItems(Context context){
        String itemName = context.pathParam("");
        String storeName = context.pathParam("");

        List<Item> itemList = siteRepository.items(storeName);
        context.json(itemList);
    }

    public void addItems(Context context){
        /*int itemID = context.formParam("");
        String itemName = context.pathParam("");

        Item newItem = siteRepository.createItem(itemName);*/


    }

    public void deleteItems(){

    }

    public void updateItems(){

    }

}

