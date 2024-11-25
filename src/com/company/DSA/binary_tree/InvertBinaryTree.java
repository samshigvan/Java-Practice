package com.company.DSA.binary_tree;

import com.company.DSA.binary_tree.pojo.TreeNode;

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root){

        if (root==null)
            return null;

        if (root.left!=null)
            invertTree(root.left);

        if (root.right!=null)
            invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4, new TreeNode(2,new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        System.out.println(invertTree(root));
    }
}
