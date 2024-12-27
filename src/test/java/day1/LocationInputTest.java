package test.java.day1;

import main.java.day1.LocationInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationInputTest {
  @Test
  void correct_distance_calculated_when_file_exists() {
    LocationInput input = new LocationInput("src/test/resources/day_1.txt");
    int distance = input.calculateDistanceLocationForFile();
    assertEquals(11, distance);
  }

  @Test
  void zero_is_returned_when_file_not_found() {
    LocationInput input = new LocationInput("src/test/resources/day1.txt");
    int distance = input.calculateDistanceLocationForFile();
    assertEquals(0, distance);
  }

  @Test
  void zero_is_returned_when_empty_file() {
    LocationInput input = new LocationInput("src/test/resources/day_1_empty.txt");
    int distance = input.calculateDistanceLocationForFile();
    assertEquals(0, distance);
  }

  @Test
  void correct_similarity_score_calculated_when_file_exists() {
    LocationInput input = new LocationInput("src/test/resources/day_1.txt");
    int similarityScore = input.calculateSimilarityScoreForFile();
    assertEquals(31, similarityScore);
  }

  @Test
  void correct_similarity_score_calculated_when_file_does_not_exist() {
    LocationInput input = new LocationInput("src/test/resources/day1.txt");
    int similarityScore = input.calculateDistanceLocationForFile();
    assertEquals(0, similarityScore);
  }

  @Test
  void correct_similarity_score_calculated_when_file_is_empty() {
    LocationInput input = new LocationInput("src/test/resources/day_1_empty.txt");
    int similarityScore = input.calculateDistanceLocationForFile();
    assertEquals(0, similarityScore);
  }
}
