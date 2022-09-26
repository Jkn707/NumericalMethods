import Jama.Matrix;
import java.util.*;

public class GaussianElimination {
    public static void solve(double[][] A, double [] b){
        int N = b.length;
        for (int k = 0; k < (A[0].length - 1); k++){
            for (int i = k+1; i < A.length; i++){
                double Factor = A[i][k]/A[k][k];
                for (int j = k; j < A.length; j++){
                    A[i][j] = A[i][j] - (Factor * A[k][j]);
                }
                b[i] = b[i] - (Factor * b[k]);
            }
            printRowEchelonForm(A,b);
        }
        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--)
        {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++)
                sum += A[i][j] * solution[j];
            solution[i] = (b[i] - sum) / A[i][i];
        }
        /** Print solution **/
        printSolution(solution);
    }
    public static void printRowEchelonForm(double[][] A, double[] B)
    {
        int N = B.length;
        System.out.println("\nForma matricial : ");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.printf("%.3f ", A[i][j]);
            System.out.printf("| %.3f\n", B[i]);
        }
        System.out.println();
    }
    public static void printSolution(double[] sol)
    {
        int N = sol.length;
        System.out.println("\nSolution : ");
        for (int i = 0; i < N; i++)
            System.out.printf("%.3f ", sol[i]);
        System.out.println();
    }
    public static void main (String[] args)
    {
        GaussianElimination ge = new GaussianElimination();

        double[] B = {12,7,3,1};
        double[][] A =
                {{2,5,7,2},
                        {3,1,0,1},
                        {0,2,3,13},
                        {4,6,7,8}};


        ge.solve(A,B);
    }
}

