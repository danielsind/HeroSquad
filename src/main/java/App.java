import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import javax.management.MalformedObjectNameException;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/",(request, response) -> {
            Map<String,Object>model = new HashMap<String, Object>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/new",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String ability = request.queryParams("ability");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name,age,ability,weakness);
            return  new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Hero> heroes = Hero.getInstances();
            model.put("heroes",heroes);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

    }
}