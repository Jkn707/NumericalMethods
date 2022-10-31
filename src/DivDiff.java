import Jama.Matrix;

public class DivDiff {
    public static void divdif(double [] x, double[] fx){
        int s = x.length;

        double[][] newton = new double[(2*s)-1][s+1];
        for(int i=0, z=0;i < s; i++, z+=2){
            newton[z][0]=x[i];
            newton[z][1]=fx[i];
        }

        int i=1, ii=2, j=2, ss=s;
        for( int z=0;z<s-1;z++,j++,ss-=1,ii++){
            for(int y=0;y<ss-1;y++,i+=2){
                newton[i][j]=(newton[i+1][j-1]-newton[i-1][j-1])/(newton[i+(ii-1)][0]-newton[i-(ii-1)][0]);
            }
            i=ii;
        }
        Matrix Tabla = new Matrix(newton);
        System.out.println("Divided differences");
        Tabla.print(4,4);
    }
    public static double[] getPoly(double[] values, int i) {
        // Start poly: 1.0, neutral value for multiplication
        double[] coefs = {1.0};

        // Accumulate values of products
        for (int j = 0; j <= i; ++j) {
            // 'coefsLocal' represent polynom of 1st degree (x - values[j])
            double[] coefsLocal = {-values[j], 1.0};
            coefs = getPolyProduct(coefs, coefsLocal);
        }

        return coefs;
    }

    public static double[] getPolyProduct(double[] coefs1, double[] coefs2) {
        // Get lengths and degree
        int s1 = coefs1.length - 1;
        int s2 = coefs2.length - 1;
        int degree = s1 + s2;

        // Initialize polynom resulting from product, with null values
        double[] coefsProduct = new double[degree + 1];
        for (int k = 0; k <= degree; ++k) {
            coefsProduct[k] = 0.0;
        }

        // Compute products
        for (int i = 0; i <= s1; ++i)   {
            for (int j = 0; j <= s2; ++j)   {
                coefsProduct[i + j] += coefs1[i] * coefs2[j];
            }
        }
        return coefsProduct;
    }
    public static void main(String[] args){
        double[] x = {-1.0, 0.0, 3.0, 4.0};

        double[] fx = {15.5, 3.0, 8.0, 1.0};

        divdif(x,fx);


        double[] diffs = {15.5, -12.5, 3.5417, -1.1417};

        double[] result = new double[x.length];
        for (int i = 0; i < x.length; ++i) {
            result[i] = 0.0;
        }

        for (int i = 0; i < x.length; ++i) {
            double[] poly = getPoly(x, i - 1);
            for (int j = 0; j < poly.length; ++j) {
                result[j] += poly[j] * diffs[i];
            }
        }

        for (int i = 0; i < result.length; ++i) {
            System.out.println("Coef for x^" + i + " is: " + result[i]);
        }

    }
    }