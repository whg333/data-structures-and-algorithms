package com.whg.dataStructure.nolinear.tree;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whg.dataStructure.nolinear.tree.AdelsonVelskiiLandiTree;
import com.whg.dataStructure.nolinear.tree.Tree;

public class AdelsonVelskiiLandiTreeTest {

    @Before
    public void before() {
        System.out.println("AdelsonVelskiiLandiTreeTest before");
    }

    @Test
    public void test() {
        testAdelsonVelskiiLandiTree(new AdelsonVelskiiLandiTree<>());
    }

    private void testAdelsonVelskiiLandiTree(Tree<Integer> tree) {
        Object[] traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));

        tree.add(50);
        System.out.println(tree);
        tree.add(30);
        System.out.println(tree);
        tree.add(70);
        System.out.println(tree);
        tree.add(60);
        tree.add(80);
        System.out.println(tree);
        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 30, 50, 60, 70, 80 }));

        tree.add(90);
        System.out.println(tree);
        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 30, 50, 60, 70, 80, 90 }));

        System.out.println(" ------------ clear ------------ ");
        tree.clear();
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(10);
        tree.add(40);
        System.out.println(tree);
        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 10, 30, 40, 50, 70 }));

        tree.add(5);
        System.out.println(tree);
        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 5, 10, 30, 40, 50, 70 }));

        System.out.println(" ------------ clear ------------ ");
        tree.clear();
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(10);
        tree.add(40);
        System.out.println(tree);
        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 10, 30, 40, 50, 70 }));

        tree.add(35);
        System.out.println(tree);
        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 10, 30, 35, 40, 50, 70 }));

        System.out.println(" ------------ clear ------------ ");
        tree.clear();
        tree.add(70);
        tree.add(50);
        tree.add(80);
        tree.add(72);
        tree.add(90);
        System.out.println(tree);
        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 50, 70, 72, 80, 90 }));

        tree.add(75);
        System.out.println(tree);
        traverse = tree.inOrderTraverse();
        System.out.println(Arrays.toString(traverse));
        assertTrue(Arrays.equals(traverse, new Integer[] { 50, 70, 72, 75, 80, 90 }));
    }

    @After
    public void after() {
        System.out.println("AdelsonVelskiiLandiTreeTest after");
    }

}
