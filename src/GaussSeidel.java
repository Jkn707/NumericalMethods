import Jama.Matrix;

public class GaussSeidel {
    public static void print(int i, double error, Matrix x){
        System.out.println("Iteration " + i);
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
        Matrix T = ((D.minus(L)).inverse()).times(U);
        Matrix C = ((D.minus(L)).inverse()).times(b.transpose());
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
                {4,-1,0,3},
                {1,15.5,3,8},
                {0,-1.3,-4,1.1},
                {14,5,-2,30}};
        double[] Vector = {1,1,1,1};
        double[] It0 = {0,0,0,0};
        Matrix A = new Matrix(Inicial);
        Matrix b = new Matrix(Vector, 1);
        Matrix x0 = new Matrix(It0, 1);
        solve(A,b,x0,1e-7,100);
    }
}

