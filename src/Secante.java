public class Secante {
    public static void main(String[] args) {
        Sec(0.5, 1, 1E-7, 100);

    }

    public static void Sec(double x0, double x1, double tol, int Nmax) {
        System.out.println("\ti" + "\tx0       \t" + "\tx1       \t" + "\tfx_0       \t" + "\tfx_1       \t" + "\tError");
        for (int i = 0; i <= Nmax; i++) {
            //Administrar la funcion manualmente
            //f = ln(sin2 + 1) - 1/2
            double fx0 = (Math.log(Math.pow(Math.sin(x0), 2) + 1) - (1.0/2.0));
            double fx1 = (Math.log(Math.pow(Math.sin(x1), 2) + 1) - (1.0/2.0));
            double error = Math.abs(x0 - x1);
            if (error < tol){
                System.out.println("\t" + i + "\t" + String.format("%,.010f", x0) + "\t" + String.format("%,.010f", x1) + "\t" + String.format("%,.010f", fx0) + "\t" +
                        String.format("%,.010f", fx1) + "\t" + String.format("%e", error));
                System.out.println("El valor mas cercano a la raiz es " + x1);
                System.out.println("Se encontró en la iteracion " + i);
                break;
            }
            double xtemp = x0;
            System.out.println("\t" + i + "\t" + String.format("%,.010f", x0) + "\t" + String.format("%,.010f", x1) + "\t" + String.format("%,.010f", fx0) + "\t" +
                    String.format("%,.010f", fx1) + "\t" + String.format("%e", error));
            x0 = x1;
            x1 = x1 - (((fx1)*(x1-xtemp))/(fx1-fx0));
            if (i == Nmax-1){
                System.out.println(Nmax + " iteraciones no fueron suficientes.");
                break;
            }
        }

    }
}


