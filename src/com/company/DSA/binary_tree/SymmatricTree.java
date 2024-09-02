package com.company.DSA.binary_tree;

import com.company.DSA.binary_tree.pojo.TreeNode;

//https://leetcode.com/problems/symmetric-tree/submissions/1376777508/?envType=study-plan-v2&envId=top-interview-150
public class SymmatricTree {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null || right == null){
            return left == right;
        }

        return right.val == left.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
