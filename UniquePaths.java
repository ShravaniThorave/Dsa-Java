/*
    Problem: Unique Paths
    Link: https://leetcode.com/problems/unique-paths/
    Difficulty: Medium
    Approach 1: Dynamic Programming (Tabulation)
    Time Complexity: O(m*n)
    Space Complexity: O(m*n)
    Approach 2 : Dynamic Programming(Memoization)
    Time Complexity : O(m*n)
    Space Complexity : O(m-1 + n-1) + O(m*n)
    */

import java.util.*;
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
    
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0&&j==0)
                    continue;

                 int up=0,left=0;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];

        /*MEMOIZATION */
        /*int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
         int num =  Count(m-1,n-1,m,n,dp);
         return num;*/

    }
    /*public static int Count(int i,int j,int m,int n,int dp[][])
    {
        
          if(i==0&&j==0) return 1;
        if(i<0||j<0) return 0;
        if(dp[i][j] != -1) 
            return dp[i][j];
        return dp[i][j]=Count(i-1,j,m,n,dp) + Count(i, j-1, m, n, dp);
    }*/
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array : ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Total no of Unique Paths : "+uniquePaths(m,n));

        
    }
}

