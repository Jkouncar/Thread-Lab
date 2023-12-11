import java.util.PriorityQueue;
import java.util.Random;

public class CarQueue {

    private final Random ran = new Random();
    private final PriorityQueue<Integer> q = new PriorityQueue<>();
    private int out;

    public CarQueue() {
        initializeQueue();
    }

    private void initializeQueue() {
        for (int i = 0; i < 13; i++) {
            q.add(ran.nextInt(4));
        }
    }

    public void addToQueue() {
        Runnable r = () -> {
            try {
                for (int i = 0; i < 7; i++) {
                    q.add(ran.nextInt(4));
                }
            } finally {
                // Add any necessary cleanup code here
            }
        };

        Thread t = new Thread(r);
        t.start();
    }

    public int deleteQueue() {
        Runnable r = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Handle the exception if needed
            }

            try {
                if (q.size() < 20) {
                    for (int i = 0; i < 14; i++) {
                        q.add(ran.nextInt(4));
                    }
                } else if (!q.isEmpty()) {
                    out = q.remove();
                }
            } finally {
                // Add any necessary cleanup code here
            }
        };

        Thread t = new Thread(r);
        t.start();

        return out;
    }
}
