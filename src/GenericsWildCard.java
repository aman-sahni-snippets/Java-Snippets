import java.util.*;

public class GenericsWildCard {

    // Method to print elements of a List<T>
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    // Method to print elements of a List<?>
    public static void printWildcardList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        System.out.println("Printing stringList:");
        printList(stringList);
        System.out.println("\nPrinting integerList:");
        printList(integerList);

        System.out.println("\nPrinting wildcard stringList:");
        printWildcardList(stringList);
        System.out.println("\nPrinting wildcard integerList:");
        printWildcardList(integerList);
    }
}
