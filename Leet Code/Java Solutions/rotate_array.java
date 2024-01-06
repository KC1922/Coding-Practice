/*
 * From Leet Code: https://leetcode.com/problems/rotate-array/
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Code demonstrates use of a reverse function to solve the problem to avoid having to shift the elements in the array, improving the space complexity.
    Time complexity: O(n)
    Space complexity: O(1)
 */

public class rotate_array {
    public static void main (String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n; // handle cases where k is greater than the length of the array

        //reverse the entire array
        reverse(nums, 0, n - 1);
        //reverse the first k elements
        reverse(nums, 0, k - 1);
        //reverse the remaining elements
        reverse(nums, k, n - 1);
    }
    //By using the reverse function, we can avoid having to shift the elements in the array and do operations in place with a space complexity of O(1)
    //and a time complexity of O(n).
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
