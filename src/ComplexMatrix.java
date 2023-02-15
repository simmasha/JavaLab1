import java.util.Scanner;

/**
 * Класс матриц, элементы которой комплексные числа
 */
public class ComplexMatrix {
    public int n, m;
    public ComplexNumb[][] matrix;
    Scanner in = new Scanner(System.in);

    /**
     * Конструктор класса
     * @param n - количество строк в матрице
     * @param m - количество столбцов в матрице
     */
    public ComplexMatrix(int n, int m){
        this.n = n;
        this.m = m;
        matrix = new ComplexNumb[n][m];
    }

    /**
     * Заполнение матрицы
     */
    public void fill(){
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                int a = in.nextInt();
                int b = in.nextInt();
                matrix[i][j] = new ComplexNumb(a, b);
            }
        }
        print(matrix, n, m);
    }

    /**
     * Сложение матриц
     * @param mtrx1 - первая матрица
     * @param mtrx2 - вторая матрица
     * @param n2 - количество строк во второй матрице
     * @param m2 - количество столбцов во второй матрице
     */
    public void addition(ComplexNumb[][] mtrx1, ComplexNumb[][] mtrx2, int n2, int m2){
        if (n!=n2 || m!=m2) throw new ArithmeticException("Нужны матрицы одинакового размера!");
        ComplexNumb[][] sum = new ComplexNumb[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                double a = mtrx1[i][j].a + mtrx2[i][j].a;
                double b = mtrx1[i][j].b + mtrx2[i][j].b;
                sum[i][j] = new ComplexNumb(a ,b);
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
    public void multiply(ComplexNumb[][] mtrx1, ComplexNumb[][] mtrx2, int n2, int m2){
        if (m != n2) throw new ArithmeticException("Для умножения кол-во столбцов первой матрицы" +
                " должно быть равно кол-ву строк второй!");
        ComplexNumb[][] mult = new ComplexNumb[n][m2];
        for (int i=0; i<m; i++){
            for (int j=0; j<m2; j++){
                mult[i][j] = new ComplexNumb(0, 0);
                for (int l=0; l<n; l++){
                    double temp_a, temp_b;
                    temp_a = mtrx1[i][l].a*mtrx2[l][j].a + mtrx1[i][l].b*mtrx2[l][j].b*(-1);
                    temp_b = mtrx1[i][l].a*mtrx2[l][j].b + mtrx1[i][l].b*mtrx2[l][j].a;
                    mult[i][j].a+=temp_a;
                    mult[i][j].b+=temp_b;
                }
            }
        }
        print(mult, n, m2);

    }

    /**
     * Вывод матрицы в консоль
     * @param mtrx - матрица
     * @param n - количество строк в матрице
     * @param m - количество столбцов в матрице
     */
    public void print(ComplexNumb[][] mtrx, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mtrx[i][j].a + "+" + mtrx[i][j].b + "i ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Транспонирование матрицы
     */
    public void transpose(){
        ComplexNumb[][] trnsp = new ComplexNumb[m][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                trnsp[j][i] = matrix[i][j];
            }
        }
        print(trnsp, m, n);
    }

}