public class Test {
    public static double[][] swapColumns(double[][] a, int i, int j) {
        for (int k = 0; k < a.length; k++) {
            double temp = a[k][i];
            a[k][i] = a[k][j];
            a[k][j] = temp;
        }
        return a;
    }

    public static void printMatrix(double[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j == (A.length - 1)) {
                    System.out.print("\t" + A[i][j] + "\n");

                } else {
                    System.out.print("\t" + A[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        double[][] A =
                {{2, 5, 7, 2},
                        {3, 1, 0, 1},
                        {0, 2, 3, 13},
                        {4, 6, 7, 8}};
        printMatrix(A);
        int maxC = 0;
        for (int k = 0; k < A.length; k++){
            maxC = k;
            for (int u = k; u < A.length; u++) {
                for (int p = k; p < A[0].length; p++) {
                    if (A[u][p] > A[u][maxC]) {
                        maxC = p;
                    }
                }
                swapColumns(A, k, maxC);
            }
        }
        System.out.println();

        printMatrix(A);

    }
}
