/*
 * Problem   : Best Time to Buy and Sell Stock
 * Link      : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Difficulty: Easy
 *
 * Approach  : Greedy - One Pass
 * Track the minimum price seen so far.
 * At each day, calculate profit if we sell today (price - minPrice).
 * Update maxProfit if current profit is better.
 * We never need to look back because buying at lowest
 * and selling at highest after it gives the best profit.
 *
 * Time : O(n) — single pass through prices array
 * Space: O(1) — only two variables used
 */

import java.util.*;
public class MaxProfit {
   public static int maxProfit(int[] prices) {
    int minPrice = prices[0];
    int maxProfit = 0;

    for(int i = 1; i < prices.length; i++) {
        if(prices[i] < minPrice) {
            minPrice = prices[i];
        } else {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
    }

    return maxProfit;
}
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of stocks : ");
        int n = sc.nextInt();
        int prices[] = new int[n];
        System.out.println("Enter prices of each stock : ");
        for(int i=0;i<n;i++)
        {
            prices[i] = sc.nextInt();
        }
        System.out.println("Maximum Profit : "+maxProfit(prices));

    }
}
