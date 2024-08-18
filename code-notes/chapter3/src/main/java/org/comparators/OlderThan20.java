package org.comparators;

import java.util.*;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.*;

// Using the collect Method and the Collectors Class

public class OlderThan20 {
  public static void main(String[] args) {
    final List<Person> people = Arrays.asList(
        new Person("George", 20),
        new Person("Vera", 21),
        new Person("Carlos", 21),
        new Person("Kakaroto", 35)
    );

    // Collecting people older than 20 years, using mutability and forEach
    List<Person> olderThan20 = new ArrayList<>();
    people.stream()
        .filter(person -> person.getAge() > 20)
        .forEach(person -> olderThan20.add(person)); // BAD IDEA
    System.out.println("People older than 20: \n" + olderThan20);

    /*
    * This version of code produces the same result as the previous version, but this version
    * has many benefits. We’re programming with intention and more expressively, clearly
    * indicating our goal of collecting the result into an ArrayList.
    * */
    List<Person> olderThan20_2 = people.stream()
        .filter(person -> person.getAge() > 20)
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // VERBOSE
    System.out.println("People older than 20_2: \n" + olderThan20_2);

    List<Person> olderThan20_3 = people.stream()
        .filter(person -> person.getAge() > 20)
        .collect(toList());
    System.out.println("People older than 20_3: \n" + olderThan20_3);

    // Use groupingBy to group people by their age.
    Map<Integer, List<Person>> peopleByAge = people.stream()
        .collect(groupingBy(Person::getAge));
    System.out.println("Grouped by age: \n" + peopleByAge);

    // Get only people's names, grouped by age
    Map<Integer, List<String>> nameOfPeopleByAge = people.stream()
        .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
    System.out.println("People grouped by age: \n" + nameOfPeopleByAge);

    // Group the names by their first character and get the oldest person in each group
    Comparator<Person> byAge = Comparator.comparing(Person::getAge);
    Map<Character, Optional<Person>> oldestPersonOfEachLetter = people.stream()
        .collect(groupingBy(person -> person.getName().charAt(0),
            reducing(BinaryOperator.maxBy(byAge))));
    System.out.println("Oldest person of each letter:");
    System.out.println(oldestPersonOfEachLetter);

    // Examples in documentation
    // Accumulate names into a TreeSet
    Set<String> set = people.stream()
        .map(Person::getName)
        .collect(toCollection(TreeSet::new));
    System.out.println("People collected in TreeSet \n" + set);

    // Convert elements to strings and concatenate them, separated by commas
    List<String> things = Arrays.asList(
        "George Alan Rufo",
        "Veralucia",
        "The day of the better code",
        "The most affordable IDE and productivity code tool"
    );
    String joined = things.stream()
        .map(Object::toString)
        .collect(joining(", "));
    System.out.println("\nConverting elements to strings and concatenate.");
    System.out.println(joined);

    final List<Employee> employees = Arrays.asList(
        new Employee(250.00, "Human Resources"),
        new Employee(4050.00, "Information Technology"),
        new Employee(100.00, "Painting"),
        new Employee(550.00, "Construction")
    );

    double total = employees.stream()
        .collect(summingDouble(Employee::getSalary));
    System.out.println("Total ammount of employe salary = " + total);


  }
}
