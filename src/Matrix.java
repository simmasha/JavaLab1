import java.util.Scanner;

/**
 * Класс матриц, элементы которой действительные числа
 */
public class Matrix {
    public int n, m;
    public int[][] matrix;
    Scanner in = new Scanner(System.in);

    /**
     * Конструктор класса
     * @param n - количество строк в матрице
     * @param m - количество столбцов в матрице
     */
    public Matrix(int n, int m){
        this.n = n;
        this.m = m;
        this.matrix = new int[n][m];
    }

    /**
     * Заполнение матрицы
     */
    public void fill(){
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                matrix[i][j] = in.nextInt();
            }
        }
    }

    /**
     * Сложение матриц
     * @param mtrx1 - первая матрица
     * @param mtrx2 - вторая матрица
     * @param n2 - количество строк во второй матрице
     * @param m2 - количество столбцов во второй матрице
     */
    public void addition(int[][] mtrx1, int [][] mtrx2, int n2, int m2) /*throws AddException*/{
        if (n!=n2 || m!=m2) throw new ArithmeticException("Нужны матрицы одинакового размера!");
        int[][] sum = new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                sum[i][j] = mtrx1[i][j] + mtrx2[i][j];
            }
        }
        print(sum, n, m);
    }

    /**
     * Умножение матриц
     * @param mtrx1 - первая матрица
     * @param mtrx2 - вторая матрица
     * @param n2 - количество строк во второй матрице
     * @param m2 - количество столбцов во второй матрице
     */
    public void multiply(int[][] mtrx1, int [][] mtrx2, int n2, int m2){
        if (m != n2) throw new ArithmeticException("Для умножения кол-во столбцов первой матрицы" +
                " должно быть равно кол-ву строк второй!");
        int[][] mult = new int[n][m2];
        for (int i=0; i<n; i++){
            for (int j=0; j<m2; j++){
                for (int l=0; l<m; l++){
                    int temp = mtrx1[i][l]*mtrx2[l][j];
                    mult[i][j]+=temp;
                }

            }
        }
        print(mult, n, m2);
    }

    /**
     * Транспонирование матрицы
     */
    public void transpose(){
        int[][] trnsp = new int[m][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                trnsp[j][i] = matrix[i][j];
            }
        }
        print(trnsp, m, n);
    }

    /**
     * Вывод матрицы в консоль
     * @param mtrx - матрица
     * @param n - количество строк в матрице
     * @param m - количество столбцов в матрице
     */
    public void print(int[][] mtrx, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mtrx[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
