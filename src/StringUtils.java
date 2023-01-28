import java.util.function.BiPredicate;

public class StringUtils {
    static String betterString(String s1, String s2, TwoStringPredicate lambda) {
        return lambda.test(s1, s2) ? s1 : s2;
    }

    static String betterEntry(String s1, String s2, TwoElementPredicate lambda) {
        return lambda.test(s1, s2) ? s1 : s2;
    }

    public static void main(String[] args) {
        TwoElementPredicate<String> betterTest1 = (s1, s2) -> s1.length() > s2.length();
        String best = betterEntry("Fred", "Sarai", betterTest1);
        System.out.println(best);
        best = betterEntry("Fred", "Sarai", (s1, s2) -> true);
        System.out.println(best);
    }
}
