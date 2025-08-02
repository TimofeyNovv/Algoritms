package org.example.Graphs.Depth_FirstSearch;


import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*

 */
//Рекурсивный
public class Solution {
    public String searchFile(TreeNode tree, String targetFileName) {
        return searchFileHelper(tree, targetFileName, "");
    }
    public String searchFileHelper(TreeNode node, String targetFileName, String currentPath){
        String path = currentPath.isEmpty() ? node.getName() : currentPath + "/" + node.getName();

        if (node.isFile() && node.getName().equals(targetFileName)){
            return path;
        }

        for (TreeNode child : node.getChildren()){
            String result = searchFileHelper(node, targetFileName, path);
            if (result != null){
                return result;
            }
        }
        return null;
    }
}

//Нерекурсивный
class Solution2 {
    public String searchFile(TreeNode root, String targetFileName) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();

        nodeStack.push(root);
        pathStack.push(root.getName());

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            String currentPath = pathStack.pop();

            if (currentNode.isFile() && currentNode.getName().equals(targetFileName)) {
                return currentPath;
            }

            List<TreeNode> children = currentNode.getChildren();
            for (int i = children.size() - 1; i >= 0; i--) {
                TreeNode child = children.get(i);
                nodeStack.push(child);
                pathStack.push(currentPath + "/"  + child.getName());
            }
        }
        return null;
    }
}

class TreeNode {
    private String name;
    private List<TreeNode> children;
    private boolean isFile;

    public TreeNode(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }


    public String getName() {
        return name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public boolean isFile() {
        return isFile;
    }
}
