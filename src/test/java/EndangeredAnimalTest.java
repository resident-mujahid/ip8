import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class EndangeredAnimalTest {

  EndangeredAnimal endangered1 = new EndangeredAnimal("Spotted Owl", "Yes", "ill", "young");
  EndangeredAnimal endangered2 = new EndangeredAnimal("Black Rhino", "Yes", "okay", "newborn");

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void endangeredAnimal_instantiatesCorrectly_true() {
    EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void getName_personInstantiatesWithName_Owl() {
    EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals("Spotted Owl", testEndangeredAnimal.getName());
  }

  @Test
  public void getEndangered_personInstantiatesWithEndangered_No() {
    EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals("Yes", testEndangeredAnimal.getEndangered());
  }

  @Test
  public void getEndangered_personInstantiatesWithAge_young() {
    EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals("young", testEndangeredAnimal.getAge());
  }

  @Test
  public void getEndangered_personInstantiatesWithHealth_ill() {
    EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals("ill", testEndangeredAnimal.getHealth());
  }

}
