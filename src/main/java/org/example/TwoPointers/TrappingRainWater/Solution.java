package org.example.TwoPointers.TrappingRainWater;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9



Constraints:

    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105


 */
public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int count = 0;

        int leftMax = 0;
        int rightMax = 0;

        int current_height = 0;

        for (int i = 1; i < height.length; i++){
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                count += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                count += rightMax - height[right];
                right--;
            }
            //count += Math.min(leftMax, rightMax) - height[i];
        }
        return count;
    }
}
