import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with a fixed size
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                try
                {
                    System.out.println("Task " + taskId + " started");
                    System.out.println("Task " + taskId +
                            " executed by thread: " +
                            Thread.currentThread().getName());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        // Shutdown the thread pool when done
        executorService.shutdown();
    }
}
