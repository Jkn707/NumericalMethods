import java.lang.Math;
public class RaizMultiple {
    public static void main (String[] args){

        RM(1, 1E-7, 100, 0);

    }
    public static void RM(double x1, double tol, int Nmax, double m){
        System.out.println("\ti" + "\tx1       \t" + "\tfx       \t" + "\tdfx.       \t" + "\tddfx       \t" + "\tError");
        double x_prev = 0;
        m = m;
        double error = Math.abs(x_prev-x1);
        for (int i = 0; i <= Nmax; i++){
            //Ingresar formula manualmente
            //f = -e^x-x-1
            double fx = -(Math.exp(x1))-x1-1;
            double dfx = -(Math.exp(x1))-1;
            double ddfx = -(Math.exp(x1));
            x_prev = x1;
            System.out.println("\t" + i + "\t" + String.format("%,.010f", x1) + "\t" + String.format("%,.010f", fx) + "\t" +
                    String.format("%,.010f", dfx) + "\t" + String.format("%e", error));
            if (m!=0){
                x1 = x1 - m*(fx/dfx);
            }else{
                x1 = x1 - (fx*dfx)/(Math.pow(dfx, 2))-(fx*ddfx);
            }
            error = Math.abs(x_prev-x1);
            if (error < tol){
                System.out.println("la raiz de la funcion esta alrededor de " + x1);
                System.out.println("Se encontro en la iteracion " + i);
                break;
            }
            if (i == Nmax){
                System.out.println("Se recomienda usar otro metodo");
            }
        }
    }
}
