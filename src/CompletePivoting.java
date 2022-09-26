public class CompletePivoting
{
    public void solve(double[][] A, double[] B)
    {
        int N = B.length;
        for (int k = 0; k < N - 1; k++)
        {
            int maxC = k;
            for (int u = k; u < A.length; u++) {
                for (int p = k; p < A[0].length; p++) {
                    if (Math.abs(A[u][p]) > Math.abs(A[u][maxC])) {
                        maxC = p;
                    }
                }
                swapColumns(A, k, maxC);
            }


            /** find pivot row **/
            int max = k;
            for (int i = k + 1; i < N; i++)
                if (Math.abs(A[i][k]) > Math.abs(A[max][k]))
                    max = i;

            /** swap row in A matrix **/
            double[] temp = A[k];
            A[k] = A[max];
            A[max] = temp;

            /** swap corresponding values in constants matrix **/
            double t = B[k];
            B[k] = B[max];
            B[max] = t;

            /** pivot within A and B **/
            for (int i = k + 1; i < N; i++)
            {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++)
                    A[i][j] -= factor * A[k][j];
            }
            printRowEchelonForm(A,B);
        }


        /** back substitution **/
        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--)
        {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++)
                sum += A[i][j] * solution[j];
            solution[i] = (B[i] - sum) / A[i][i];
        }
        /** Print solution **/
        printSolution(solution);
    }
    /** function to print in matrix form **/
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
    /** function to print solution **/
    public static void printSolution(double[] sol)
    {
        int N = sol.length;
        System.out.println("\nSolution : ");
        for (int i = 0; i < N; i++)
            System.out.printf("%.3f ", sol[i]);
        System.out.println();
    }
    public static double[][] swapColumns(double[][] a, int i, int j) {
        for (int k = 0; k < a.length; k++) {
            double temp = a[k][i];
            a[k][i] = a[k][j];
            a[k][j] = temp;
        }
        return a;
    }

    public static void main (String[] args)
        {
        CompletePivoting ge = new CompletePivoting();

        double[] B = {12,7,3,1};
        double[][] A =
                {{2,5,7,2},
                        {3,1,0,1},
                        {0,2,3,13},
                        {4,6,7,8}};


        ge.solve(A,B);
    }
}