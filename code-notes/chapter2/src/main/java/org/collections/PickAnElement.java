package org.collections;

import java.util.List;
import java.util.Optional;

import static org.collections.Folks.friends;

public class PickAnElement {
  // Imperative and smelly version
  public static void pickNameImperative(final List<String> names, final String startingLetter) {
    String foundName = null;

    for (String name : names) {
      if (name.startsWith(startingLetter)) {
        foundName = name;
        break;
      }
    }
    System.out.print(String.format("A name starting with %s: ", startingLetter));

    if (foundName != null) {
      System.out.println(foundName);
    } else {
      System.out.println("No name found");
    }
  }

  // Declarative, functional version
  public static void pickNameDeclarative(final List<String> names, final String startLetter) {
    final Optional<String> foundName = names.stream()
            .filter(name -> name.startsWith(startLetter))
            .findFirst();

    System.out.println(String.format("A name starting with %s: %s",
        startLetter, foundName.orElse("No name found")));
  }

  public static void main(final String[] args) {
    pickNameImperative(friends, "N");
    pickNameImperative(friends, "Z");
    System.out.println();

    pickNameDeclarative(friends, "N");
    pickNameDeclarative(friends, "Z");

    /*
    For example, rather than providing an alternate value for the absent instance,
    we can ask Optional to run a block of code or a lambda expression only if a
    value is present, like so:
     */
    final Optional<String> foundName = friends.stream()
        .filter(name -> name.startsWith("N"))
        .findFirst();

    foundName.ifPresent(name -> System.out.println("Hello " + name));
  }
}
