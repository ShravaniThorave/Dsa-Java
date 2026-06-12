import java.util.*;
public class NumberOfInversions {
    public static long numberOfInversions(int[] nums) {
        
        int n = nums.length;
        long count = 0;

        
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(nums[i]>nums[j])
                    count++;

        

        return count;

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements of array : ");
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
            
        }
        System.out.println("Number of inversions : "+numberOfInversions(nums));
        
    }
}
