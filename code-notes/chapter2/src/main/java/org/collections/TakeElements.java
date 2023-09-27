package org.collections;

import static org.collections.Folks.friends;

public class TakeElements {
  public static void main(String[] args) {
  /*
  terminating an iteration is serious business. Java provides at least two ways to exit
  an iteration before reaching the end of a collection—limit() and takeWhile(), where
  the latter was added in the JDK 9.

  To only process the first three values in a collection, use the limit() function, like so:
   */
  System.out.println("Begin of first iteraction");

  friends.stream()
      .limit(3)
      .map(String::toUpperCase)
      .forEach(System.out::println);

  System.out.println("End of first iteraction\n");

  /*
  If, instead of a specific number of elements, we want to terminate the iteration upon
  encountering an element that meets a certain criteria, we can use takeWhile(), as in the
  following code:
   */
  System.out.println("Begin of second iteraction");

  friends.stream()
      .takeWhile(name -> name.length() > 4)
      .map(String::toUpperCase)
      .forEach(System.out::println);
  /*
  The first element, Brian, meets that expectation but the second element, Nate, doesn’t
  and thus the iteration is terminated right away as we see from the output.

  Much like the skip() and dropWhile() functions, the limit() and takeWhile() methods also
  behave like a door. But instead of initially being shut, these methods behave like a door
  that is open and then shut forever when the given criteria isn’t met.
   */
  System.out.println("End of second iteraction");
  }
}
