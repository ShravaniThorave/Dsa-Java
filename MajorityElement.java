/*
 * Problem   : Majority Element
 * Link      : https://leetcode.com/problems/majority-element/
 * Difficulty: Easy
 *
 * Approach 1 : Brute Force
 * Count frequency of each element using nested loops.
 * Time : O(n²)  Space: O(1)
 *
 * Approach 2 : HashMap
 * Store frequency of each element in map.
 * Return element with frequency > n/2.
 * Time : O(n)  Space: O(n)
 *
 * Approach 3 : Boyer-Moore Voting Algorithm (OPTIMAL)
 * Key insight: majority element appears > n/2 times.
 * So votes for majority cancel out all other votes
 * and still have votes remaining.
 * cnt == 0 → pick current element as candidate
 * same as candidate → increment count
 * different → decrement count (cancel one vote)
 * Last standing candidate is the majority element.
 * Time : O(n)  Space: O(1)
 */

import java.util.*;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int ele=0;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(count==0)
            {
                count=1;
                ele=nums[i];
            }
            else if(nums[i]==ele)
            {
                count++;
            }
             else 
                count--;
        }
        return ele;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of nums array : ");
        int n = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter elements of nums arrray : ");
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Majority element = "+majorityElement(nums));
    }
}
