package com.whg.dataStructure.tree;

public class BinarySearchTree<E> {

    private Node<E> root;

    private static class Node<E> {
        E key;
        Node<E> left;
        Node<E> right;

        public Node(E key, Node<E> left, Node<E> right) {
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
