/*
 * Problem   : Find the Duplicate Number
 * Link      : https://leetcode.com/problems/find-the-duplicate-number/
 * Difficulty: Medium
 *
 * Approach 1: Brute Force (Nested Loops)
 * Compare every pair of elements to find duplicate.
 * Time : O(n²)  Space: O(1)
 *
 * Approach 2: HashSet
 * Store each number in a set, return number seen twice.
 * Time : O(n)  Space: O(n)
 *
 * Approach 3: Floyd's Cycle Detection (OPTIMAL)
 * Treat array as a linked list where nums[i] points to nums[nums[i]].
 * Duplicate number creates a cycle — find the cycle entry point.
 * Phase 1: slow moves 1 step, fast moves 2 steps until they meet.
 * Phase 2: reset fast to start, both move 1 step until they meet.
 * Meeting point in Phase 2 = duplicate number.
 * Time : O(n)  Space: O(1)
 */

import java.util.*;

public class FindDuplicate {

    // ── Approach 1 : Brute Force ─────────────────────────
    public static int findDuplicateBrute(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (nums[i] == nums[j])
                    return nums[i];
        return -1;
    }

    // ── Approach 2 : HashSet ─────────────────────────────
    public static int findDuplicateHashSet(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }

    // ── Approach 3 : Floyd's Cycle Detection (Optimal) ──
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1 — find meeting point inside cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2 — find cycle entry point (duplicate)
        fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter range of array elements : 1 to ");
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        System.out.println("Enter array elements : ");
        for (int i = 0; i < n + 1; i++)
            nums[i] = sc.nextInt();

        System.out.println("Repeated Number : " + findDuplicate(nums));
    }
}