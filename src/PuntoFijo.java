import java.lang.Math;
public class PuntoFijo {
    public static void main (String[] args){
        PuntoFijo(2, 10, 1E-7);

    }

    public static void PuntoFijo(double x, int Nmax, double tol){
       double xi_previous = 0;
       for (int i = 0; i <= Nmax; i++){
          double x_i = x;
          double error = Math.abs(xi_previous-x_i);
          if (error < tol ){
              System.out.println(x_i + " es el valor mas cercano a la raiz que se hallo con la tolerancia determinada.");
              System.out.println("Se encontro en la iteracion " + i);
              break;
          }
          //La función debe ser administrada manualmente.
           // fx = SQRT(10/(4+x))
          double fx_i = Math.sqrt(10/(4 + x_i));
          xi_previous = x_i;
          x = fx_i;
       }
    }
}
