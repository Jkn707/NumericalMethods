import Jama.Matrix;

public class CuadraticSpline {
    public static void solve(double [] X, double [] Y){
        int n = X.length;
        int m = 3*(n-1);
        double [][] A = new double[m][m];
        double [] b = new double[m];
        A[0][0] = Math.pow(X[0],2);
        A[0][1] = X[0];
        A[0][2] = 1;
        A[1][0] = Math.pow(X[1],2);
        A[1][1] = X[1];
        A[1][2] = 1;
        b[0] = Y[0];
        b[1] = Y[1];
        for (int i = 1; i < n-1; i++){
            A[i+1][3*i] = Math.pow(X[i+1],2);
            A[i+1][3*i+1] = X[i+1];
            A[i+1][3*i+2] = 1;
            b[i+1] = Y[i+1];
        }
        for (int i = 1; i < n-1; i++){
            A[i+n-1][3*i-3] = Math.pow(X[i],2);
            A[i+n-1][3*i-2] = X[i];
            A[i+n-1][3*i-1] = 1;
            A[i+n-1][3*i] = -Math.pow(X[i],2);
            A[i+n-1][3*i+1] = -X[i];
            A[i+n-1][3*i+2] = -1;
            b[i+n-1] = 0;
        }
        for (int i = 1; i < n-1; i++){
            A[i+2*n-3][3*i-3] = 2*X[i];
            A[i+2*n-3][3*i-2] = 1;
            A[i+2*n-3][3*i-1] = 0;
            A[i+2*n-3][3*i] = -2*X[i];
            A[i+2*n-3][3*i+1] = -1;
            A[i+2*n-3][3*i+2] = 0;
            b[i+2*n-3] = 0;
        }
        A[m-1][0] = 2;
        b[m-1] = 0;
        Matrix A1 = new Matrix(A);
        Matrix B1 = new Matrix(b, 1);
        System.out.println("Spline Matrix");
        A1.print(0, 4);
        System.out.println("Spline Vector");
        B1.print(0,4);
        Matrix  C = A1.solve(B1.transpose());
        double[][] org = new double[m/3][3];
        double[] desorg = C.getRowPackedCopy();

        int counter = 0;
        for (int i = 0; i < m/3; i++){
            for (int j = 0; j < m/3; j++){
                org[i][j] = desorg[counter];
                counter++;
            }
        }

        Matrix coef = new Matrix(org);
        System.out.println("Coefficients");
        coef.print(8,4);

    }
    public static void main (String[] args){
        double[] x = {-1.0, 0.0, 3.0, 4.0};
        double[] fx = {15.5, 3.0, 8.0, 1.0};
        solve(x,fx);
    }
}
