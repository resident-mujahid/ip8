import org.sql2o.*;
import java.util.List;

public class Animal {
  public String name;
  public String endangered;
  public int id;

  public Animal(String name, String endangered) {
    this.name = name;
    this.endangered = endangered;
  }

  public String getName() {
    return name;
  }

  public String getEndangered() {
    return endangered;
  }

  public int getId() {
    return id;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, endangered) VALUES (:name, :endangered)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("endangered", this.endangered)
        .throwOnMappingFailure(false)
        .executeUpdate()
        .getKey();
    }
  }

  public void setEndangered(String endangered, String health, String age) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET endangered = :endangered, health = :health, age = :age WHERE id = :id";
      con.createQuery(sql)
        .addParameter("endangered", endangered)
        .addParameter("health", health)
        .addParameter("age", age)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  @Override
  public boolean equals(Object otherAnimal) {
    if (!(otherAnimal instanceof Animal)) {
      return false;
    } else {
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName());
    }
  }

  public static List<Animal> all() {
    String sql = "select * from animals";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(Animal.class);
    }
  }

  public static Animal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE id=:id";
      Animal blog = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Animal.class);
      return blog;
    }
  }
}
