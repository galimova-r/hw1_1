import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomAdds {
    public static final int COUNT = 1000000;
    public static final int TAKE_COUNT = 100000;
    static Random random = new Random();

    public static void main(String[] args) {
        ArrayList<Long> as = new ArrayList<>();
        LinkedList<Long> ls = new LinkedList<>();
        Instant start = Instant.now();
        adder(as);
        Instant finish = Instant.now();
        Duration duration = Duration.between(start, finish);
        System.out.println("Добавление " + COUNT + " элементов типа Long в ArrayList произошло за " + duration.getSeconds() + "." + duration.getNano() + " секунд.");
        start = Instant.now();
        adder(ls);
        finish = Instant.now();
        duration = Duration.between(start, finish);
        System.out.println("Добавление " + COUNT + " элементов типа Long в LinkedList произошло за " + duration.getSeconds() + "." + duration.getNano() + " секунд.");
        start = Instant.now();
        take(as);
        finish = Instant.now();
        duration = Duration.between(start, finish);
        System.out.println("Взятие " + TAKE_COUNT + " элементов типа Long в ArrayList произошло за " + duration.getSeconds() + "." + duration.getNano() + " секунд.");
        start = Instant.now();
        take(ls);
        finish = Instant.now();
        duration = Duration.between(start, finish);
        System.out.println("Взятие " + TAKE_COUNT + " элементов типа Long в LinkedList произошло за " + duration.getSeconds() + "." + duration.getNano() + " секунд.");

    }

    public static void adder(List<Long> list) {
        for (int i = 0; i < COUNT; i++) {
            list.add(random.nextLong());
        }
    }

    public static void take(List<Long> list) {
        for (int i = 0; i < TAKE_COUNT; i++) {
            Long l = list.get(random.nextInt(COUNT - 1));
        }
    }
}
