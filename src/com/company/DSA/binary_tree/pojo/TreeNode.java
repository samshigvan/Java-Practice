package com.company.DSA.binary_tree.pojo;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){this.val=val;}
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }

    @Override
    public String toString() {
        String temp = val + " ";

        if (left != null)
            temp += left.toString();

        if (right != null)
            temp += right.toString();

        return temp;
    }
}
