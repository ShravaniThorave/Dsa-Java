import java.util.*;
public class FindMissingRepeatingNumbers
{
    public static int[] findMissingRepeatingNumbers(int[] nums) {
               
        

        long n = nums.length;
        
        long sum1 = (n*(n+1))/2;
        long sum1sq = (n*(n+1)*(2*n + 1))/6;
        long sum2 = 0,sum2sq =0 ;
        for(int i=0;i<n;i++)
        {
            sum2 = sum2 + nums[i];
            sum2sq = sum2sq + (long)(nums[i]*nums[i]);
        }
        long diff = sum1 - sum2;
        long sqdiff = sum1sq - sum2sq;
        long sum = sqdiff / diff; 
        int mn = (int) ((sum+diff)/2);
        int rn = (int)(mn - diff);

        return new int[]{rn,mn};


    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements of array in range of [1,"+n+"]: ");
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
            
        }
        int a[] = findMissingRepeatingNumbers(nums);
        System.out.println("Missing element in nums array = "+a[1]);
         System.out.println("Repeating element in nums array = "+a[0]);


    }
}