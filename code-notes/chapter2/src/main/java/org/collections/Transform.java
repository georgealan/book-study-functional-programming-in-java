package org.collections;

import java.util.ArrayList;
import java.util.List;
import static org.collections.Folks.friends;

public class Transform {
  public static void main(String[] args) {
    final List<String> uppercaseNames1 = new ArrayList<>();
    final List<String> uppercaseNames2 = new ArrayList<>();

    for (String name : friends) {
      uppercaseNames1.add(name.toUpperCase());
    }

    System.out.println(uppercaseNames1);

    friends.forEach(name -> uppercaseNames2.add(name.toUpperCase())); // BAD IDEA
    System.out.println(uppercaseNames2);
    /*
    We used the internal iterator, but that still required the empty list and the effort
    to add elements to it. Furthermore, we modified a shared mutable variable, the list,
    from within the lambda expression. That’s a bad idea as it makes it unsafe to parallelize
    this iteration if desired, and such code should be avoided.
     */

    // Declarative way
    friends.stream()
        .map(name -> name.toUpperCase())
        .forEach(name -> System.out.print(name + " "));
    System.out.println();

    /*
    The element types in the input don’t have to match the element types in the output collection.
    In this example, both the input and the output are a collection of strings. We could’ve passed
    to the map method a block of code that returned, for example, the number of characters in a
    given name. In this case, the input would still be a sequence of strings, but the output would
    be a sequence of numbers, as in the next example.
     */
    friends.stream()
        .map(name -> name.length())
        .forEach(count -> System.out.print(count + " ")); // Output is int

    System.out.println();

    /*
    We can nudge the code to be just a bit more concise by using a feature called method reference.
    The Java compiler will take either a lambda expression or a reference to a method where an
    implementation of a functional interface is expected.
    In the preceding example, the method reference was for an instance method. Method references
    can also refer to static methods and methods that take parameters.
     */
    friends.stream()
        .map(String::toUpperCase)
        .forEach(name -> System.out.println(name));

  }
}
