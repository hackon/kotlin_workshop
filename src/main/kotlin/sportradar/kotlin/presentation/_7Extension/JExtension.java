package sportradar.kotlin.presentation._7Extension;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JExtension {
  public static void main(String[] args) {
    System.out.println(toTitleCase("This should all become title case"));
    System.out.println(isTheSame("The same", "The same"));
  }

  static String toTitleCase(String value) {
    return Arrays.stream(value.split(" "))
        .map(it -> it.substring(0, 1).toUpperCase() + it.substring(1))
        .collect(Collectors.joining(" "));
  }

  static boolean isTheSame(String v1, String v2) {
    return v1.equals(v2);
  }
}
