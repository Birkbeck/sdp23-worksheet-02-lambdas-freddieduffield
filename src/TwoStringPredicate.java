import java.util.function.BiPredicate;

@FunctionalInterface
public interface TwoStringPredicate extends BiPredicate<String, String> {
    @Override
    boolean test(String s1, String s2);
}
