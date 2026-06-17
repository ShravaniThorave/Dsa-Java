/*
 * Problem   : Pow(x, n) — Implement Power Function
 * Link      : https://leetcode.com/problems/powx-n/
 * Difficulty: Medium
 *
 * Approach  : Binary Exponentiation (Fast Power)
 * Instead of multiplying x by itself n times (O(n)),
 * we use the property:
 *   if n is odd  → ans = ans * x, then n = n - 1
 *   if n is even → x = x * x,     then n = n / 2
 * This halves n every even step → O(log n)
 *
 * Handle negative n → convert x to 1/x and n to positive
 * Use long for N to avoid Integer.MIN_VALUE overflow
 *
 * Time : O(log n) — n is halved every even step
 * Space: O(1)     — only a few variables used
 */

import java.util.*;

class MyPow{
public static double myPow(double x, int n) {
        double ans = 1.0;
        long N = n;
        if (N<0)
        {
            x = 1.0 / x;
            N = -1 * N;
        }
        while(N>0)
        {
            if((N % 2)==1)
            {
              ans = ans * x; 
               N = N -1;
           }
           else{
            x=x*x;
            N=N/2;
           }
        }
        return ans;
    }

    public static void  main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number :");
        double x = sc.nextDouble();
        System.out.println("Enter power  :");
        int n = sc.nextInt();
        System.out.println("Answer : "+myPow(x,  n));
    }
}

