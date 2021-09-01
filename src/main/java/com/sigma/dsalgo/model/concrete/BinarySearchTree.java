package com.sigma.dsalgo.model.concrete;

import com.sigma.dsalgo.model.interfaces.Tree;
import lombok.Data;

@Data
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;
    private BinarySearchTree<T> root;
    private T data;

    public BinarySearchTree(T data) {
        this.data = data;
    }

    @Override
    public T search(T data) {
        return search(root, data);
    }

    private T search(BinarySearchTree<T> root, T data) {
        if (root == null) {
            return null;
        }
        if (data == root.data) {
            return data;
        }
        else if (data.compareTo(root.data) < 0) {
            search(root.left, data);
        }
        else {
            search(root.right, data);
        }

        return null;
    }

    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    private BinarySearchTree<T> insert(BinarySearchTree<T> root, T data) {
        if (root == null) {
            return new BinarySearchTree<>(data);
        }
        else if (data.compareTo(root.data) < 0) {
            root.left = insert(root, data);
        }
        else if (data.compareTo(root.data) > 0) {
            root.right = insert(root, data);
        }

        return root;
    }

    @Override
    public boolean delete(T data) {
        root = delete(root, data);
        return root == null;
    }

    private BinarySearchTree<T> delete(BinarySearchTree<T> root, T data) {
        if (root == null) {
            return null;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = delete(root, data);
        }
        else if (data.compareTo(root.data) > 0) {
            root.right = delete(root, data);
        }
        else {
            if (root.left == null && root.right == null) {
                return null;
            }
            else if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            else {
                root.data = getMax(root.left);
                root.left = delete(root.left, root.data);
            }
        }

        return root;
    }

    private T getMax(BinarySearchTree<T> left) {
        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }
}
