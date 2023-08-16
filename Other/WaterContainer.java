import java.lang.Math;


public class WaterContainer {
    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }   

    public static int maxArea(int[] height) {

        int max = 0;
        for (int i=0; i<height.length; i++) {
            
            for (int j=i+1; j<height.length; j++) {
                if (height[i] > height[j]) {
                    max = Math.max(max, height[j] * (j-i));
                } else {
                    max = Math.max(max, height[i] * (j-i));
                }
            }
        }
        return max;
    }
}
