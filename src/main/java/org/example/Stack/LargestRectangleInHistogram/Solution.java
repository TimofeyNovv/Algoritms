package org.example.Stack.LargestRectangleInHistogram;

import java.util.Stack;

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.



Example 1:

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:

Input: heights = [2,4]
Output: 4



Constraints:

    1 <= heights.length <= 105
    0 <= heights[i] <= 104


 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxPl = 0;

        Stack<Integer> stack = new Stack<>();

        int[] left = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            int width = right[i] - left[i] - 1;
            maxPl = Math.max(maxPl, heights[i] * width);
        }
        return maxPl;
    }
}
