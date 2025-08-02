package org.example.BinarySearch.BinarySearch;


public class Solution2 {
    public int search(int[] nums, int target) {
        System.gc();
        return binSearch(nums, target, nums.length - 1, 0);
    }

    public int binSearch(int[] nums, int target, int right, int left){
        if(left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;

        if(nums[mid] == target){
            return mid;
        }
        else if(target > nums[mid]){
            return binSearch(nums, target, right, mid + 1);
        } else {
            return binSearch(nums, target, mid - 1, left);
        }
    }
}
