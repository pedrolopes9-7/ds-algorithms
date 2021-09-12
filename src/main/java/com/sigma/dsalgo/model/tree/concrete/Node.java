package com.sigma.dsalgo.model.tree.concrete;

import lombok.Data;

@Data
public class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
