package com.sigma.dsalgo.model.interfaces;

public interface Tree<T extends Comparable<T>> {

    public T search(T data);

    public void insert(T data);

    public boolean delete(T data);
}
