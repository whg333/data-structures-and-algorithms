package com.whg.dataStructure.tree;

public class AdelsonVelskiiLandiTree<K> extends BinarySearchTree<K> {

    @Override
    protected void afterAddLeftNode(Node<K> node) {
        if (heightNode(node.left) - heightNode(node.right) > 1) {

        }
    }

    @Override
    protected void afterAddRightNode(Node<K> node) {
        if (heightNode(node.right) - heightNode(node.left) > 1) {

        }
    }

    private int heightNode(Node<K> node) {
        if (node == null) {
            return -1;
        }
        return Math.max(heightNode(node.left), heightNode(node.right)) + 1;
    }

}
