public class DeadlockExample {
    private static final Object account = new Object();
    private static final Object transaction = new Object();

    public static void main(String[] args) {
        Thread debitCard = new Thread(() -> {
            synchronized (account) {
                System.out.println("Thread debitCard: " +
                        "Holding account object");
                try {
                    Thread.sleep(1000);
                    // Simulating some task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread debitCard: " +
                        "Before holding transaction object");
                synchronized (transaction) {
                    System.out.println("Thread debitCard: " +
                            "Holding account and transaction");
                }
            }
        });

        debitCard.setName("Debit Card Thread");

        Thread onlinePayment = new Thread(() -> {
            synchronized (transaction) {
                System.out.println("Thread onlinePayment: " +
                        "Holding transaction object");
                try {
                    Thread.sleep(1000); // Simulating some task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread onlinePayment: " +
                        "Before holding account object");
                synchronized (account) {
                    System.out.println("Thread onlinePayment: " +
                            "Holding transaction and account");
                }
            }
        });

        onlinePayment.setName("Online Payment Thread");

        debitCard.start();
        onlinePayment.start();

        // To detect deadlock,
        // periodically check for deadlock and print the deadlocked threads
        while (true) {
            if (debitCard.getState() == Thread.State.BLOCKED
                    && onlinePayment.getState() == Thread.State.BLOCKED) {
                System.out.println("Deadlocked threads: "
                        + debitCard.getName() + " and "
                        + onlinePayment.getName());
                break;
            }
        }
    }
}
