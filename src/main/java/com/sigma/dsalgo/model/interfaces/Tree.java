package com.sigma.dsalgo.model.interfaces;

public interface Tree<T extends Comparable<T>> {

    T search(T data);

    void insert(T data);

    boolean delete(T data);
}
