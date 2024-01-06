/*
From Leet Code: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Code solution demonstrates use of a greedy algorithm to solve the problem where we keep track of the index of the array and the number of times we have seen the current number. If we have seen the current number less than twice, we increment the index and set the value at that index to the current number. If we have seen the current number more than twice, we do not increment the index and continue to the next number in the array.
Time complexity: O(n)
Space complexity: O(1)

*/
public class remove_duplicates {
    public static void main (String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = removeDuplicates(nums);
        System.out.println("k = " + k);
        
        for (int i = 0; i < k; i++){
            System.out.print(nums[i] + " ");
        }
    }
    
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        
        if (nums.length <= 2){
            return 0;
        }

        for (int n : nums){
            if (i < 2 || n > nums[i - 2]){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}
