/*
 * Problem   : Sort Colors
 * Link      : https://leetcode.com/problems/sort-colors/
 * Difficulty: Medium
 *
 * Approach  : Dutch National Flag Algorithm (3-pointer)
 * Maintain 3 pointers — low, mid, high.
 * 0s go to left  (swap mid with low, move both forward)
 * 1s stay middle (just move mid forward)
 * 2s go to right (swap mid with high, move high backward)
 * mid<=high is the condition because everything after high is sorted.
 *
 * Time : O(n) — single pass through array
 * Space: O(1) — in-place sorting, no extra space
 */

import java.util.*;
public class SortColors {
    public static void swap(int nums[] , int a,int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void sortColors(int[] nums) {

        int mid=0,low=0,high=nums.length-1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                swap(nums,mid,low);
                mid++;
                low++;
            }
            else if(nums[mid]==1)
                mid++;
            else
            {
                swap(nums,mid,high);
                high--;
            }
        }

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size of an Array : ");
        int n = sc.nextInt();

        int nums[] = new int[n];

        System.out.println("Enter Array elemnts : ");
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }

        sortColors(nums);

        System.out.println("Sorted Colors : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+ " ");
        }
    }
}
