package com.sigma.dsalgo.model.tree.concrete;

import lombok.Data;

@Data
public class BinaryTreeNode<T extends Comparable<T>> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    int height;

    public BinaryTreeNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
