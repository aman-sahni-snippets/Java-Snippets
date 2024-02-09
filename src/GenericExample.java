import java.util.List;

public class GenericExample {


    //multiple bounded type parameter.
    public static <T extends Comparable<T>> void
        findMax(List<T> list) {

        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        T max = list.get(0);

        for(int i=1; i<list.size(); i++)
        {
            T currentElement = list.get(i);
            //compareTo method belongs to Comparable Interface
            if(currentElement.compareTo(max) > 0)
            {
                max = currentElement;
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) {

        // Example usage
        List<Integer> intList = List.of(4, 8, 2, 10, 6);
        findMax(intList);

        List<Double> doubleList = List.of(4.1, 8.2, 2.3, 100.3, 698.8);
        findMax(doubleList);

    }
}
