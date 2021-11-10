import controller.ItemController;
import controller.StoreController;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import repository.SiteRepository;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7001);

        app.config.enableWebjars();

        app.before("/", ctx -> ctx.redirect("/stores"));

        SiteRepository siteRepository = new SiteRepository("Stores.json");

        StoreController storeController = new StoreController(siteRepository);
        ItemController itemController = new ItemController(siteRepository);

        app.get("/stores", new VueComponent("store-overview"));
        app.get("/stores/:store-id", new VueComponent("store-detail"));
        app.get("/stores/:store-id/items/:item-id", new VueComponent("item-detail"));
        app.get("/stores/:store-id/createitem", new VueComponent("item-create"));
        app.get("/stores/:store-id/items/:item-id/auction", new VueComponent("item-auction"));

        app.get("api/stores", storeController::getAllStores);
        app.get("api/stores/allitems", itemController::getAllItems);
        app.get("api/stores/:store-id", storeController::getAStore);
        app.get("api/stores/:store-id/items", itemController::getItems);
        app.get("api/stores/:store-id/items/:item-id", itemController::getSpecificItem);
        app.get("api/stores/:store-id/items/:item-id/auction", itemController::deleteItems);
        app.post("api/stores/:store-id/createitem", itemController::createItem);
        app.get("api/stores/:store-id/items/:item-id/delete", itemController::deleteItems);
    }
}
