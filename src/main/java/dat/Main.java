package dat;

import dat.config.ThymeleafConfig;
import dat.controllers.OrderController;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;

public class Main
{
    public static void main(String[] args)
    {
        // Initializing Javalin and Jetty webserver


        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
            JavalinThymeleaf.init(ThymeleafConfig.templateEngine());
        }).start(7070);

        // Routing

        app.get("/", ctx ->  ctx.render("index.html"));
        app.get("/showOrder", ctx -> OrderController.showOrder(ctx));
    }
}