import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class TwoSumMap {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> arrValues = new HashMap<>();
        int i = 0;
        while(i < nums.length) {
            int difference = target - nums[i];                    // 1. 7=9-2,    2. 2=9-7
            if (arrValues.containsKey(difference)) {
                return new int[] {arrValues.get(difference), i};  // return {0, 1}, map.get(key) returns value
            }
            arrValues.put(nums[i], i);  //store key-value pairs  ->  ArrayValue-ArrayIndex 
            i++;                        
        }
            return new int[] {};
    }
}
