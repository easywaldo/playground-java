import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringProcessor {
    public static List<String> filter(List<String> input, Predicate<String> predicate) {
        return input.stream().filter(predicate::test).collect(Collectors.toList());
    }
}
