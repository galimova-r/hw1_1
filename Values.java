import java.util.Random;

public class Values {
    private int vals[]; // значения
    private int weights[]; // веса
    private int positions[]; // позиция весов в Рандоме
    private Random random = new Random(); // рандом
    private int count; // максимальное значение рандома + 1

    public Values(int [] vals, int[] weights) {
        this.vals = vals;
        this.weights = weights;
        this.positions = writePositions(weights);
    }

    /**                                                            [][  ][    ]
     * Создаём пространство для выбора случайного значения рандомом * * * * * *
     * @param weights
     */
    private int[] writePositions(int[] weights) {
        int[] positions = new int[weights.length];
        this.count = 0;
        for (int i = 0; i < weights.length; i++) {
            this.count += weights[i]; // присваиваем максимально возможное значение Рандома  + 1
            positions[i] = this.count;
        }
        return positions;
    }

    /**
     * Получаем случайный элемент массива vals согласно его весу
     */
    static int temp = 0;
    public int getValue() {
        return vals[getValsPosition(random.nextInt(count))];
//        int gotCount = random.nextInt(count); // возвращает (псевдо)случайное число от 0 (включительно) до значения count (исключительно)
//        int position = getValsPosition(temp++); // получаем нужную позицию для массива vals[]
//        return vals[position]; // возвращаем значение
    }

    /**
     * Принимает рандомное число, полученное ранее и возвращает номер ячейки, которая подходит под это рандомное число
     * @param gotCount
     * @return
     */
    private int getValsPosition(int gotCount) {
        int result = 0;
        System.out.println("random - " + gotCount);
        if (gotCount >= positions[0]) {
            for (int i = 1; i < positions.length; i++) {
                if (gotCount < positions[i] && gotCount >= positions[i - 1]) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
}