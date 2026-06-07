/*
 * Problem   : Rotate Image
 * Link      : https://leetcode.com/problems/rotate-image/
 * Difficulty: Medium
 *
 * Approach 1: Extra Matrix
 * Element at (i,j) goes to (j, n-1-i) in rotated matrix.
 * Time : O(n²)  Space: O(n²)
 *
 * Approach 2: Transpose + Reverse (OPTIMAL)
 * Step 1 — Transpose matrix (swap matrix[i][j] with matrix[j][i])
 *           Only go till diagonal (j < i) to avoid double swapping
 * Step 2 — Reverse every row using two pointers
 * Time : O(n²)  Space: O(1)
 */

import java.util.*;
public class RotateImage {

    // ── Approach 1 : Extra Matrix ─

    public static void rotateextraspace(int matrix[][]) {
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

    // ── Approach 2 : Transpose + Reverse (Optimal) ─────

    public static void rotate(int matrix[][]) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < i; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

                for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix.length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
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
