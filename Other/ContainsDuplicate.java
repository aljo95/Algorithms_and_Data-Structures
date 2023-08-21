import java.util.Arrays;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));    // true

        int[] nums2 = {1,2,3,4};
        System.out.println(containsDuplicate(nums2));   // false

        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums3));   // true
    }

    public static boolean containsDuplicate(int[] nums) {
        
        Boolean result = false;
        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++) {
            if (nums[i] == nums[i+1]) result = true;
        }
        return result;
    }
}