package com.whg.dataStructure.tree;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Before
    public void before() {
        System.out.println("BinarySearchTreeTest before");
    }

    @Test
    public void test() {
        testBinarySearchTree(new BinarySearchTree<>());
    }

    private void testBinarySearchTree(BinarySearchTree<Integer> tree) {
        tree.inOrderTraverse();

        tree.add(11);
        System.out.println(tree);
        tree.add(7);
        System.out.println(tree);
        tree.add(15);
        System.out.println(tree);
        tree.add(5);
        tree.add(3);
        tree.add(9);
        tree.add(8);
        tree.add(10);
        System.out.println(tree);
        tree.inOrderTraverse();

        tree.add(13);
        tree.add(12);
        tree.add(14);
        tree.add(20);
        tree.add(18);
        tree.add(25);
        System.out.println(tree);
        tree.add(6);
        System.out.println(tree);

        tree.inOrderTraverse();

        tree.preOrderTraverse();

        tree.postOrderTraverse();

        System.out.println(tree.min());
        System.out.println(tree.max());

        Iterator<Integer> itr = tree.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();

        System.out.println(tree.has(18));
        System.out.println(tree.has(9));
        System.out.println(tree.has(11));
        System.out.println(tree.has(3));
        System.out.println(tree.has(25));
        System.out.println(tree.has(1));
        System.out.println(tree.has(2));

        tree.remove(6);
        System.out.println(tree);
        // tree.add(6);
        // System.out.println(tree);

        tree.remove(5);
        System.out.println(tree);

        tree.remove(15);
        System.out.println(tree);

        tree.inOrderTraverse();

        tree.postOrderTraverse();
        tree.clear();
        System.out.println(tree);
        tree.inOrderTraverse();
    }

    @After
    public void after() {
        System.out.println("BinarySearchTreeTest after");
    }

}
