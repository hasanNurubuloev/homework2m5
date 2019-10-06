import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int PESSENGER_COUNT = 100;
    public static CountDownLatch LATCH;

    public static void main(String[] args) throws InterruptedException {
        LATCH = new CountDownLatch(PESSENGER_COUNT );

        Semaphore sem = new Semaphore(4);

        for (int i = 1; i < 101; i++) {
            new PassengerThread(sem, i, LATCH).start();
        }
        LATCH.await();
        System.out.println("поехали");
    }
}
