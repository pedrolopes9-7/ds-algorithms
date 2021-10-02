package com.sigma.dsalgo.model.tree.iterator;

import com.sigma.dsalgo.model.tree.concrete.BinarySearchTree;
import com.sigma.dsalgo.model.tree.concrete.BinaryTreeNode;

import java.util.Iterator;
import java.util.LinkedList;

public class PreOrderIterator<T extends Comparable<T>> implements Iterator<T> {

    private final LinkedList<T> preOrderList;

    public PreOrderIterator(BinarySearchTree<T> tree) {
        preOrderList = new LinkedList<>();
        preOrderTraversal(tree.getRoot());
    }

    private void preOrderTraversal(BinaryTreeNode<T> root) {
        if (root == null){
            return;
        }
        preOrderList.add(root.getData());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    @Override
    public boolean hasNext() {
        return !preOrderList.isEmpty();
    }

    @Override
    public T next() {
        return preOrderList.removeFirst();
    }
}
