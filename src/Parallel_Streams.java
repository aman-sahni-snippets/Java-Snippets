import java.lang.reflect.Array;
import java.util.Arrays;

public class Parallel_Streams {
    public static void main(String[] args) {

        int[] intArray = new int[1000000]; //1 Million Size
        Arrays.fill(intArray,2);

       // Calculate the sum of squares using sequential stream
       long StartTime = System.currentTimeMillis();

       long sum = Arrays.stream(intArray)
               .mapToLong(num -> num * num)
               .sum();

        long EndTime = System.currentTimeMillis();

        System.out.println(EndTime - StartTime);

        // Calculate the sum of squares using parallel stream

        long StartTimeP = System.currentTimeMillis();

        long sum_p = Arrays.stream(intArray)
                .parallel() //run in parallel
                .mapToLong(num -> num * num)
                .sum();

        long EndTimeP = System.currentTimeMillis();

        System.out.println(EndTimeP - StartTimeP);


    }
}