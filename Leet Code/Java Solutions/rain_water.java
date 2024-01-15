/*
 * From Leet Code: https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */

public class rain_water {
    public int trap(int[] height) {
        //As we move from each index i, we check what the min values is to the left and right of i, then subtract
        //the height of i from the min value. If the result is positive, we add it to the total water.

        int total_water = 0;

        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];

        //populate left_max array
        for (int i = 1; i < height.length; i++){
            left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
        }
        
        //populate right_max array
        for (int i = height.length - 2; i >= 0; i--){
            right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
        }

        //iterate through height array and calculate total water
        for (int i = 0; i < height.length; i++){
            int min = Math.min(left_max[i], right_max[i]) - height[i];
            if (min > 0){
                total_water += min;
            }
        }
        
        return total_water;
    }
}
