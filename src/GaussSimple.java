import java.util.Scanner;
public class GaussSimple {
    public static void main(String[] args) {
        double[][] A = {{4.0, 5.0, 6.0, 7.0},
                {2.0, 3.0, 4.0, 2.0},
                {7.0, 8.0, 1.0, 0.0},
                {3.0, 4.0, 3.0, 3.0}};
        double[] b = {12.0, 4.0, 7.0, 1.0};
        double[][] Augmented = genAb(A, b);
        double[][] Etapa1 = Etapa1(Augmented);
        ImprimirMatriz(A);
       // ImprimirMatriz(Augmented);

    }

    //Matriz aumentada
    public static double[][] genAb(double[][] a, double[] b) {
        int ncolumn = a[0].length + 1;
        double newMatrix[][] = new double[a.length][ncolumn];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                if (j == newMatrix[0].length - 1) {
                    newMatrix[i][j] = b[i];
                } else {
                    newMatrix[i][j] = a[i][j];
                }

            }
        }
        return newMatrix;
    }

    public static double[][] Etapa1(double[][] MatrizOriginal) {
        for (int j = 0; j < MatrizOriginal[0].length-1; j++){
            double denom = MatrizOriginal[j][j];
            for (int i = 1; i < MatrizOriginal.length; i++){
                double mult = MatrizOriginal[i][j]/denom;
                for (int k = j; k < MatrizOriginal[0].length; k++){
                    MatrizOriginal[i][k] = MatrizOriginal[i][k] - (MatrizOriginal[i-1][k]*mult);

                }
            }
        }
        return MatrizOriginal;
    }

    public static void ImprimirMatriz(double[][] a) {
        for (double[] doubles : a) {
            for (int j = 0; j < a[0].length; j++) {
                if (j == (a[0].length - 1)) {
                    System.out.print(doubles[j] + "\n");
                } else {
                    System.out.print(doubles[j] + " ");

                }
            }
        }
    }
}