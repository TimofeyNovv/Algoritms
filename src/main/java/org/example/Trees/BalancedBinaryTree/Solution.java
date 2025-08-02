package org.example.Trees.BalancedBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree, determine if it is Height-Balanced
.



Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true



Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -104 <= Node.val <= 104

 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true; // Пустое дерево - сбалансировано
        return checkBalanced(root) != -1;
    }

    private int checkBalanced(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkBalanced(node.left);
        if (leftHeight == -1) return -1; // Левое поддерево несбалансировано

        int rightHeight = checkBalanced(node.right);
        if (rightHeight == -1) return -1; // Правое поддерево несбалансировано

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Текущий узел несбалансирован

        return Math.max(leftHeight, rightHeight) + 1; // Возвращаем высоту текущего поддерева
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


