import java.util.Arrays;
import java.util.Comparator;

public class Outline {
  public static void main(String... args) { // varargs alternative to String[]
    Integer[] intArray = {1,7,3,4,8,2};
    System.out.println(Arrays.asList(intArray));
    String[] names = DataUtils.getNames();
//    length
    Arrays.sort(names, Comparator.comparingInt(String::length));
    System.out.println(Arrays.asList(names));
//  reverse length
    Arrays.sort(names, (s1, s2) -> s2.length() - s1.length());
    System.out.println(Arrays.asList(names));
//  first character
    Arrays.sort(names, Comparator.comparingInt(s -> s.charAt(0)));
    System.out.println(Arrays.asList(names));
//  Strings that contain "e" first, everything else second.
    Arrays.sort(names, (s1, s2) -> s2.contains("e") ? 1 : s1.contains("e") ? -1 : 0);
    System.out.println(Arrays.asList(names));

    Arrays.sort(names, Outline::eChecker);
    System.out.println(Arrays.asList(names));

    Arrays.sort(names, Comparator.comparingInt(Outline::eChecker));
    System.out.println(Arrays.asList(names));
  }

  static char firstLetter(String s) {
    return s.charAt(0);
  }

  static int eChecker(String s1, String s2) {
    if (s1.contains("e")) {
      if (s2.contains("e")) {
        return -1;
      } else {
        return 1;
      }
    }
    return 0;
  }
  static int eChecker(String s) {
   return s.contains("e") ? 0 : 1;
  }
}
