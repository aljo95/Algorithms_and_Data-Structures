
/*
 *  Since it has to have O(log(n)) time complexity we must 
 *  split the array in half in every iteration
 */

public class FirstNLastOlogn {
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

        int[] result = new int[2];
        result[0] = result[1] = -1;

        int start = 0;
        int end = nums.length - 1;
        int middle;

        //find first index
        while (end >= start) {
            middle = (start+end)/2;
            if (nums[middle] < target) {
                start++;
            } else {
                end--;
            }
            if (nums[middle] == target && (middle == 0 || nums[middle-1] != target)) {
                result[0] = middle;
            }
        
        }

        start = 0;
        end = nums.length - 1;
        //find last index
        while (end >= start) {
            middle = (start+end)/2;
            if (nums[middle] <= target) {
                start++;
            } else {
                end--;
            }
            if (nums[middle] == target) {
                result[1] = middle;
            }
        }
        
        return result;
    }
}