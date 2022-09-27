import java.lang.Math;
public class FixedPoint {
    public static void main (String[] args){
        FPoint(2, 10, 1E-7);

    }

    public static void FPoint(double x, int Nmax, double tol){
       double xi_previous = 0;
       double fx_i = 0;
        System.out.println("\ti" + "\tx_i       \t" + "\tfx_i       \t" + "\tError");
       for (int i = 0; i <= Nmax; i++){
          double x_i = x;
          double error = Math.abs(xi_previous-x_i);
          if (error < tol ){
              System.out.println("\t" + i + "\t" + String.format("%,.010f", x_i) + "\t" + String.format("%,.010f", fx_i) + "\t" + String.format("%e", error));
              System.out.println(x_i + " es el valor mas cercano a la raiz que se hallo con la tolerancia determinada.");
              System.out.println("Se encontro en la iteracion " + i);
              break;
          }
          //La función debe ser administrada manualmente.
           // fx = SQRT(10/(4+x))
          fx_i = Math.sqrt(10/(4 + x_i));
          xi_previous = x_i;
          x = fx_i;
           System.out.println("\t" + i + "\t" + String.format("%,.010f", x_i) + "\t" + String.format("%,.010f", fx_i) + "\t" + String.format("%e", error));
       }
    }
}
