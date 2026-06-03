
import java.util.*;
public class RotateImage {
    public static void rotate(int matrix[][]) {
        int rotated[][] = new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                rotated[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                matrix[i][j] = rotated[i][j];
            }
        }
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of 2D matrix : ");
        int n = sc.nextInt();
        System.out.println("Enter elements of matrix : ");
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        rotate(matrix);
        System.out.println("90 degree Rotated Matrix : ");
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+ " " );
            }
            System.out.println();
        }
    }
}
