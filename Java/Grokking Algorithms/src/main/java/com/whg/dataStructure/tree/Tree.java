package com.whg.dataStructure.tree;

public interface Tree<K> {

    void insert(K k);

    K remove(K k);

    boolean search(K k);

    /** 中序遍历（左中右） */
    void inOrderTraverse();

    /** 先序遍历（中左右） */
    void preOrderTraverse();

    /** 后序遍历（左右中） */
    void postOrderTraverse();

    K min();

    K max();

}
