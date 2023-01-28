import java.util.function.BiPredicate;

public class StringUtils {
    static String betterString(String s1, String s2, TwoStringPredicate lambda) {
        return lambda.test(s1, s2) ? s1 : s2;
    }

    public static void main(String[] args) {
        TwoStringPredicate betterTest1 = (s1, s2) -> s1.length() > s2.length();
        String best = betterString("Fred", "Sarai", betterTest1);
        System.out.println(best);
        best = betterString("Fred", "Sarai", (s1, s2) -> true);
        System.out.println(best);
    }
}
