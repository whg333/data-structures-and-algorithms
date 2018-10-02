package com.whg.dataStructure.tree;

import com.whg.dataStructure.collection.Collection;

public interface Tree<K extends Comparable<K>> extends Collection<K> {

    /** 中序遍历（左中右） */
    void inOrderTraverse();

    /** 先序遍历（中左右） */
    void preOrderTraverse();

    /** 后序遍历（左右中） */
    void postOrderTraverse();

    K min();

    K max();

}
