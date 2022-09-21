import java.util.Scanner;
public class GaussSimple {
    public static void main (String[] args){

    }
    //Matriz aumentada
    public static double [][] genAb(double [][] a, double[] b){
        int ncolumn = a[0].length+1;
        double newMatrix [][] = new double [a.length][ncolumn];
        for(int i = 0;i < newMatrix.length; i++){
            for(int j = 0;j < newMatrix[0].length; j++){
                if(j == newMatrix[0].length-1){
                    newMatrix[i][j] = b[i];
                }else {
                    newMatrix[i][j] = a[i][j];
                }

            }
        }
        return newMatrix;
    }
}
