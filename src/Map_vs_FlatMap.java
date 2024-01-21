import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Map_vs_FlatMap {
    public static void main(String[] args) {

        //Map
        List<String> words = Arrays.asList("Hello", "World");

        // Using map to convert each word to its uppercase form
        List<String> uppercasedWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Using map: " + uppercasedWords);

        //Flat Map
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        // Using flatMap to flatten the nested list
        List<Integer> flattenedList = nestedList.stream()
                .flatMap(List::stream)
                .map(n -> n*2)
                .collect(Collectors.toList());

        System.out.println("Flattened List: " + flattenedList);

    }
}