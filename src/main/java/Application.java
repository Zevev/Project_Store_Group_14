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

        app.get("api/stores", storeController::getAllStores);
        app.get("api/stores/:store-id", storeController::getAStore);
        app.get("api/stores/:store-id/items", itemController::getItems);
    }
}
