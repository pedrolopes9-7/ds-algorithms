package com.sigma.dsalgo.model.tree.iterator;

import com.sigma.dsalgo.model.tree.concrete.BinarySearchTree;
import com.sigma.dsalgo.model.tree.concrete.Node;

import java.util.Iterator;
import java.util.LinkedList;

public class PostOrderIterator<T extends Comparable<T>> implements Iterator<T> {

    private final LinkedList<T> postOrderList;

    public PostOrderIterator(BinarySearchTree<T> tree) {
        postOrderList = new LinkedList<>();
        preOrderTraversal(tree.getRoot());
    }

    private void preOrderTraversal(Node<T> root) {
        if (root == null){
            return;
        }
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
        postOrderList.add(root.getData());
    }

    @Override
    public boolean hasNext() {
        return !postOrderList.isEmpty();
    }

    @Override
    public T next() {
        return postOrderList.removeFirst();
    }
}
