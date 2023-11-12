package org.collections;

import static java.util.stream.Collectors.joining;
import static org.collections.Folks.friends;

public class PrintList {
  public static void main(String[] args) {
    System.out.println("// START FOREACH OUTPUT");
    for (String name : friends) {
      System.out.println(name + ", ");
    }
    System.out.println("// END FOREACH OUTPUT");
    // -------------------------------------------

    System.out.println("// START FOR OUTPUT");
    for (int i = 0; i < friends.size() - 1; i++) {
      System.out.print(friends.get(i) + ", ");
    }

    if (friends.size() > 0) {
      System.out.println(friends.get(friends.size() - 1));
    }
    System.out.println("// END FOR OUTPUT");
    // -------------------------------------------

    System.out.println("// START:JOIN_OUTPUT");
    System.out.println(String.join(", ", friends));
    System.out.println("// END:JOIN_OUTPUT");
    // -------------------------------------------

    System.out.println("// START:MAP_JOIN_OUTPUT");
    System.out.println(
        friends.stream()
            .map(String::toUpperCase)
            .collect(joining(", ")));
    System.out.println("// END:MAP_JOIN_OUTPUT");
  }
}
