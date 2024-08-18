package org.listingallfilesindirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {
  public static void main(String[] args) throws IOException {
    Files.list(Paths.get(".\\src\\main\\java\\org\\listingallfilesindirectory"))
        .forEach(System.out::println);
  }
}
