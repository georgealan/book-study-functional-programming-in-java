package org.collections;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.collections.Folks.friends;

public class PickDifferentNames {
  public static Predicate<String> checkIfStartsWith(final String letter) {
    return name -> name.startsWith(letter);
  }

  public static void main(String[] args) {
    // These two predicates are mere duplicates, with only the letter they use being different.
    System.out.println("First approach \n");
    final Predicate<String> startsWithN = name -> name.startsWith("N");
    final Predicate<String> startsWithB = name -> name.startsWith("B");

    final long countFriendsStartN =
        friends.stream()
            .filter(startsWithN)
            .count();

    final long countFriendsStartB =
        friends.stream()
            .filter(startsWithB)
            .count();

    System.out.println(countFriendsStartN);
    System.out.println(countFriendsStartB + "\n");

    // Second approach code refactored
    System.out.println("Second approach \n");
    final long countFriendsStartN2 =
        friends.stream()
            .filter(checkIfStartsWith("N"))
            .count();

    final long countFriendsStartB2 =
        friends.stream()
            .filter(checkIfStartsWith("B"))
            .count();

    System.out.println(countFriendsStartN2);
    System.out.println(countFriendsStartB2 + "\n");

    // Second approach code refactored
    System.out.println("Third approach first code \n");

    // Function<Type, Return>
    final Function<String, Predicate<String>> startsWithLetter1 =
        (String letter) -> {
          Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
          return checkStarts;
        };

    final long countFriendsStartN3 =
        friends.stream()
            .filter(startsWithLetter1.apply("N"))
            .count();

    final long countFriendsStartB3 =
        friends.stream()
            .filter(startsWithLetter1.apply("B"))
            .count();

    System.out.println(countFriendsStartN3);
    System.out.println(countFriendsStartB3 + "\n");

    System.out.println("Third approach second code \n");

    // We can omit Predicate declaration
    final Function<String, Predicate<String>> startsWithLetter2 =
        (String letter) -> (String name) -> name.startsWith(letter);

    final long countFriendsStartN4 =
        friends.stream()
            .filter(startsWithLetter2.apply("N"))
            .count();

    final long countFriendsStartB4 =
        friends.stream()
            .filter(startsWithLetter2.apply("B"))
            .count();

    System.out.println(countFriendsStartN4);
    System.out.println(countFriendsStartB4 + "\n");

    System.out.println("Third approach third code \n");
    // We can omit the type too.
    final Function<String, Predicate<String>> startsWithLetter3 =
        letter -> name -> name.startsWith(letter);

    final long countFriendsStartN5 =
        friends.stream()
            .filter(startsWithLetter3.apply("N"))
            .count();

    final long countFriendsStartB5 =
        friends.stream()
            .filter(startsWithLetter3.apply("B"))
            .count();

    System.out.println(countFriendsStartN5);
    System.out.println(countFriendsStartB5 + "\n");
  }
}
