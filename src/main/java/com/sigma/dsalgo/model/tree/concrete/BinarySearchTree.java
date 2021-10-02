package com.sigma.dsalgo.model.tree.concrete;

import com.sigma.dsalgo.model.tree.interfaces.Tree;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private BinaryTreeNode<T> root;

    public BinarySearchTree(T data) {
        this.root = new BinaryTreeNode<>(data);
    }

    @Override
    public T search(T data) {
        return search(root, data);
    }

    private T search(BinaryTreeNode<T> root, T data) {
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

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> root, T data) {
        if (root == null) {
            return new BinaryTreeNode<>(data);
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

    private BinaryTreeNode<T> delete(BinaryTreeNode<T> root, T data) {
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

    private T getMaxFromLeftSubTree(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> leftBinaryTreeNode = root.left;

        while (leftBinaryTreeNode.right != null) {
            leftBinaryTreeNode = leftBinaryTreeNode.right;
        }

        return leftBinaryTreeNode.data;
    }
}
