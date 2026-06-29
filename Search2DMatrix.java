/*
 * Problem   : Search a 2D Matrix II
 * Link      : https://leetcode.com/problems/search-a-2d-matrix-ii/
 * Difficulty: Medium
 *
 * Approach 1 : Row Filter + Linear Search
 * Skip rows where first element > target or last element < target.
 * Search only valid rows linearly.
 * Time : O(m*n) worst case  Space: O(1)
 *
 * Approach 2 : Staircase Search (OPTIMAL)
 * Start from top-right corner (row=0, col=n-1)
 * current > target → move left  (col--)
 * current < target → move down  (row++)
 * current == target → found!
 * Each step eliminates one full row or column.
 * Time : O(m+n)  Space: O(1)
 */

import java.util.*;
class Search2DMatrix {
    public static boolean searchMatrixRowFilter(int[][] matrix, int target) {

        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0]<=target && matrix[i][matrix[0].length-1]>=target)
            {
                for(int j=0;j<matrix[0].length;j++)
                {
                    if(matrix[i][j]==target)
                    return true;
                }
            }
        }
        return false;  
    }
        public static boolean searchMatrix(int[][] matrix, int target) {
        
        }

    public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter rows and cols : ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];
        System.out.println("Enter matrix elements : ");

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter target to search : ");

        int target = sc.nextInt();
        System.out.println(searchMatrix(matrix, target) ? "Found" : "Not Found");   
}}