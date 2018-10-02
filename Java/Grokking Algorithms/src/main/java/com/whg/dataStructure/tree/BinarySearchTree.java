package com.whg.dataStructure.tree;

import java.util.Arrays;
import java.util.Iterator;

import com.whg.dataStructure.collection.EmptyCollectionException;
import com.whg.dataStructure.collection.list.ArrayList;
import com.whg.dataStructure.collection.list.List;

public class BinarySearchTree<K extends Comparable<K>> implements Tree<K> {

    private static final Object[] EMPTY_ARRAY = new Object[0];

    private Node<K> root;
    private int size;

    @Override
    public boolean add(K k) {
        if (root == null) {
            root = new Node<>(k);
            size++;
        } else {
            addNode(k, root);
        }
        return true;
    }

    private void addNode(K k, Node<K> node) {
        if (k.compareTo(node.key) < 0) {
            if (node.left == null) {
                node.left = new Node<>(k);
                size++;
            } else {
                addNode(k, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(k);
                size++;
            } else {
                addNode(k, node.right);
            }
        }
    }

    @Override
    public boolean remove(K k) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean has(K k) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void inOrderTraverse() {
        System.out.println(Arrays.toString(inOrderTraverseArray()));
    }

    private Object[] inOrderTraverseArray() {
        if (isEmpty()) {
            return EMPTY_ARRAY;
        }
        List<K> result = new ArrayList<>(size);
        inOrderTraverseNode(root, result);
        return result.toArray();
    }

    private void inOrderTraverseNode(Node<K> node, List<K> result) {
        if (node.left != null) {
            inOrderTraverseNode(node.left, result);
        }
        result.add(node.key);
        if (node.right != null) {
            inOrderTraverseNode(node.right, result);
        }
    }

    @Override
    public void preOrderTraverse() {
        System.out.println(Arrays.toString(preOrderTraverseArray()));
    }

    private Object[] preOrderTraverseArray() {
        if (isEmpty()) {
            return EMPTY_ARRAY;
        }
        List<K> result = new ArrayList<>(size);
        preOrderTraverse(root, result);
        return result.toArray();
    }

    private void preOrderTraverse(Node<K> node, List<K> result) {
        result.add(node.key);
        if (node.left != null) {
            preOrderTraverse(node.left, result);
        }
        if (node.right != null) {
            preOrderTraverse(node.right, result);
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.println(Arrays.toString(postOrderTraverseArray()));
    }

    private Object[] postOrderTraverseArray() {
        if (isEmpty()) {
            return EMPTY_ARRAY;
        }
        List<K> result = new ArrayList<>(size);
        postOrderTraverse(root, result);
        return result.toArray();
    }

    private void postOrderTraverse(Node<K> node, List<K> result) {
        if (node.left != null) {
            postOrderTraverse(node.left, result);
        }
        if (node.right != null) {
            postOrderTraverse(node.right, result);
        }
        result.add(node.key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public K min() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return (K)inOrderTraverseArray()[0];
    }

    @SuppressWarnings("unchecked")
    @Override
    public K max() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return (K)inOrderTraverseArray()[size - 1];
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "BinarySearchTree [" + (root != null ? "root=" + root + ", " : "") + "size=" + size + "]";
    }

    private static class Node<K> {
        K key;
        Node<K> left;
        Node<K> right;

        public Node(K key) {
            this.key = key;
        }

        /** clear to let GC do its work */
        void clear() {
            key = null;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "Node [" + (key != null ? "k=" + key + ", " : "") + (left != null ? "l=" + left + ", " : "")
                + (right != null ? "r=" + right : "") + "]";
        }

    }

    @Override
    public Iterator<K> iterator() {
        return new Itr();
    }

    @SuppressWarnings("unchecked")
    @Override
    public K[] toArray() {
        return (K[])inOrderTraverseArray();
    }

    private List<K> toList() {
        return new ArrayList<K>(toArray());
    }

    private class Itr implements Iterator<K> {

        List<K> list = toList();
        int index = 0;
        int lastIndex = -1;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public K next() {
            lastIndex = index;
            return list.get(index++);
        }

        @Override
        public void remove() {
            list.remove(lastIndex);
            index = lastIndex;
        }

    }

}
