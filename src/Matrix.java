import java.util.Scanner;
public class Matrix {
    public int n, m;
    public int[][] matrix;
    Scanner in = new Scanner(System.in);

    public Matrix(int n, int m){
        this.n = n;
        this.m = m;
        this.matrix = new int[n][m];
    }

    public void fill(){
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                matrix[i][j] = in.nextInt();
            }
        }
    }

    public void Addition(int[][] mtrx1, int [][] mtrx2){
        int[][] sum = new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                sum[i][j] = mtrx1[i][j] + mtrx2[i][j];
            }
        }
        print(sum, n, m);
    }

    public void Multiply(int[][] mtrx1, int [][] mtrx2, int m, int n, int k){
        int[][] mult = new int[m][k];
        for (int i=0; i<m; i++){
            for (int j=0; j<k; j++){
                for (int l=0; l<n; l++){
                    int temp = mtrx1[i][l]*mtrx2[l][j];
                    mult[i][j]+=temp;
                }

            }
        }
        print(mult, m, k);
    }

    public void Transpose(){
        int[][] trnsp = new int[m][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                trnsp[j][i] = matrix[i][j];
            }
        }
        print(trnsp, m, n);
    }

    public void print(int[][] mtrx, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mtrx[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
