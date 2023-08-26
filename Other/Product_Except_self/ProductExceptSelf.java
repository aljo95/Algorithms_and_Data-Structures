import java.util.Arrays;

public class ProductExceptSelf {
   /*  public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        nums = new int[] {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }*/
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];

        int fromLeft = 1;
        int fromRight = 1;
        for (int i=0; i<result.length; i++) {   
            result[i] = fromLeft;
            fromLeft *= nums[i];
        }

        for (int i=result.length-1; i>=0; i--) {
            result[i] *= fromRight;
            fromRight *= nums[i];
        }
        return result;
    }
}