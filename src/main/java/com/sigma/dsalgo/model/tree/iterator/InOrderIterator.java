package com.sigma.dsalgo.model.tree.iterator;

import com.sigma.dsalgo.model.tree.concrete.BinarySearchTree;
import com.sigma.dsalgo.model.tree.concrete.Node;

import java.util.Iterator;
import java.util.LinkedList;

public class InOrderIterator<T extends Comparable<T>> implements Iterator<T> {

    private final LinkedList<T> inOrderList;

    public InOrderIterator(BinarySearchTree<T> tree) {
        inOrderList = new LinkedList<>();
        inOrderTraversal(tree.getRoot());
    }

    private void inOrderTraversal(Node<T> root) {
        if (root == null){
            return;
        }
        inOrderTraversal(root.getLeft());
        inOrderList.add(root.getData());
        inOrderTraversal(root.getRight());
    }

    @Override
    public boolean hasNext() {
        return !inOrderList.isEmpty();
    }

    @Override
    public T next() {
        return inOrderList.removeFirst();
    }
}
