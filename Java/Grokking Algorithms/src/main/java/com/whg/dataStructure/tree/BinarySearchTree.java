package com.whg.dataStructure.tree;

public class BinarySearchTree<K> implements Tree {

    private Node<K> root;

    @Override
    public void insert(Object k) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object remove(Object k) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean search(Object k) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void inOrderTraverse() {
        // TODO Auto-generated method stub

    }

    @Override
    public void preOrderTraverse() {
        // TODO Auto-generated method stub

    }

    @Override
    public void postOrderTraverse() {
        // TODO Auto-generated method stub

    }

    @Override
    public Object min() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object max() {
        // TODO Auto-generated method stub
        return null;
    }

    private static class Node<K> {
        K key;
        Node<K> left;
        Node<K> right;

        public Node(K key, Node<K> left, Node<K> right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        /** clear to let GC do its work */
        void clear() {
            key = null;
            left = null;
            right = null;
        }

    }

}
