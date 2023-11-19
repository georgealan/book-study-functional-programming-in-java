package org.comparators;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Compare {
  public static void printPeople(final String message, final List<Person> people) {
    System.out.println(message);
    people.forEach(System.out::println);
  }

  public static void main(String[] args) {
    final List<Person> people = Arrays.asList(
      new Person("George", 34),
      new Person("Vera", 64),
      new Person("Carlos", 54),
      new Person("Goku", 100)
    );

  System.out.println("List of persons in age ascending order");
  List<Person> ascendingAge = people.stream()
      .sorted((person1, person2) -> person1.ageDifference(person2))
      .collect(toList());
  printPeople("Sorted in ascending order by age: ", ascendingAge);




  }
}
