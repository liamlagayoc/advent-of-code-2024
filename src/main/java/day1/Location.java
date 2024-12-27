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
}
