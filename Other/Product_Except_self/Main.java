import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ProductExceptSelf classTest = new ProductExceptSelf();
        int nums[] = {1,2,3,4};
        int result[] = classTest.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
