"""
From Leet Code: https://leetcode.com/problems/product-of-array-except-self/
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
"""

class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        #intialize products array
        products = []
        
        sum_left = 1
        #iterate through nums and append the product of all numbers to the left of the current number
        for n in nums:
            products.append(sum_left)
            sum_left *= n

        sum_right = 1
        #iterate through nums in reverse and multiply the product of all numbers to the right of the current number
        for i in range(len(nums)-1, -1, -1):
            products[i] *= sum_right
            sum_right *= nums[i]
            
        return products
    