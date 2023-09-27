package org.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.collections.Folks.friends;

public class PickElements {
  public static void main(String[] args) {
    final List<String> startsWithN = new ArrayList<>();

    // Imperative old way
    for (String name : friends) {
      if (name.startsWith("N")) {
        startsWithN.add(name);
      }
    }
    System.out.println(String.format("Found %d names", startsWithN.size()));

    // Declarative new way
    final List<String> startsWithN2 =
      friends.stream()
          .filter(name -> name.startsWith("N"))
          .collect(Collectors.toList());

    System.out.println(String.format("Found %d names", startsWithN2.size()));
    /*
    the list created by the Collectors.toList() may be mutated later on. If you want the
    iteration to create an immutable list, then instead, use Collectors.toUnmodifiableList()
    (added in the JDK 10) or the toList() method (added in the JDK 16) instead of
    collect(Collectors.toList()).
    See these below:
     */

    // Immutable lists
    final List<String> startsWithN3 =
      friends.stream()
          .filter(name -> name.startsWith("N"))
          .collect(Collectors.toUnmodifiableList());
    System.out.println(String.format("Found %d names", startsWithN3.size()));

    final List<String> startsWithN4 =
        friends.stream()
            .filter(name -> name.startsWith("N"))
            .toList();
    System.out.println(String.format("Found %d names", startsWithN4.size()));
  }
}
