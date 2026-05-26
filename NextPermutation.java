/*
 * Problem   : Next Permutation
 * Link      : https://leetcode.com/problems/next-permutation/
 * Difficulty: Medium
 *
 * Approach  : Three steps:
 * 1. Find rightmost index where nums[i] < nums[i+1] (the "dip")
 * 2. Find rightmost element greater than nums[dip] and swap
 * 3. Reverse everything after the dip index
 * If no dip found, array is fully descending — reverse whole array
 *
 * Time : O(n) — three linear passes at most
 * Space: O(1) — in-place, no extra space used
 */

import java.util.*;
public class NextPermutation {
    public static void reverse(int[] nums, int start, int end)
{
    while(start < end)
    {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        start++;
        end--;
    }
}

    static void nextPermutation(int[] nums) {
       
        int n = nums.length;
        
        int indx = -1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i] < nums[i+1])
            {
                indx = i;
                break;
            }
        }
        if(indx==-1)
        {
          reverse(nums,0,n-1);
          return;
        }
        else{
            for(int i=n-1;i>indx;i--)
            {
                if(nums[i] > nums[indx])
                {
                    int temp = nums[i];
                    nums[i] = nums[indx];
                    nums[indx] = temp;
                    break;
                }
            }
            
           reverse(nums,indx+1,n-1);
        }       
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Array : ");
        int n = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter Array Elements : ");
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        nextPermutation(nums);
        System.out.println("Next Permutation : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+ " ");
        }
    }
}
