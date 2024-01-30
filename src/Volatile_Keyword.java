import java.lang.reflect.Field;
import java.lang.reflect.Method;

class SharedResource {
    private volatile boolean flag = false;
  //  private boolean flag = false; //without volatile

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }
}

public class Volatile_Keyword {

    public static void main(String[] args) throws Exception{

        SharedResource sharedResource = new SharedResource();

        // Thread 1
        new Thread(() -> {
            System.out.println("Thread 1 started");
            try {
                System.out.println("Thread 1 logic started");
                Thread.sleep(1000);
                System.out.println("Thread 1 logic completed");
                sharedResource.setFlag(true);
                System.out.println("Flag set by Thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Thread 2
        new Thread(() -> {
            System.out.println("Thread 2 started");
            while (!sharedResource.getFlag()) {
               // It will run until flag value is true
            }
            System.out.println("Thread 2 logic completed");
        }).start();



    }
}
