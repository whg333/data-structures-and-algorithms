package com.whg.dataStructure.tree;

public class AdelsonVelskiiLandiTree<K> extends BinarySearchTree<K> {

    @Override
    protected Node<K> afterAddLeftNode(Node<K> node, K k) {
        if (balanceFactor(node) > 1) {
            if (compare(k, node.left.key) < 0) {
                node = rotationLL(node);
            } else {
                node = rotationLR(node);
            }
        }
        return node;
    }

    @Override
    protected Node<K> afterAddRightNode(Node<K> node, K k) {
        if (balanceFactor(node) > 1) {
            if (compare(k, node.right.key) > 0) {
                node = rotationRR(node);
            } else {
                node = rotationRL(node);
            }
        }
        return node;
    }

    private int balanceFactor(Node<K> node) {
        return Math.abs(heightNode(node.right) - heightNode(node.left));
    }

    private int heightNode(Node<K> node) {
        if (node == null) {
            return -1;
        }
        return Math.max(heightNode(node.left), heightNode(node.right)) + 1;
    }

    private Node<K> rotationLR(Node<K> node) {
        node.left = rotationRR(node.left);
        return rotationLL(node);
    }

    private Node<K> rotationRL(Node<K> node) {
        node.right = rotationLL(node.right);
        return rotationRR(node);
    }

    private Node<K> rotationLL(Node<K> node) {
        Node<K> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        return tmp;
    }

    private Node<K> rotationRR(Node<K> node) {
        Node<K> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        return tmp;
    }

}
