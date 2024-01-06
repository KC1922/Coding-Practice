/*
From Leet Code: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.
*/
using System;

public class remove_duplicates {
    public static void Main (string[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = removeDuplicates(nums);
        Console.WriteLine("k = " + k);
        
        for (int i = 0; i < k; i++){
            Console.Write(nums[i] + " ");
        }
    }
    
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        
        if (nums.Length <= 2){
            return 0;
        }

        foreach (int n in nums){
            if (i < 2 || n > nums[i - 2]){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}