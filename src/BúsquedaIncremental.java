public class BúsquedaIncremental {
    public static void main(String[] args) {
        BI(0.5, 0.3, 10);
    }

    public static void BI(double x0, double delta, int Nmax) {
        for (int i = 0; i <= (Nmax + 1); i++) {
            double x1 = x0 + delta;
            //función: x-1
            double imagenx0 = x0 - 1;
            double imagenx1 = x1 - 1;
            if (imagenx0 * imagenx1 < 0) {
                System.out.println("Existe una raiz entre " + x0 + " y " + x1);
                System.out.println("La raiz se encontro en la iteracion " + i);
                break;
            } else {
                x0 = x1;
            }
            if (i >= Nmax + 1) {
                System.out.println(Nmax + " iteraciones no fueron suficientes para encontrar la raiz");
            }

        }
    }
}
