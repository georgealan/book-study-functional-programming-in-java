package org.collections;

import java.util.function.Consumer;

import static org.collections.Folks.friends;

public class Iteration {
  public static void main(String[] args) {
    // Imperative and verbose versions
    System.out.println("Old way imperative versions");
    // Using for loop
    for (int i = 0; i < friends.size(); i++) {
      System.out.println(friends.get(i));
    }

    // Using for each
    for (String name : friends) {
      System.out.println(name);
    }

    System.out.println("//" + "START:INTERNAL_FOR_EACH_OUTPUT");

    friends.forEach(new Consumer<String>() { // Verbose, please don't do this never
      @Override
      public void accept(final String name) {
        System.out.println(name);
      }
    });
    System.out.println("//" + "END:INTERNAL_FOR_EACH_OUTPUT");

    // Declarative and verbose versions
    System.out.println("Better new way declarative versions");
    friends.forEach((final String name) -> System.out.println(name));

    friends.forEach((name) -> System.out.println(name));

    // One param don't need to be inside parentheses like above.
    friends.forEach(name -> System.out.println(name));

    // Method reference
    friends.forEach(System.out::println);
  }
}
