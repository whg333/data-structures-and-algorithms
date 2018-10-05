package com.whg.dataStructure.tree;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

        tree.add(90);
    }

    @After
    public void after() {
        System.out.println("AdelsonVelskiiLandiTreeTest after");
    }

}
