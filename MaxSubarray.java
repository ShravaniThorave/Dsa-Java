/*
 * Problem   : Maximum Subarray
 * Link      : https://leetcode.com/problems/maximum-subarray/
 * Difficulty: Medium
 *
 * Approach  : Kadane's Algorithm
 * Keep adding elements to currentSum.
 * If currentSum > maxSum, update maxSum.
 * If currentSum goes negative, reset it to 0
 * because a negative prefix can never help future sums.
 *
 * Time : O(n) — single pass through array
 * Space: O(1) — only two variables used
 */


import java.util.*;
public class MaxSubarray {
    
    public static  int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int currentsum =0;
        for(int i=0;i<nums.length;i++)
        {
            currentsum += nums[i];
            if(currentsum > maxsum){
                 maxsum = currentsum;

            }

            if(currentsum < 0){
                  currentsum = 0;
            }

        }
        return maxsum;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of an Array : ");
        int n = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter elements : ");
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        int sum = maxSubArray(nums);
        System.out.println("Maximum Sum Of an Subarray : "+sum);
    }
}
