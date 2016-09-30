import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class EndangeredAnimalTest {

  EndangeredAnimal sighting1 = new EndangeredAnimal("Owl", "No", "ill", "young");

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void endangeredAnimal_instantiatesCorrectly_true() {
    EndangeredAnimal testEndangeredAnimal = sighting1;
    assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void getName_personInstantiatesWithName_Owl() {
    EndangeredAnimal testEndangeredAnimal = sighting1;
    assertEquals("Owl", testEndangeredAnimal.getName());
  }

  @Test
  public void getEndangered_personInstantiatesWithEndangered_No() {
    EndangeredAnimal testEndangeredAnimal = sighting1;
    assertEquals("No", testEndangeredAnimal.getEndangered());
  }

  @Test
  public void getEndangered_personInstantiatesWithAge_young() {
    EndangeredAnimal testEndangeredAnimal = sighting1;
    assertEquals("young", testEndangeredAnimal.getAge());
  }

  @Test
  public void getEndangered_personInstantiatesWithHealth_ill() {
    EndangeredAnimal testEndangeredAnimal = sighting1;
    assertEquals("ill", testEndangeredAnimal.getHealth());
  }

}
