import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Streams_Example2 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6, 7, 8,8, 9, 10);

        // Intermediate Operations
        List<Integer> squaredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)            // Filter even numbers
                .map(n -> n * n)                    // Square each number
                .distinct()                         // Remove duplicates
                .peek(System.out::println)          // Peek into the stream (for debugging)
                .collect(Collectors.toList());     // Collect the results into a list

        System.out.println("Squared Numbers: " + squaredNumbers);

        // Terminal Operations
        long count = numbers.stream()
                .filter(n -> n > 5)// Filter numbers greater than 5
                .distinct()
                .count(); // Count the remaining numbers

        System.out.println("Count of Numbers > 5: " + count);

        int sum = numbers.stream()
                .mapToInt(Integer::intValue)        // Convert Integer stream to IntStream
                .sum();                             // Calculate the sum of numbers

       System.out.println("Sum of Numbers: " + sum);


    }
}