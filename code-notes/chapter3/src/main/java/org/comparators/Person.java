package org.comparators;

// Implementing the Comparator Interface
public class Person {
  private final String name;
  private final int age;

  public Person(final String theName, final int theAge) {
    name = theName;
    age = theAge;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int ageDifference(final Person other) {
    return age - other.age;
  }

  @Override
  public String toString() {
    return String.format("%s - %d", name, age);
  }
}
