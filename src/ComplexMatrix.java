import java.util.Scanner;
public class ComplexMatrix {
    public int n, m;
    public ComplexNumb[][] matrix;
    Scanner in = new Scanner(System.in);

    public ComplexMatrix(int n, int m){
        this.n = n;
        this.m = m;
        matrix = new ComplexNumb[n][m];
    }

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

    public void Addition(ComplexNumb[][] mtrx1, ComplexNumb[][] mtrx2){
        ComplexNumb[][] sum = new ComplexNumb[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                int a = mtrx1[i][j].a + mtrx2[i][j].a;
                int b = mtrx1[i][j].b + mtrx2[i][j].b;
                sum[i][j] = new ComplexNumb(a ,b);
            }
        }
        print(sum, n, m);
    }

    public void Multiply(ComplexNumb[][] mtrx1, ComplexNumb[][] mtrx2, int m, int n, int k){
        ComplexNumb[][] mult = new ComplexNumb[m][k];
        for (int i=0; i<m; i++){
            for (int j=0; j<k; j++){
                mult[i][j] = new ComplexNumb(0, 0);
                for (int l=0; l<n; l++){
                    int temp_a, temp_b;
                    temp_a = mtrx1[i][l].a*mtrx2[l][j].a + mtrx1[i][l].b*mtrx2[l][j].b*(-1);
                    temp_b = mtrx1[i][l].a*mtrx2[l][j].b + mtrx1[i][l].b*mtrx2[l][j].a;
                    mult[i][j].a+=temp_a;
                    mult[i][j].b+=temp_b;
                }
            }
        }
        print(mult, m, k);

    }
    public void print(ComplexNumb[][] mtrx, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mtrx[i][j].a + "+" + mtrx[i][j].b + "i ");
            }
            System.out.print("\n");
        }
    }

    public void Transpose(){
        ComplexNumb[][] trnsp = new ComplexNumb[m][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                trnsp[j][i] = matrix[i][j];
            }
        }
        print(trnsp, m, n);
    }

}