package org.collections;

import static org.collections.Folks.friends;

public class SkipElements {
  public static void main(String[] args) {
    /*
    Given a collection of values, if we want to skip processing a certain number of
    values or until a certain condition is met, we may use the continue statement
    along with the if statement in the traditional for loop. In the functional style,
    we don’t use if or continue. Instead, we can control the iteration using the skip()
    or dropWhile() functions.

    If you like to skip the first four values in the collection and only process the rest,
    pass the number of values you want to skip to the skip() function, like so:
     */
    friends.stream()
        .skip(4)
        .map(String::toUpperCase)
        .forEach(System.out::println);

    /*
    If, instead of skipping a certain number of values, you want to skip values until an
    element that meets a certain condition is encountered, use dropWhile(), which was
    introduced in the JDK 9.
     */
    friends.stream()
        .dropWhile(name -> name.length() > 4)
        .map(String::toUpperCase)
        .forEach(System.out::println);

    /*
    Whereas filter() works like a garage gate that opens or shuts for each approaching
    car, skip() and dropWhile() work more like a door that is closed initially, swings open,
    and then stays open. In the previous code, since the first element of the collection,
    Brian, has a length greater than four, it is skipped or dropped from further processing.
    The next element, Nate, is of length 4, and thus processing starts from that element.
    Even though the element Scott is greater than four letters in length, it is processed
    since the door, so to say, has already swung open.
     */

  }
}
