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
        } else {
            addNode(root, k);
        }
        size++;
        return true;
    }

    private void addNode(Node<K> node, K k) {
        if (compare(k, node.key) < 0) {
            if (node.left == null) {
                node.left = new Node<>(k);
            } else {
                addNode(node.left, k);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(k);
            } else {
                addNode(node.right, k);
            }
        }
    }

    @Override
    public boolean remove(K k) {
        boolean result = removeNode(root, k) != null;
        if (result) {
            size--;
        }
        return result;
    }

    private Node<K> removeNode(Node<K> node, K k) {
        if (node == null) {
            return null;
        }
        int result = compare(k, node.key);
        if (result < 0) {
            node.left = removeNode(node.left, k);
        } else if (result > 0) {
            node.right = removeNode(node.right, k);
        } else {
            if (node.left == null && node.right == null) { // 没有子节点的叶子节点
                node = null;
            } else if (node.left == null || node.right == null) { // 有1个子节点的节点
                if (node.left == null) {
                    node = node.right;
                } else if (node.right == null) {
                    node = node.left;
                }
            } else { // 有2个子节点的节点
                K min = minNode(node.right);
                node.key = min;
                node.right = removeNode(node.right, min);
            }
        }
        return node;
    }

    @Override
    public boolean has(K k) {
        checkNotEmpty();
        return hasNode(root, k);
    }

    private boolean hasNode(Node<K> node, K k) {
        if (node == null) {
            return false;
        }
        int result = compare(k, node.key);
        if (result < 0) {
            return hasNode(node.left, k);
        } else if (result > 0) {
            return hasNode(node.right, k);
        } else {
            return true;
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
    public K min() {
        checkNotEmpty();
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
        checkNotEmpty();
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

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
    }

    @Override
    public void clear() {
        // 后序遍历（左右中）然后一个个删除，相当于删除的都是叶子节点
        for (K k : postOrderTraverseArray()) {
            remove(k);
        }

        // root根节点remove方法删除不掉，所以直接设置root为null和size为 0
        root = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
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
    public String toString() {
        return "BinarySearchTree [" + (root != null ? "root=" + root + ", " : "") + "size=" + size + "]";
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

        K[] array = toArray();
        int index = 0;
        int lastIndex = -1;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public K next() {
            lastIndex = index;
            return array[index++];
        }

        @Override
        public void remove() {
            BinarySearchTree.this.remove(array[lastIndex]);
            index = lastIndex;
        }

    }

    private static class Node<K> {
        K key;
        Node<K> left;
        Node<K> right;

        public Node(K key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node [" + (key != null ? "k=" + key + ", " : "") + (left != null ? "l=" + left + ", " : "")
                + (right != null ? "r=" + right : "") + "]";
        }

    }

}
