package org.example.BinarySearch.Searcha2DMatrix;

/*
You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false



Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104


 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        int targetMas = -1;

        while(left <= right){
            int midMas = left + (right - left) / 2;

            if (matrix[midMas][0] <= target && matrix[midMas][matrix[midMas].length - 1] >= target) {
                targetMas = midMas;
                break;
            } else if (matrix[midMas][0] > target) {
                right = midMas - 1;
            } else {
                left = midMas + 1;
            }
        }

        if (targetMas == -1) return false;

        left = 0;
        right = matrix[targetMas].length - 1;

        int mid = left + (right - left) / 2;

        while(left <= right) {
            if (matrix[targetMas][mid] > target) {
                right = mid - 1;
            } else if (matrix[targetMas][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
            mid = left + (right - left) / 2;
        }
        return false;
    }
}
