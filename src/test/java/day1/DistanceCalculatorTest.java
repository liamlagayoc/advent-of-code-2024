package test.java.day1;

import main.java.day1.DistanceCalculator;
import main.java.day1.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceCalculatorTest {
  private Location leftLocations;
  private Location rightLocations;
  private DistanceCalculator classUnderTest;

  @BeforeEach
  void set_up() {
    classUnderTest = new DistanceCalculator();
  }

  @Test
  void return_no_distance_when_no_lists_provided() {
    leftLocations = new Location(List.of());
    rightLocations = new Location(List.of());
    assertEquals(0, classUnderTest.calculateTotalLocationDistance(leftLocations, rightLocations));
  }

  @Test
  void return_no_distance_when_right_locations_not_provided() {
    leftLocations = new Location(List.of(2));
    rightLocations = new Location(List.of());
    assertEquals(0, classUnderTest.calculateTotalLocationDistance(leftLocations, rightLocations));
  }

  @Test
  void distance_correctly_calculated_for_single_list_values() {
    leftLocations = new Location(List.of(4));
    rightLocations = new Location(List.of(2));
    assertEquals(2, classUnderTest.calculateTotalLocationDistance(leftLocations, rightLocations));
  }

  @Test
  void absolute_distance_correctly_calculated_for_single_list_values() {
    leftLocations = new Location(List.of(2));
    rightLocations = new Location(List.of(4));
    assertEquals(2, classUnderTest.calculateTotalLocationDistance(leftLocations, rightLocations));
  }

  @Test
  void distance_is_zero_when_lists_contain_single_equal_values() {
    leftLocations = new Location(List.of(4));
    rightLocations = new Location(List.of(4));
    assertEquals(0, classUnderTest.calculateTotalLocationDistance(leftLocations, rightLocations));
  }

  @Test
  void multiple_distances_are_correctly_calculated() {
    leftLocations = new Location(List.of(3, 4, 2, 1, 3, 3));
    rightLocations = new Location(List.of(4, 3, 5, 3, 9, 3));
    assertEquals(11, classUnderTest.calculateTotalLocationDistance(leftLocations, rightLocations));
  }
}
