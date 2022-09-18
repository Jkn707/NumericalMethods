public class Newton {
    public static void main (String[] args){
        NewtonRaphson(0, 1E-7, 10);

    }
    public static void NewtonRaphson(double Xi, double tol, int Nmax){
        double Xi_anterior;
        for (int i = 0; i <= Nmax; i++){
            //La funcion debe ser administrada manualmente.
            //fx = ln(x+0.5)
            double fx = Math.log(Xi + 0.5);
            //derivada de fx = 1/x+0.5
            double dfx = 1/(Xi + 0.5);
            Xi_anterior = Xi;
            Xi = Xi - ((fx)/(dfx));
            double error = Math.abs(Xi_anterior - Xi);
            if (error < tol){
                System.out.println("la raiz de la funcion esta alrededor de " + Xi);
                System.out.println("Se encontro en la iteracion" + i);
                break;
            }
            if (i == Nmax){
                System.out.println("Se recomienda usar otro metodo");
            }
        }
    }
}
