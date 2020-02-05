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
            List<Hero> heroes = Hero.getInstances();
            model.put("heroes",heroes);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            return  new ModelAndView(model,"newhero-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/heroes/new",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();

            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String ability = request.queryParams("ability");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name,age,ability,weakness);
            model.put("hero",newHero);
            return  new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        get("heroes/:id",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            int IdOfHeroToFind = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(IdOfHeroToFind);
            model.put("hero",foundHero);
            return new ModelAndView(model,"hero-detail.hbs");
        },new HandlebarsTemplateEngine());

        get("/heroes/:id/update",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            model.put("editHero",editHero);
            return  new ModelAndView(model,"hero-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/heroes/:id/update", (request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String newName = request.queryParams("name");
            String newAbility = request.queryParams("ability");
            String newWeakness = request.queryParams("weakness");
            int newAge = Integer.parseInt(request.queryParams("age"));
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            editHero.update(newName,newAbility,newWeakness,newAge);
            return  new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Hero> heroes = Hero.getInstances();
            model.put("heroes",heroes);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());
        get("heroes/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"newhero-form.hbs");
        },new HandlebarsTemplateEngine());

        get("heroes/:id",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            int IdOfHeroToFind = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(IdOfHeroToFind);
            model.put("hero",foundHero);
            return new ModelAndView(model,"hero-detail.hbs");
        },new HandlebarsTemplateEngine());
    }
}