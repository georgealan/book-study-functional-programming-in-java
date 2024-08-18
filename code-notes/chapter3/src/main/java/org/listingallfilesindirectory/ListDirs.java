package org.listingallfilesindirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListDirs {
  public static void main(String[] args) throws IOException {
    // Print only the subdirectories in th ecurrent directory instead of a listing
    // of all the files, we can use the filter method.
    Files.list(Paths.get("."))
        .filter(Files::isDirectory)
        .forEach(System.out::println);
  }
}
