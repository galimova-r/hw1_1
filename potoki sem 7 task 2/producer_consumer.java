import java.util.ArrayList;
import java.util.Random;

public class producer_consumer {
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Thread thread = new Thread(new Producer(list));
        Thread run = new Thread(new Consumer(list));
        thread.start();
        run.start();
    }
}

class Producer extends Thread {
    private ArrayList<Integer> list;
    Random random = new Random();

    public Producer(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            if (list.size() < 10) {
                list.add(random.nextInt());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {
    private ArrayList<Integer> list;

    public Consumer(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            if (!list.isEmpty()) {
                System.out.println("Size is " + list.size());
                System.out.println(list.remove(list.size() - 1));
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}