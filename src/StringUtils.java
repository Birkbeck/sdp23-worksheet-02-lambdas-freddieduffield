import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class StringUtils {
    static String betterString(String s1, String s2, TwoStringPredicate lambda) {
        return lambda.test(s1, s2) ? s1 : s2;
    }

    static String betterEntry(String s1, String s2, TwoElementPredicate lambda) {
        return lambda.test(s1, s2) ? s1 : s2;
    }

    static List<String> allMatches(List<String> listToCheck, Predicate<String> matches) {
        List<String> listOfMatches = new ArrayList<>();

        for (String str: listToCheck) {
            if (matches.test(str)) {
                listOfMatches.add(str);
            }
        }
        return listOfMatches;
    }

    public static void main(String[] args) {
        TwoElementPredicate<String> betterTest1 = (s1, s2) -> s1.length() > s2.length();
        String best = betterEntry("Fred", "Sarai", betterTest1);
        System.out.println(best);
        best = betterEntry("Fred", "Sarai", (s1, s2) -> true);
        System.out.println(best);

        List<String> words = List.of(DataUtils.getNames());

        List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
        List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
        List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);

        System.out.println(shortWords);
        System.out.println(wordsWithB);
        System.out.println(evenLengthWords);
    }
}
