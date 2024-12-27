package main.java.day1;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class DistanceCalculator {
  public int calculateTotalLocationDistance(Location locationSetOne, Location locationSetTwo) {
    if (locationSetOne.getIds().isEmpty() || locationSetTwo.getIds().isEmpty()) {
      return 0;
    }

    AtomicInteger distance = new AtomicInteger();
    List<Integer> locationListOne = locationSetOne.sortBySmallest();
    List<Integer> locationListTwo = locationSetTwo.sortBySmallest();

    IntStream.range(0, locationListOne.size())
        .forEach(i -> distance.addAndGet(
            calculateLocationDistance(locationListOne.get(i), locationListTwo.get(i))));

    return distance.get();
  }

  private int calculateLocationDistance(int locationOne, int locationTwo) {
    return Math.abs(locationTwo - locationOne);
  }
}
