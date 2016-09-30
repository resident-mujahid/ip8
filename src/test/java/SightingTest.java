import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SightingTest {

  Sighting sighting1 = new Sighting("Henry", "Zone B", 1);
  Sighting sighting2 = new Sighting("Henrietta", "Zone A", 2);

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
    Sighting testSighting = sighting1;
    assertEquals(true, testSighting instanceof Sighting);
  }

  @Test
  public void getRangerName_personInstantiatesWithRangerName_Henry() {
    Sighting testSighting = sighting1;
    assertEquals("Henry", testSighting.getRangerName());
  }

  @Test
  public void getLocation_personInstantiatesWithLocation_ZoneB() {
    Sighting testSighting = sighting1;
    assertEquals("Zone B", testSighting.getLocation());
  }

  @Test
  public void getAnimalId_personInstantiatesWithAnimalId_1() {
    Sighting testSighting = sighting1;
    assertEquals(1, testSighting.getAnimalId());
  }

  @Test
  public void equals_returnsTrueIfNameAndLocationAreSame_true() {
    Sighting testSighting = sighting1;
    Sighting anotherSighting = sighting1;
    assertTrue(testSighting.equals(anotherSighting));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Sighting() {
    Sighting testSighting = sighting1;
    testSighting.save();
    assertEquals(true, Sighting.all().get(0).equals(testSighting));
  }

}
