import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    Semaphore sem;
    int id;
CountDownLatch LATCH;

    PassengerThread(Semaphore sem, int id, CountDownLatch LATCH){
        this.sem = sem;
        this.id = id;
        this.LATCH = LATCH;

    }
    public synchronized void run()  {
        try {
            sem.acquire();
            System.out.println("Пассажир " + id + " покупает билет");
            System.out.println("Пассажир "+ id + " садится в автобус");
            sem.release();
            LATCH.countDown();


        } catch (Exception npe) {
            npe.printStackTrace();
        }
    }
}


