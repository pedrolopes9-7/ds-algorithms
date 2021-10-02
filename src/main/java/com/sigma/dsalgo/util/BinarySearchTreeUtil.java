package com.sigma.dsalgo.util;

import com.sigma.dsalgo.model.tree.concrete.BinarySearchTree;
import com.sigma.dsalgo.model.tree.concrete.BinaryTreeNode;

public class BinarySearchTreeUtil<T extends Comparable<T>> {

    public static <T extends Comparable<T>> T getMax(BinarySearchTree<T> tree) {
        BinaryTreeNode<T> root = tree.getRoot();

        while (root.getRight() != null) {
            root = root.getRight();
        }

        return root.getData();
    }
}
