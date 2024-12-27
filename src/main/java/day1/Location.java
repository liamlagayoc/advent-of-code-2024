package main.java.day1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Location {
  private List<Integer> ids;

  public List<Integer> sortBySmallest() {
    return ids.stream().sorted().toList();
  }

  public int calculateSimilarityScore(int value, List<Integer> listToCompare) {
    int count = listToCompare.stream().filter(x -> x == value).toList().size();
    return value * count;
  }
}
