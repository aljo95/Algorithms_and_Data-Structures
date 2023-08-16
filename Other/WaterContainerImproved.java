/*
 * Improved Water Container problem from https://leetcode.com/problems/container-with-most-water/
 * Single loop, O(n) linear time
*/


public class WaterContainerImproved {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7}; 
        //int [] height = {1, 1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r) {     
            if (height[l] > height[r]) {
                max = Math.max(max, height[r] * (r-l));
                r--;
            } else {
                max = Math.max(max, height[l] * (r-l));
                l++;
            }
        }
        return max;
    }
}
            //1: l=0, r=8,  =>   max=h[l] * r-l = 1 * (8-0) = 8
            //2: l=1, r=8   =>   max=h[r] * r-l = 7 * (8-1) = 7*7=49
