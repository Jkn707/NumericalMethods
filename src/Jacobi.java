import Jama.Matrix;

public class Jacobi {
    public static void print(int i, double error, Matrix x){
        System.out.println("Iteración " + i);
        x.print(x.getColumnDimension(), 4);
        System.out.println("Error: " + error);
    }

    public static void solve(Matrix A, Matrix b, Matrix x0, double Tol, int Nmax){
        Matrix D = A.copy();
        Matrix L = A.copy();
        Matrix U = A.copy();
        for (int i = 0; i < D.getColumnDimension(); i++){
            for (int j = 0; j < D.getColumnDimension(); j++){
                if (i == j){
                    D.set(i,j, A.get(i,j));
                    L.set(i,j,0);
                    U.set(i,j,0);
                }else if(i < j){
                    D.set(i,j, 0);
                    L.set(i,j,0);
                    U.set(i,j,(-A.get(i,j)));
                }else if(i > j){
                    D.set(i,j, 0);
                    L.set(i,j,(-A.get(i,j)));
                    U.set(i,j,0);
                }
            }
        }
        Matrix T = (D.inverse().times(L.plus(U)));
        Matrix C = (D.inverse().times(b.transpose()));
        Matrix x = x0.copy();
        x = x.transpose();
        int i = 0;
        double error = 10000;
        while (error > Tol && i < Nmax){
            Matrix xprev = x.copy();
            x = (T.times(xprev)).plus(C);
            Matrix incog = x.minus(xprev);
            error = (incog).norm2();
            i++;
            print(i, error, x);
        }


    }
    public static void main(String[] args){
        double[][] Inicial = {
                {2,5,7,2},
                {3,1,0,1},
                {0,2,3,13},
                {4,6,7,8}};
        double[] Vector = {12,7,3,1};
        double[] It0 = {0,0,0,0};
        Matrix A = new Matrix(Inicial);
        Matrix b = new Matrix(Vector, 1);
        Matrix x0 = new Matrix(It0, 1);
        solve(A,b,x0,1e-7,100);
    }
}
