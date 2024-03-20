import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target))); // [3, 4]

        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        System.out.println(Arrays.toString(searchRange(nums2, target2))); // [-1, -1]

        int[] nums3 = {};
        int target3 = 0;
        System.out.println(Arrays.toString(searchRange(nums3, target3))); // [-1, -1]

    }
    public static int[] searchRange(int[] nums, int target) {

        int [] result = new int[2];
        int first = -1;
        int last = -1;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] == target) {
                last = i;
                break;
            }
        }


        result[0] = first;
        result[1] = last;

        return result;
    }
}
