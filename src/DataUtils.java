import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataUtils {
    static List<String> getCities() {
        return new ArrayList<>(Arrays.asList("London", "Cardiff", "Rome", "Birmingham", "Glasgow",
                "Belfast", "Dublin", "Madrid", "Oslo", "Warsaw", "Moscow", "Stockholm", "Bonn", "Berlin", "Paris",
                "Vienna", "Athens"));
    }

    static String[] getNames() {
        return new String[]{"Amy", "Bob", "Eddy", "Dave", "Fred", "Mary", "Jane", "Mo", "Julie", "abby", "Bo", "Roger",
                "peter", "Greg", "Steve", "Stu", "Richard", "Jules", "Dee", "Imran", "Ingrid", "Santos", "Raj", "patty", "Eve",
                "Tan", "Stan", "George", "Jerry", "Gustav", "Wendy", "Zoe", "Dan", "Doc", "Po", "Daz", "Cat", "ezzy", "Pru"};
    }

}
