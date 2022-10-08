import java.util.*;

public class NoDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(1);
        ints.add(3);
        ints.add(2);
        ints.add(3);
        ints.add(10);
        ArrayList<Integer> result = deleteDuplicates(ints);
        System.out.println();//точка остановки
    }

    public static ArrayList deleteDuplicates(ArrayList list) {
        ArrayList result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!result.contains(list.get(i))) {
                result.add(list.get(i));
            }
        }
        return result;
    }
}
