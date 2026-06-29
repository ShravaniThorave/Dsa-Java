 /*
 * Problem   : Majority Element II 
 * Link      : https://leetcode.com/problems/majority-element-ii/
 * Difficulty: Hard
 *
 * Approach 1 : Brute Force
 * Count frequency of each element using nested loops.
 * Time : O(n²)  Space: O(1)
 *
 * Approach 2 : HashMap
 * Store frequency of each element in map.
 * Return elements with frequency > n/3.
 * Time : O(n)  Space: O(n)
 *
 * Approach 3 : Extended Boyer-Moore Voting Algorithm (OPTIMAL)
 * Key insight: majority elements appears > n/3 times.
 * Time : O(2n)  Space: O(1)
 */
 import java.util.*;

public class MajorityElement2 {
        public static List<Integer> majorityElement(int[] nums) {
            int n=nums.length;
            int ele1=0;
            int ele2=0;
            int cnt1=0,cnt2=0;
            for(int i=0;i<n;i++)
            {
                if(cnt1==0 && nums[i]!=ele2)
                {
                    cnt1=1;
                    ele1=nums[i];
                }
                else if(cnt2==0 && nums[i]!=ele1)
                {
                    cnt2=1;
                    ele2=nums[i];
                }
                else if(ele1==nums[i]) cnt1++;
                else if(ele2==nums[i]) cnt2++;
                else{
                    cnt1--;
                    cnt2--;
                } 
                    
            }
            List<Integer> ans = new ArrayList<>();

            cnt1 = 0;
            cnt2 = 0;
            for(int i=0;i<n;i++)
            {
                if(ele1==nums[i])
                    cnt1++;
                else if(ele2==nums[i])
                    cnt2++;
            }
            if(cnt1 > n/3)
                ans.add(ele1);
            if(cnt2 > n/3)
                ans.add(ele2);


            return ans;
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
        System.out.println("Majority elements = "+majorityElement(nums));
    }
}
