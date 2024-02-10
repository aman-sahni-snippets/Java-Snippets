import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVSFailSafe {
    public static void main(String[] args) {

        //Fail Fast Scenario
        //ArrayList, HashMap, etc. are Fail-Fast.
        List<Integer> listPlans =
                new ArrayList<>();

        listPlans.add(10000);
        listPlans.add(20000);
        listPlans.add(30000);

        Iterator<Integer> iteratorPlans =
                listPlans.iterator();


        while (iteratorPlans.hasNext()) {
            System.out.println("Rating is: "
                    + iteratorPlans.next());
          //  listPlans.add(1); it will throw runtime exception
        }



        // Using a thread-safe ConcurrentHashMap,CopyOnWriteArrayList
        //No truly Fail-Safe iterator.
        // Better to call Weakly Consistent.
        List<Integer> listRating =
                new CopyOnWriteArrayList<>();
        listRating.add(4);
        listRating.add(5);
        listRating.add(3);

        // Using a fail-safe iterator
        Iterator<Integer> iteratorRating =
                listRating.iterator();

        while (iteratorRating.hasNext()) {
            System.out.println("Rating is: "
             + iteratorRating.next());
            listRating.add(1);
        }

        Iterator<Integer> iteratorRating1 =
                listRating.iterator();

        while (iteratorRating1.hasNext()) {
            System.out.println("Rating is: "
                    + iteratorRating1.next());
            listRating.add(1);
        }

    }
}
