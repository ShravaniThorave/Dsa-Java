
import java.util.*;
public class MergeSortedArray {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
            for(int i=m;i<m+n;i++)
            {
                int temp = nums1[i];
                nums1[i] = nums2[i-m];
                nums2[i-m] = temp;
            }
          // Arrays.sort(nums1);
           for(int i=0;i<m+n-1;i++)
          {
            for(int j=0;j<m+n-i-1;j++)
            {
                if(nums1[j] > nums1[j+1])
                {
                    int temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                }
            }
          }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements in nums1 array : ");
        int m = sc.nextInt();
        System.out.println("Enter no. of elements in nums2 array : ");
        int n = sc.nextInt();

        int[] nums1 = new int[m+n];
        int[] nums2 = new int[n];

        System.out.println("Enter elements of nums1 : ");
        for(int i=0;i<m+n;i++)
        {
            nums1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of nums2 : ");
        for(int i=0;i<n;i++)
        {
            nums2[i] = sc.nextInt();
        }

        merge(nums1,m,nums2,n);
        System.out.println("Merged sorted Array : ");
        for(int i=0;i<m+n;i++)
        {
            System.out.print(nums1[i]+ " ");
        }

    }
}
