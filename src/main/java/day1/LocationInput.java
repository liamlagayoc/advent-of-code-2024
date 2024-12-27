package main.java.day1;

import main.java.utils.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class LocationInput {
  private final List<Integer> locationListOne = new ArrayList<>();
  private final List<Integer> locationListTwo = new ArrayList<>();

  public LocationInput(String filename) {
    loadValues(filename);
  }

  public int calculateDistanceLocationForFile() {
    if(locationListOne.isEmpty() || locationListTwo.isEmpty()) {
      return 0;
    }

    Location locationOne = new Location(locationListOne);
    Location locationTwo = new Location(locationListTwo);

    DistanceCalculator calculator = new DistanceCalculator();
    return calculator.calculateTotalLocationDistance(locationOne, locationTwo);
  }

  public int calculateSimilarityScoreForFile() {
    if(locationListOne.isEmpty() || locationListTwo.isEmpty()) {
      return 0;
    }

    Location locationOne = new Location(locationListOne);
    Location locationTwo = new Location(locationListTwo);

    AtomicInteger similarityScore = new AtomicInteger();

    IntStream.range(0, locationOne.getIds().size())
        .forEach(index -> {
          int value = locationOne.getIds().get(index);

          similarityScore.addAndGet(
              locationOne.calculateSimilarityScore(value, locationTwo.getIds()));
        });

    return similarityScore.get();
  }

  private void loadValues(String filename) {
    try {
      List<String> fileLines = FileUtils.readLines(filename);
      IntStream.range(0, fileLines.size())
          .forEach(index -> {
            List<String> values = Arrays.stream(fileLines.get(index)
                .split(" ")).filter(str -> !str.isEmpty()).toList();
            locationListOne.add(Integer.valueOf(values.getFirst()));
            locationListTwo.add(Integer.valueOf(values.getLast()));
          });

    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + filename + ". Error: " + e);
    }
  }
}
