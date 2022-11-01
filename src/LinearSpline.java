import Jama.Matrix;

public class LinearSpline {
    public static void solve(double [] X, double [] Y){
        int n = X.length;
        int m = 2*(n-1);
        double [][] A = new double[m][m];
        double [] b = new double[m];
        A[0][0] = X[0];
        A[0][1] = 1;
        b[0] = Y[0];
        for (int i = 0; i < n-1; i++){
            A[i+1][2*i] = X[i+1];
            A[i+1][2*i+1] = 1;
            b[i+1] = Y[i+1];
        }
        for (int i = 1; i < n-1; i++){
            A[i+n-1][2*i-2] = X[i];
            A[i+n-1][2*i-1] = 1;
            A[i+n-1][2*i] = -X[i];
            A[i+n-1][2*i+1] = -1;
            b[i+n-1] = 0;
        }
        Matrix A1 = new Matrix(A);
        Matrix B1 = new Matrix(b, 1);
        System.out.println("Spline Matrix");
        A1.print(0, 4);
        System.out.println("Spline Vector");
        B1.print(0,4);
        Matrix  C = A1.solve(B1.transpose());
        double[][] org = new double[m/2][2];
        double[] desorg = C.getRowPackedCopy();

        for(int i = 0; i < m; i++){
            if (i%2 == 0){
                for (int j = 0; j < m/2; j++){
                    if(org[j][0] == 0){
                        org[j][0] = desorg[i];
                        break;
                    }
                }
            }
            if (i%2 != 0){
                for (int j = 0; j < m/2; j++){
                    if(org[j][1] == 0){
                        org[j][1] = desorg[i];
                        break;
                    }
                }
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
