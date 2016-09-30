import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class AnimalTest {

  Animal sighting1 = new Animal("Owl", "No");

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = sighting1;
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
  public void getName_personInstantiatesWithName_Owl() {
    Animal testAnimal = sighting1;
    assertEquals("Owl", testAnimal.getName());
  }

  @Test
  public void getEndangered_personInstantiatesWithEndangered_No() {
    Animal testAnimal = sighting1;
    assertEquals("No", testAnimal.getEndangered());
  }

}
