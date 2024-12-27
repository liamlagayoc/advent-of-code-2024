package main.java.day1;

public class Main {
  public static void main(String[] args) {
    LocationInput input = new LocationInput("src/main/resources/Day1.txt");
    System.out.println("Total Distance Calculated (Day 1 Part 1): " +
        input.calculateDistanceLocationForFile());

    System.out.println("Total Similarity Score Calculated (Day 1 Part 2): " +
        input.calculateSimilarityScoreForFile());
  }
}
