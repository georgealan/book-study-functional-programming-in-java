package org.comparators;

public class IterateString {
  private static void printChar(int aChar) {
    System.out.println((char)(aChar));
  }

  public static void main(String[] args) {
    final String str = "w00t";

    System.out.println("Lambda version");
    str.chars()
        .forEach(ch -> System.out.println(ch));

    System.out.println("\nMethod reference version");
    str.chars()
        .forEach(System.out::println);

    System.out.println("\nUsing static method inside class to convert to characters");
    str.chars()
        .forEach(IterateString::printChar);

    System.out.println("\nConvert to characters");
    str.chars()
        .mapToObj(ch -> Character.valueOf((char) ch))
        .forEach(System.out::println);

    System.out.println("\nFilter digits");
    str.chars()
        .filter(ch -> Character.isDigit(ch))
        .forEach(System.out::println);

    System.out.println("\nFilter digits and convert to char, lambda version");
    str.chars()
        .filter(ch -> Character.isDigit(ch))
        .forEach(ch -> printChar(ch));

    System.out.println("\nFilter digits and convert to char, method reference version");
    str.chars()
        .filter(Character::isDigit)
        .forEach(IterateString::printChar);
  }
}
