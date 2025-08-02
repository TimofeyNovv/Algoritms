package org.example.Stack.PalindromeLinkedList;
/*
Given the head of a singly linked list, return true if it is a

or false otherwise.



Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false



Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9

 */

import java.util.Arrays;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            ListNode nextTemp = head.next;
            stack.push(head.val);
            head = nextTemp;
        }
        int[] arr = new int[stack.size()];

        for (int i = 0; i < arr.length; i++){
            arr[i] = stack.pop();
        }
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            if (arr[left] == arr[right]){
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}