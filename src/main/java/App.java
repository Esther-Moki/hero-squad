import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        // heroinput route
        get("/heroInput", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "heroInput.hbs");
        }, new HandlebarsTemplateEngine());

        get("/superhero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String heroName = request.queryParams("heroName");
            int heroAge = Integer.parseInt(request.queryParams("heroAge"));
            String specialPower = request.queryParams("specialPower");
            String weakness = request.queryParams("weakness");
            model.put("heroName", heroName);
            model.put("heroAge", heroAge);
            model.put("specialPower",specialPower);
            model.put("weakness",weakness);
            return new ModelAndView(model, "superhero.hbs");
        }, new HandlebarsTemplateEngine());
        get("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String squadName = request.queryParams("squadName");
            int squadSize = Integer.parseInt(request.queryParams("squadSize"));
            String squadCause = request.queryParams("squadCause");
            model.put("squadName", squadName);
            model.put("squadSize", squadSize);
            model.put("squadCause",squadCause);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        //squad input route
        get("/Squadinput", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "Squadinput.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
