import Jama.Matrix;

public class Test {
    public static void main(String[] args){
        double[] A = {12,7,3,1};
        double[] B = {1,8,7,4};
        Matrix a = new Matrix(A, 1);
        Matrix b = new Matrix(B, 1);
        Matrix c = a.minus(b);
        Matrix d = a.arrayTimes(b);
        Matrix e = a.copy();
        c.print(0,4);
        d.print(0,4);
        e.print(0,4);
        double[][] two =
                {{2,5,7,2},
                        {3,1,0,1},
                        {0,2,3,13},
                        {4,6,7,8}};
        Matrix doble = new Matrix(two);
        Matrix f = a.times(doble);
        Matrix g = a.minus(b);
        Matrix h = a.plus(b);
        doble.print(0,4);
        f.print(0,4);
        g.print(0,4);
        h.print(0,4);
        h = h.transpose();
        h.print(0,4);
        g = g.transpose();
        Matrix i = h.minus(g);
        i.print(0,4);
        Matrix j = g.plus(h);
        j.print(0,4);
        Matrix k = g.copy();
        k.print(0,4);
        g.print(0,4);

    }
}
