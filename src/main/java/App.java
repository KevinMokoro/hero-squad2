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

        get("heroes/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine() );

        post("heroes/new",(request, response) -> {
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



    }
}