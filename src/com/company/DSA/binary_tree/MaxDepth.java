package com.company.DSA.binary_tree;

import com.company.DSA.binary_tree.pojo.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description
public class MaxDepth {

    public static int maxDepth(TreeNode root){

        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(5, new TreeNode(6), new TreeNode(7));
        TreeNode root = new TreeNode(1, left, right);

        System.out.println(maxDepth(root));
    }
}
