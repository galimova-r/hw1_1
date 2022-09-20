import java.util.Scanner;

public class MatrixStepen {
    public static void main(String[] args) {
        int oneMat[][] = new int[3][3]; //создаем матрицу 1
        int twoMat[][] = new int[3][3];//создаем матрицу 2
        int resMat[][] = new int[3][3];//создаем матрицу для результата

        oneMat = fillMatrix(oneMat);//применяем функцию fillMatrix для 1 матрицы
        twoMat = oneMat;
        outputmatrix(oneMat); //применяем метод вывода матрицы
        System.out.println("^^^");

        int n = 3;//Показатель степени
        int power = 1;// счетчик показателей
        int res2Mat[][] = new int[3][3];//пустая матрица для обнуления

        System.out.println(n);
        //умножаем матрицы между собой по формуле cij = ai1 · b1j + ai2 · b2j + ... + ain · bnj

        while (power < n) { //Перемножаем пока счетчик меньшк показателя
            for (int i = 0; i < oneMat.length; i++) {//умножаем две матрицы
                for (int u = 0; u < twoMat[0].length; u++) {
                    for (int j = 0; j < twoMat.length; j++) {

                        resMat[i][u] += twoMat[i][j] * oneMat[j][u];


                    }
                }
            }

            twoMat = resMat; //Присваиваем второй матрице результат перемножения, чтобы потом матрица умножалась на результат
            resMat = res2Mat; //Обнуляем результат
            power++;
        }
        System.out.println("=======");
        outputmatrix(resMat);//вывод результата


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
