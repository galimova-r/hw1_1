//Умножение матрицы на число
import java.util.Scanner;

public class MatrixMultiplyNum {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Input lines: ");
        int lines = in.nextInt(); //кол-во строк
        System.out.print("Input cols: ");
        int col = in.nextInt();//кол-во столбцов
        System.out.print("Input a number: ");
        int num = in.nextInt(); //Чтобы получить введенное число, используется метод in.nextInt();, который возвращает введенное с клавиатуры целочисленное значение

        int Matrix[][] = new int[lines][col]; //создаем матрицу
        int MultMat[][] = new int[lines][col];//создаем матрицу для результата

        Matrix = fillMatrix(Matrix);//применяем функцию fillMatrix для матрицы, чтобы заполнить

        outputmatrix(Matrix); //применяем метод вывода матрицы


        //Умножаем матрицу на число
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < col; j++) {
                MultMat[i][j] = Matrix[i][j]*num;

            }
        }
        System.out.println("========");
        outputmatrix(MultMat);
    }

    //создаем метод для заполнения матриц
    static int[][] fillMatrix(int tempMat[][]) {
        for (int i = 0; i < tempMat.length; i++) {
            for (int j = 0; j < tempMat[i].length; j++) {
                tempMat[i][j] = (int) (Math.random() * 10); //ходим циклом по матрице и заполняем рандомными цифрами
            }
        }
        return tempMat;
    }

    //создадим метод для вывода матрицы
    static void outputmatrix(int tempMat[][]) {
        for (int i = 0; i < tempMat.length; i++) {
            for (int j = 0; j < tempMat[i].length; j++) {
                System.out.print(tempMat[i][j]+"\t");
            }
            System.out.println();//перенос строки
        }
    }
}


