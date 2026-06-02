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
