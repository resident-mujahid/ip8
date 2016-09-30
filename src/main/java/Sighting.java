import java.util.Timer;
import org.sql2o.*;
import java.util.List;
import java.sql.Timestamp;

public class Sighting {
  private String ranger_name;
  private String location;
  private int animal_id;
  private Timestamp timestamp;
  private int id;

    //add animal_id after building it.
  public Sighting (String ranger_name, String location){
    this.ranger_name = ranger_name;
    this.location = location;
  }

  public String getRangerNamer() {
    return ranger_name;
  }

  public String getLocation() {
    return location;
  }

  public int getAnimalId() {
    return animal_id;
  }

  public int getId() {
    return id;
  }

  


}
