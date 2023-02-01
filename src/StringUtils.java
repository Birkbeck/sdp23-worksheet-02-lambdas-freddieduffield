import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringUtils {
    static String betterString(String s1, String s2, TwoStringPredicate lambda) {
        return lambda.test(s1, s2) ? s1 : s2;
    }

    static String betterEntry(String s1, String s2, TwoElementPredicate<String> lambda) {
        return lambda.test(s1, s2) ? s1 : s2;
    }

    static <T> List<T> allMatches(List<T> listToCheck, Predicate<T> matches) {
        List<T> listOfMatches = new ArrayList<>();
        listToCheck.forEach((element) -> {
            if (matches.test(element)) {
                listOfMatches.add(element);
            }
        });

        return listOfMatches;
    }

    static <T> List<T> transformedList(List<T> list, Function<T, T> function) {
        return list
                .stream()
                .map(function)
                .toList();
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

        List<Integer> numsToTest = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 999);
        List<Integer> numbersGreaterThan5 = StringUtils.allMatches(numsToTest, i -> i > 5);

        System.out.println(numbersGreaterThan5);

        List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
        List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
        List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);

        System.out.println(excitingWords);
        System.out.println(eyeWords);
        System.out.println(upperCaseWords);
    }
}
