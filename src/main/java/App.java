import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("sightings", Sighting.all());
      model.put("animals", Animal.all());
      model.put("AnimalClass", Animal.class);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sighting/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String ranger_name = request.queryParams("ranger_name");
      String location = request.queryParams("location");
      String name = request.queryParams("name");
      String endangered = request.queryParams("endangered");
      String health = request.queryParams("health");
      String age = request.queryParams("age");

      Animal newAnimal = new Animal(name, endangered);
      if(newAnimal.completeSave()) {
        newAnimal.save();
        response.redirect("/");
      } else {
        response.redirect("/failure");
      }

      Sighting newSighting = new Sighting(ranger_name, location, newAnimal.getId());
      newSighting.save();

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/failure", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/failure.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
