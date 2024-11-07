package com.company.DSA.binary_tree;

import com.company.DSA.binary_tree.pojo.TreeNode;

public class CountCompleteTreeNode {

    public static int countNodes(TreeNode root) {

        if (root== null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(5, new TreeNode(6), new TreeNode(7));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(countNodes(root));
    }
}
