package test.java.day1;

import main.java.day1.LocationInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationInputTest {
  @Test
  void correct_distance_calculated_when_file_exists() {
    int distance = LocationInput.calculateDistanceLocationForFile("src/test/resources/day_1.txt");
    assertEquals(11, distance);
  }

  @Test
  void zero_is_returned_when_file_not_found() {
    int distance = LocationInput.calculateDistanceLocationForFile("src/test/resources/day1.txt");
    assertEquals(0, distance);
  }

  @Test
  void zero_is_returned_when_empty_file() {
    int distance = LocationInput.calculateDistanceLocationForFile("src/test/resources/day_1_empty.txt");
    assertEquals(0, distance);
  }
}
