/*
 * From Leet Code: https://leetcode.com/problems/jump-game/
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

 * Return true if you can reach the last index, or false otherwise.
 * 
 * Code solution demonstrates use of a greedy algorithm to solve the problem where we start from the end of the array and keep track of the last good index. 
 * If the current index plus the value at the current index is greater than or equal to the last good index, we update the last good index to the current index. 
 * If the last good index is 0, we return true, otherwise we return false.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class jump_game {
    public static void main (String[] args){
        int[] nums = {1,3,1,1,4};
        boolean result = canJump(nums);
        System.out.println(result);
    }
    
    public static boolean canJump(int[] nums) {
        
        int lastGoodIndex = nums.length - 1;
        
        for (int i = nums.length - 1; i >= 0; i--){
            if (i + nums[i] >= lastGoodIndex){
                lastGoodIndex = i;
            }
        }
        return lastGoodIndex == 0;
        
    }
}
