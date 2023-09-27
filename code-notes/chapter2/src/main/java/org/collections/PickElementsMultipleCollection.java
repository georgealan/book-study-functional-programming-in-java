package org.collections;

import java.util.function.Predicate;

import static org.collections.Folks.*;

public class PickElementsMultipleCollection {
  public static void main(String[] args) {
    /*
    Lambda expressions are deceivingly concise and it’s easy to carelessly duplicate them in code.
    Let’s see how easy it is to fall into the duplication trap when using lambda expressions.
     */
    final long counterFriendsStartN =
        friends.stream()
            .filter(name -> name.startsWith("N"))
            .count();

    final long counterEditorsStartN =
        editors.stream()
            .filter(name -> name.startsWith("N"))
            .count();

    final long counterComradesStartN =
        comrads.stream()
            .filter(name -> name.startsWith("N"))
            .count();

    System.out.println(counterFriendsStartN);
    System.out.println(counterEditorsStartN);
    System.out.println(counterComradesStartN);

    /*
    The lambda expressions made the code concise, but quietly led to duplicate code.
    In the previous example, one change to the lambda expression needs to change in
    more than one place—that’s a no-no. Fortunately, we can assign lambda expressions
    to variables and reuse them, just like with objects.
     */

    // Refactored code
    final Predicate<String> startsWithN = name -> name.startsWith("N");

    final long counterFriendsStartN2 =
        friends.stream()
            .filter(startsWithN)
            .count();

    final long counterEditorsStartN2 =
        editors.stream()
            .filter(startsWithN)
            .count();

    final long counterComradesStartN2 =
        comrads.stream()
            .filter(startsWithN)
            .count();

    System.out.println(counterFriendsStartN2);
    System.out.println(counterEditorsStartN2);
    System.out.println(counterComradesStartN2);
  }
}
