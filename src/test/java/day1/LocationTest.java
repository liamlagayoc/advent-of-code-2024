package test.java.day1;

import main.java.day1.Location;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {
  @Test
  void location_has_a_list_of_ids() {
    List<Integer> ids = List.of(7, 2, 3, 4);
    Location location = new Location(ids);
    assertEquals(ids, location.getIds());
  }

  @Test
  void locations_are_sorted_by_smallest_amount() {
    List<Integer> ids = List.of(7, 2, 3, 4);
    Location location = new Location(ids);
    assertEquals(List.of(2, 3, 4, 7), location.sortBySmallest());
  }

  @Test
  void calculates_correct_similarity_score_when_value_is_in_list() {
    List<Integer> integerList = List.of(3, 4);
    List<Integer> ids = List.of(7, 2, 3, 4);
    Location location = new Location(ids);
    assertEquals(3, location.calculateSimilarityScore(3, integerList));
  }

  @Test
  void calculates_correct_similarity_score_when_value_is_not_in_list() {
    List<Integer> integerList = List.of(3, 4);
    List<Integer> ids = List.of(7, 2, 3, 4);
    Location location = new Location(ids);
    assertEquals(0, location.calculateSimilarityScore(5, integerList));
  }

  @Test
  void calculates_correct_similarity_score_when_value_is_in_list_multiple_times() {
    List<Integer> integerList = List.of(3, 4, 3, 3);
    List<Integer> ids = List.of(7, 2, 3, 4);
    Location location = new Location(ids);
    assertEquals(9, location.calculateSimilarityScore(3, integerList));
  }
}