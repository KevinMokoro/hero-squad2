import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App{
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine() );

        post("/heroes/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");

            Hero newHero = new Hero(name,age,power,weakness);
            model.put("newHero",newHero);
            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());

        get("/heroes",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            ArrayList<Hero> allHeroes = Hero.getAll();
            model.put("allHeroes",allHeroes);
            return new ModelAndView(model,"heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
           // int idOfHeroToFind = Integer.parseInt(request.params("id"));
            Hero selectedHero = Hero.findById(Integer.parseInt(request.params("id")));
            model.put("selectedHero", selectedHero);
            return new ModelAndView(model,"hero-detail.hbs");
        },new HandlebarsTemplateEngine());

        get("/heroes/:id/update",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            Hero editHero = Hero.findById(Integer.parseInt(request.params("id")));
            model.put("editHero",editHero);
            return new ModelAndView(model,"hero-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/heroes/:id/update",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            String newName = request.queryParams("name");
            int newAge = Integer.parseInt(request.params("age"));
            String newPower = request.queryParams("power");
            String newWeakness = request.queryParams("weakness");
            Hero editedHero = Hero.findById(Integer.parseInt(request.params("id")));
            editedHero.update(newName,newAge,newPower,newWeakness);
         //   model.put("editedHero",editedHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id/delete",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            Hero toDelete = Hero.findById(Integer.parseInt(request.params("id")));
            toDelete.delete();
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());




    }
}