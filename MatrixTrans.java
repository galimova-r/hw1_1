//Транспонированная матрица
public class MatrixTrans {
    public static void main(String[] args) {
        int lines = 3; //кол-во строк
        int col = 5;//кол-во столбцов
        int Matrix[][] = new int[lines][col]; //создаем матрицу
        int transMat[][] = new int[col][lines];//создаем матрицу для результата

        Matrix = fillMatrix(Matrix);//применяем функцию fillMatrix для матрицы

        outputmatrix(Matrix); //применяем метод вывода матрицы



        //тарнспонируем матрицу
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < lines; j++) {
                transMat[i][j] = Matrix[j][i];

            }
        }
        System.out.println("========");
        outputmatrix(transMat);
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


