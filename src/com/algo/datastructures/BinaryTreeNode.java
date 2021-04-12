package com.algo.datastructures;

public class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
