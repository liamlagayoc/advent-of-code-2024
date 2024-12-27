package main.java.day1;

import main.java.utils.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LocationInput {
  public static int calculateDistanceLocationForFile(String filename) {
    List<Integer> locationListOne = new ArrayList<>();
    List<Integer> locationListTwo = new ArrayList<>();
    try {
      List<String> fileLines = FileUtils.readLines(filename);
      IntStream.range(0, fileLines.size())
          .forEach(index -> {
            List<String> values = Arrays.stream(fileLines.get(index)
                .split(" ")).filter(str -> !str.isEmpty()).toList();
            locationListOne.add(Integer.valueOf(values.getFirst()));
            locationListTwo.add(Integer.valueOf(values.getLast()));
          });

      Location locationOne = new Location(locationListOne);
      Location locationTwo = new Location(locationListTwo);

      DistanceCalculator calculator = new DistanceCalculator();
      return calculator.calculateTotalLocationDistance(locationOne, locationTwo);
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + filename + ". Error: " + e);
    }
    return 0;
  }
}
