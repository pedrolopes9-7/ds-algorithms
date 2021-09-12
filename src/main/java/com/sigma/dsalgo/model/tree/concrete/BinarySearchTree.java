package com.sigma.dsalgo.model.tree.concrete;

import com.sigma.dsalgo.model.tree.interfaces.Tree;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    public BinarySearchTree(T data) {
        this.root = new Node<>(data);
    }

    @Override
    public T search(T data) {
        return search(root, data);
    }

    private T search(Node<T> root, T data) {
        if (root == null) {
            return null;
        }

        if (data == root.data) {
            return data;
        }
        else if (data.compareTo(root.data) < 0) {
            return search(root.left, data);
        }
        else {
            return search(root.right, data);
        }
    }

    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> root, T data) {
        if (root == null) {
            return new Node<>(data);
        }
        else if (data.compareTo(root.data) < 0) {
            root.left = insert(root.left, data);
        }
        else if (data.compareTo(root.data) > 0) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    @Override
    public boolean delete(T data) {
        root = delete(root, data);
        return root == null;
    }

    private Node<T> delete(Node<T> root, T data) {
        if (root == null) {
            return null;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = delete(root.left, data);
        }
        else if (data.compareTo(root.data) > 0) {
            root.right = delete(root.right, data);
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
                root.data = getMaxFromLeftSubTree(root);
                root.left = delete(root.left, root.data);
            }
        }

        return root;
    }

    private T getMaxFromLeftSubTree(Node<T> root) {
        Node<T> leftNode = root.left;

        while (leftNode.right != null) {
            leftNode = leftNode.right;
        }

        return leftNode.data;
    }
}
