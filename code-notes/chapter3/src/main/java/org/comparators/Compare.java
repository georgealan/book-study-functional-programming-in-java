package org.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class Compare {
  public static void printPeople(final String message, final List<Person> people) {
    System.out.println(message);
    people.forEach(System.out::println);
  }

  public static void main(String[] args) {
    final List<Person> people = Arrays.asList(
      new Person("Alice", 34),
      new Person("Demetrius", 64),
      new Person("Carlos", 54),
      new Person("Beatriz", 100)
    );

    System.out.println("List of persons in age ascending order");
    List<Person> ascendingAge = people.stream()
        .sorted((person1, person2) -> person1.ageDifference(person2))
        .collect(toList());
    printPeople("Sorted in ascending order by age: ", ascendingAge);

    printPeople("List of persons in age descending order, in other approach \n",
        people.stream()
            .sorted((person1, person2) -> person2.ageDifference(person1))
            .collect(toList()));

    System.out.println("using the Comparator method to reverse results");
    Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
    Comparator<Person> compareDescending = compareAscending.reversed();

    printPeople("\nSorted in ascending order by age: ",
        people.stream()
            .sorted(compareAscending)
            .collect(toList()));

    printPeople("\nSorted in descending order by age: ",
        people.stream()
            .sorted(compareDescending)
            .collect(toList()));

    // Now let's sort by name
    System.out.println("\nSorting by Name");
    printPeople("Sorted in ascending order by name: ",
        people.stream()
            .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
            .collect(toList()));

    // Print the youngest person
    people.stream()
        .min(Person::ageDifference)
        .ifPresent(youngestPerson -> System.out.println("The youngest are: " + youngestPerson));

    // Print the eldest person
    people.stream()
        .max(Person::ageDifference)
        .ifPresent(eldestPerson -> System.out.println("The eldest are: " + eldestPerson));

    // Sorting people using functions in Comparator interface
    final Function<Person, Integer> byAge = Person::getAge;
    final Function<Person, String> byName = Person::getName;

    printPeople("Sorted in ascending order by age and name: ",
        people.stream()
            .sorted(Comparator.comparing(byAge).thenComparing(byName))
            .collect(toList()));

  }
}
