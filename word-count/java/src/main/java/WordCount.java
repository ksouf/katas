import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class WordCount {

    public String count(String words) {
        String[] wordsArray = words.split(",");

        List<String> result = Arrays.stream(wordsArray)
                .distinct()
                .map(toWordAndCount(wordsArray))
                .collect(toList());


        return result.stream()
                .reduce("", (previous, next) -> previous + "\n" + next)
                .replaceFirst("\n", "");
    }

    private Function<String, String> toWordAndCount(String[] wordsArray) {
        return word -> {
            long count = Arrays.stream(wordsArray)
                    .filter(word::equals)
                    .count();
            return word + " " + count;
        };
    }
}