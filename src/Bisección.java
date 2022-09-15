import java.lang.Math;
public class Bisección {
    public static void main(String[] args){
        Bisect(0,2,1E-7,30);

    }
    public static void Bisect(double a, double b, double tol, int Nmax) {
        double Xm_anterior = 0;
        for (int i = 0; i <= Nmax; i++){
            double Xm_i = (a+b)/2;
            double error = Math.abs(Xm_anterior - Xm_i);
            if (error < tol){
                System.out.println("El numero mas cercano a la raiz de acuerdo a la tolerancia es " + Xm_i);
                System.out.println("Se alcanzo en la iteracion " + i);
                break;
            }
            //Introducir manualmente la función
            //f = x^3+4*x^2-10
            double fa = Math.pow(a, 3)+4*Math.pow(a, 2)-10;
            double fX = Math.pow(Xm_i, 3)+4*Math.pow(Xm_i, 2)-10;
            double fb = Math.pow(b, 3)+4*Math.pow(b, 2)-10;

            if((fX*fb)<0){
                a = Xm_i;
            } else if ((fX*fa)<0) {
                b = Xm_i;
            } else if ((fX*fa) == 0 || (fX*fb) == 0){
                System.out.println("Uno de los tres valores " + a + ", " + Xm_i + ", " + b + " es una raiz" );
                break;
            } else{
                System.out.println("No existe una raíz en este intervalo");
                break;
            }
            if (i==Nmax){
                System.out.println(Nmax + " iteraciones no fueron suficientes para encontrar la raiz");
            }
            Xm_anterior = Xm_i;
        }

    }

}
