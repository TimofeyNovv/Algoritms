package org.example.Trees.MaximumDepthOfBinaryTree;

import java.util.Map;
import java.util.Stack;

/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:

Input: root = [1,null,2]
Output: 2



Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100


 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();

        stack.push(root);
        depths.push(1);

        int maxDepth = 0;

        while (!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            int currentDepth = depths.pop();

            maxDepth = Math.max(currentDepth, maxDepth);

            if (currentNode.right != null){
                stack.push(currentNode.right);
                depths.push(currentDepth + 1);
            }
            if (currentNode.left != null){
                stack.push(currentNode.left);
                depths.push(currentDepth + 1);
            }
        }
        return maxDepth;
    }
}

class Solution2{
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
