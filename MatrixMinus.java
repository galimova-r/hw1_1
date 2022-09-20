//Вычитание матриц
public class MatrixMinus {
    public static void main(String[] args) {
        int oneMat[][] = new int[3][3]; //создаем матрицу 1
        int twoMat[][] = new int[3][3];//создаем матрицу 2
        int resMat[][] = new int[3][3];//создаем матрицу для результата

        oneMat = fillMatrix(oneMat);//применяем функцию fillMatrix для 1 матрицы
        twoMat = fillMatrix(twoMat);
        outputmatrix(oneMat); //применяем метод вывода матрицы
        System.out.println("-------");
        outputmatrix(twoMat);



        //вычитаем матрицы
        for (int i = 0; i < resMat.length; i++) {
            for (int j = 0; j < resMat[i].length; j++) {
                resMat[i][j] = oneMat[i][j] - twoMat[i][j];
            }
        }
        System.out.println("========");
        outputmatrix(resMat);
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
