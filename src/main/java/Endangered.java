import org.sql2o.*;
import java.util.List;

public class Endangered extends Animal {
  private String health;
  private String age;

  public static final String HEALTH_HEALTHY = "healthy";
  public static final String HEALTH_ILL = "ill";
  public static final String HEALTH_OKAY = "okay";

  public static final String AGE_NEWBORN = "newborn";
  public static final String AGE_YOUNG = "young";
  public static final String AGE_ADULT = "adult";

  public Endangered(String name, String endangered, String health, String age) {
    this.name = name;
    this.endangered = endangered;
    this.health = health;
    this.age = age;
  }

  public String getHealth() {
    return health;
  }

  public String getAge() {
    return age;
  }

}
