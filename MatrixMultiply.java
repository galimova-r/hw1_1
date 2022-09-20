//умножение двух матриц
public class MatrixMultiply {
    public static void main(String[] args) {
        int oneMat[][] = new int[2][3]; //создаем матрицу 1
        int twoMat[][] = new int[3][2];//создаем матрицу 2
        int resMat[][] = new int[2][2];//создаем матрицу для результата

        oneMat = fillMatrix(oneMat);//применяем функцию fillMatrix для 1 матрицы
        twoMat = fillMatrix(twoMat);
        outputmatrix(oneMat); //применяем метод вывода матрицы
        System.out.println("******");
        outputmatrix(twoMat);


        //умножаем матрицы между собой по формуле cij = ai1 · b1j + ai2 · b2j + ... + ain · bnj


        for (int i = 0; i < oneMat.length; i++) {
            for (int u = 0; u < twoMat[0].length; u++) {
                for (int j = 0; j < twoMat.length; j++) {

                    resMat[i][u] += oneMat[i][j] * twoMat[j][u];
                }
            }
        }
        System.out.println("=======");
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

