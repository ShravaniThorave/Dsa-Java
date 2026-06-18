import java.util.*;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt=0;
        int ele=0;
        for(int i=0;i<n;i++)
        {
            if(cnt==0)
            {
                ele = nums[i];
                cnt=1;
            }
            if(ele==nums[i])
                cnt++;
            else
                cnt--;
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
