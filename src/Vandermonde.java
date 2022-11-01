import Jama.Matrix;

public class Vandermonde {
    public static Matrix solve(double [] X, double [] Y){
        int n = X.length;
        double [][] Vandermonde = new double [n][n];
        for (int i = 0; i < n; i++){
            int exp = n-1;
            for (int j = 0; j < n; j++){
                Vandermonde[i][j] = Math.pow(X[i],exp);
                exp--;
            }
        }
        Matrix Vander = new Matrix(Vandermonde);
        return Vander;
    }
    public static void main (String[] args){
        double [] X = {-1,0,3,4};
        double [] Y = {15.5, 3, 8, 1};
        Matrix Vandermonde = solve(X,Y);
        Vandermonde.print(0,4);
        double [] x0 = {0,0,0,0};
        PartialPivoting.solve(Vandermonde.getArray(),Y);
    }
}
