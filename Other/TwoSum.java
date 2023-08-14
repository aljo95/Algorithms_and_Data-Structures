import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) { 
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int i;
        int count;
        for(i=0; i<nums.length; i++) {
            count = 1;
            while (count < nums.length) {
                if (nums[i]+nums[count] == target) return new int[] {nums[i], nums[count]};
                count++;
            }
        }
        return new int[] {};
    }
}
