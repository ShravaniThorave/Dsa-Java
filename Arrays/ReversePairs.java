import java.util.*;

public class ReversePairs {
   

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return 0;

        int mid = (low + high) / 2;
        int count = 0;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        
        merge(nums, low, mid, high);
        return count;
    }

    public static int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for (int left = low; left <= mid; left++) {
            while (right <= high && (long) nums[left] > 2L * nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }

        return count;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= high) {
            temp[index++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Number of reverse pairs: " + reversePairs(nums));
    }
}