/*
 * From Leet Code: https://leetcode.com/problems/merge-sorted-array/
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.

 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class merged_sorted_arrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //set pointers to the end of the arrays
        int nums1Tail = m - 1;
        int nums2Tail = n - 1;
        //set pointer to the end of the merged array
        int insertPoint = m + n - 1;
        //while there are still elements in nums2
        while (nums2Tail >= 0) {
            //if there are still elements in nums1 and the current element in nums1 is greater than the current element in nums2
            if (nums1Tail >= 0 && nums1[nums1Tail] > nums2[nums2Tail]) {
                //set the current element in nums1 to the end of the merged array
                nums1[insertPoint--] = nums1[nums1Tail--];
            //
            } 
            else {
                //set the current element in nums2 to the end of the merged array
                nums1[insertPoint--] = nums2[nums2Tail--];
            }
        }
    }
}
