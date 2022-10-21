import java.util.Arrays;

import static javax.swing.UIManager.get;

public class Vectors {
    public static void main(String[] args) {
        Vector[] vectors = Vector.massRand(3);

        System.out.println(vectors[0]);
        System.out.println(vectors[1]);
        System.out.println(vectors[0].length());
        System.out.println(vectors[0].scalarPr(vectors[1]));
        System.out.println(vectors[0].crossProduct(vectors[1]));
        System.out.println(vectors[0].cos(vectors[1]));
        System.out.println(vectors[0].plus(vectors[1]));
        System.out.println(vectors[0].minus(vectors[1]));
    }

    public static class Vector { //создаем класс вектор
        private double x;//объявляем координаты вектора
        private double y;
        private double z;

        // С тремя параметрами
        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        // метод, вычисляющий длину вектора
        public double length() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        // метод, вычисляющий скалярное произведение
        public double scalarPr(Vector vector) {
            return x * vector.x + y * vector.y + z * vector.z;
        }

        // метод, вычисляющий векторное произведение с другим вектором
        public Vector crossProduct(Vector vector) {
            return new Vector(
                    y * vector.z - z * vector.y,
                    z * vector.x - x * vector.z,
                    x * vector.y - y * vector.x);
        }

        // Косинус между двумя векторами
        public double cos(Vector vector) {


            return scalarPr(vector) / (length() * vector.length());
        }

        //метод для суммы
        public Vector plus(Vector vector) {
            return new Vector( //возвращается сложенный вектор
                    x + vector.x,
                    y + vector.y,
                    z + vector.z
            );
        }
        //метод для разницы
        public Vector minus(Vector vector) {
            return new Vector(//возвращается вектор разницы
                    x - vector.x,
                    y - vector.y,
                    z - vector.z
            );
        }
        //статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N
        public static Vector[] massRand(int n){
            Vector[] vectors = new Vector[n];//создается новый массив размером n
            for(int i =0; i < n; i++){//проходимся по массиву
                vectors[i] = new Vector(Math.random(), Math.random(), Math.random());// проходя по массиву заполняем его случайными координатами векторов
            }
            return vectors;
        }

        public String toString() {
            return "Вектор {" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }


    }
}