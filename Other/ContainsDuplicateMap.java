import java.util.Map;
import java.util.HashMap;

/*
 *  Contains Duplicate but with map
 *  Loop over array. map.put if value does not exist in map (check with array.containsValue(value))
 *  When or if element value is found in map with array.containsValue, return true, else return false
 *  O(n) time instead of O(nlog(n))
 */

public class ContainsDuplicateMap {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));    // true

        int[] nums2 = {1,2,3,4};
        System.out.println(containsDuplicate(nums2));   // false

        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums3));   // true
    }

    public static boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> arr = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            if (arr.containsValue(nums[i])) return true;
            arr.put(i, nums[i]);
        }

    return false;
    }
}
