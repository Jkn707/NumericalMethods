import java.util.Scanner;
public class GaussSimple {
    public static double[][] readMatrixByUser()
    {
        int m, n, i, j;
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            System.out.println("Ingrese el numero "
                    + "de filas en la matriz");
            m = in.nextInt();
            System.out.println("Ingrese el numero  "
                    + "de columnas en la matriz");
            n = in.nextInt();

            // Declare the matrix
            double matrix[][] = new double[m][n];

            // Read the matrix values
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    System.out.println("Ingrese el elemento " + (i+1) + "-" + (j+1));
                    matrix[i][j] = in.nextInt();
                }
            }

            // Display the elements of the matrix
            System.out.println("Los elementos de la matriz son:");
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + "  ");
                System.out.println();
            }
            return matrix;
        }
        catch (Exception e) {
        }
        finally {
            in.close();
        }
        return new double[0][];
    }

    public static void GaussS(double[][] a){
        System.out.println("Etapa 1");
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[0].length; i++){

            }
        }

    }

    // Driver code
    public static void main(String[] args)
    {
        readMatrixByUser();
    }
}

