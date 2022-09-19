import java.util.Scanner;
public class GaussSimple {
    public static void readMatrixByUser()
    {
        int m, n, i, j;
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            System.out.println("Enter the number "
                    + "of rows of the matrix");
            m = in.nextInt();
            System.out.println("Enter the number "
                    + "of columns of the matrix");
            n = in.nextInt();

            // Declare the matrix
            int first[][] = new int[m][n];

            // Read the matrix values
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    System.out.println("Ingrese el elemento " + (i+1) + "-" + (j+1));
                    first[i][j] = in.nextInt();
                }
            }

            // Display the elements of the matrix
            System.out.println("Elements of the matrix are");
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++)
                    System.out.print(first[i][j] + "  ");
                System.out.println();
            }
        }
        catch (Exception e) {
        }
        finally {
            in.close();
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        readMatrixByUser();
    }
}

