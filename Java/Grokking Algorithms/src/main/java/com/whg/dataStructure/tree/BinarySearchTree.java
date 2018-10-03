package com.whg.dataStructure.tree;

import java.util.Arrays;
import java.util.Iterator;

import com.whg.dataStructure.collection.EmptyCollectionException;
import com.whg.dataStructure.collection.list.ArrayList;
import com.whg.dataStructure.collection.list.List;

public class BinarySearchTree<K> implements Tree<K> {

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
        if (compare(k, node.key) < 0) {
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

    @SuppressWarnings("unchecked")
    private int compare(K a, K b) {
        if (a instanceof Comparable) {
            return ((Comparable<K>)a).compareTo(b);
        }
        return a.hashCode() - b.hashCode();
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

    private K[] inOrderTraverseArray() {
        List<K> result = new ArrayList<>(size);
        inOrderTraverseNode(root, result);
        return result.toArray();
    }

    private void inOrderTraverseNode(Node<K> node, List<K> result) {
        if (node != null) {
            inOrderTraverseNode(node.left, result);
            result.add(node.key);
            inOrderTraverseNode(node.right, result);
        }
    }

    @Override
    public void preOrderTraverse() {
        System.out.println(Arrays.toString(preOrderTraverseArray()));
    }

    private K[] preOrderTraverseArray() {
        List<K> result = new ArrayList<>(size);
        preOrderTraverse(root, result);
        return result.toArray();
    }

    private void preOrderTraverse(Node<K> node, List<K> result) {
        if (node != null) {
            result.add(node.key);
            preOrderTraverse(node.left, result);
            preOrderTraverse(node.right, result);
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.println(Arrays.toString(postOrderTraverseArray()));
    }

    private K[] postOrderTraverseArray() {
        List<K> result = new ArrayList<>(size);
        postOrderTraverse(root, result);
        return result.toArray();
    }

    private void postOrderTraverse(Node<K> node, List<K> result) {
        if (node != null) {
            postOrderTraverse(node.left, result);
            postOrderTraverse(node.right, result);
            result.add(node.key);
        }
    }

    @Override
    public K min() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        // return inOrderTraverseArray()[0];
        return minNode(root);
    }

    private K minNode(Node<K> node) {
        K min = node.key;
        while (node.left != null) {
            min = node.left.key;
            node = node.left;
        }
        return min;
    }

    @Override
    public K max() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        // return inOrderTraverseArray()[size - 1];
        return maxNode(root);
    }

    private K maxNode(Node<K> node) {
        K max = node.key;
        while (node.right != null) {
            max = node.right.key;
            node = node.right;
        }
        return max;
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

    @Override
    public K[] toArray() {
        return inOrderTraverseArray();
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
