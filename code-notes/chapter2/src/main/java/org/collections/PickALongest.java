package org.collections;

import java.util.Comparator;
import java.util.Optional;

import static org.collections.Folks.friends;

public class PickALongest {
  // Reducing a Collection to a Single Value.
  public static void main(String[] args) {
    System.out.println("Total number of characters in all names: " +
    friends.stream()
        .mapToInt(name -> name.length())
        .sum());

    final Optional<String> aLongName =
        friends.stream()
            .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
    aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));

    final Optional<String> longName =
        friends.stream()
            .max(Comparator.comparing(String::length));
    longName.ifPresent(name -> System.out.println(String.format("Other longest name: %s", name)));

    final String steveOrLonger =
        friends.stream()
            .reduce("Steve", (name1, name2) ->
                name1.length() >= name2.length() ? name1 : name2);
    System.out.println(steveOrLonger);
  }
}

