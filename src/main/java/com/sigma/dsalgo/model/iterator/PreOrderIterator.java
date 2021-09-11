package com.sigma.dsalgo.model.iterator;

import com.sigma.dsalgo.model.concrete.BinarySearchTree;
import com.sigma.dsalgo.model.concrete.Node;

import java.util.Iterator;
import java.util.LinkedList;

public class PreOrderIterator<T extends Comparable<T>> implements Iterator<T> {

    LinkedList<T> preOrderList;

    public PreOrderIterator(BinarySearchTree<T> tree) {
        preOrderList = new LinkedList<>();
        preOrderTraversal(tree.getRoot());
    }

    private void preOrderTraversal(Node<T> root) {
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
