package com.whg.dataStructure.tree;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
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

    private void testBinarySearchTree(Tree<Integer> tree) {
        Object[] traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));

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
        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 3, 5, 7, 8, 9, 10, 11, 15 }));

        tree.add(13);
        tree.add(12);
        tree.add(14);
        tree.add(20);
        tree.add(18);
        tree.add(25);
        System.out.println(tree);
        tree.add(6);
        System.out.println(tree);

        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 20, 25 }));

        traverse = tree.preOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 11, 7, 5, 3, 6, 9, 8, 10, 15, 13, 12, 14, 20, 18, 25 }));

        traverse = tree.postOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 3, 6, 5, 8, 10, 9, 7, 12, 14, 13, 18, 25, 20, 15, 11 }));

        assertTrue(tree.min() == 3);
        assertTrue(tree.max() == 25);

        Iterator<Integer> itr = tree.iterator();
        Integer[] itrArray = new Integer[tree.size()];
        for (int i = 0; itr.hasNext(); i++) {
            itrArray[i] = itr.next();
        }
        assertTrue(Arrays.equals(itrArray, new Integer[] { 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 20, 25 }));

        assertTrue(tree.contains(18));
        assertTrue(tree.contains(9));
        assertTrue(tree.contains(11));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(25));
        assertTrue(!tree.contains(1));
        assertTrue(!tree.contains(2));

        assertTrue(tree.remove(6));
        System.out.println(tree);
        // tree.add(6);
        // System.out.println(tree);

        assertTrue(tree.remove(5));
        System.out.println(tree);

        assertTrue(tree.remove(15));
        System.out.println(tree);

        assertTrue(!tree.remove(88));
        System.out.println(tree);

        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 3, 7, 8, 9, 10, 11, 12, 13, 14, 18, 20, 25 }));

        traverse = tree.postOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 3, 8, 10, 9, 7, 12, 14, 13, 25, 20, 18, 11 }));

        tree.clear();
        System.out.println(tree);

        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] {}));
    }

    @After
    public void after() {
        System.out.println("BinarySearchTreeTest after");
    }

}
