import Jama.Matrix;

public class Lagrange {
    public static Matrix solve(double [] X, double [] fx){
        double [] Lx = new double [X.length];
        for (int i = 0; i < X.length; i++){
            Lx[i] = 1.0;
            for (int j = 0; j < X.length; j++){
                if (i != j){
                    Lx[i] *= 1/(X[i]-X[j]);
                }
            }
        }
        Matrix L = new Matrix(Lx, 1);
        Matrix Y = new Matrix(fx, 1);
        Matrix YL = Y.arrayTimes(L);
        return YL;
    }
public static void main (String[] args){
    double[] x = {-1.0, 0.0, 3.0, 4.0};
    double[] fx = {15.5, 3.0, 8.0, 1.0};
    Matrix Coef = solve(x,fx);
    Coef.print(0,4);


}
}
