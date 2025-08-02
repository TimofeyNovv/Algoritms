package org.example.BinarySearch.MedianofTwoSortedArrays;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.



Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106


 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        int total = nums1.length + nums2.length;
        int halfLen = (len1 + len2 + 1) / 2;

        int left = 0;
        int right = len1;

        while(left <= right){
            int i = (left + right) / 2;
            int j = (len1 + len2 + 1) / 2 - i;

            int A_left = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int A_right = (i == len1) ? Integer.MAX_VALUE : nums1[i];
            int B_left = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int B_right = (j == len2) ? Integer.MAX_VALUE : nums2[j];

            if (A_left <= B_right && B_left <= A_right){
                if ((len1 + len2) % 2 == 1) {
                    return Math.max(A_left, B_left);
                } else {
                    return (Math.max(A_left, B_left) + Math.min(A_right, B_right)) / 2.0;
                }
            } else if (A_left > B_right){
                right = i - 1;
            } else {
                left = i + 1;
            }


        }
        return 0.0;
    }
}
