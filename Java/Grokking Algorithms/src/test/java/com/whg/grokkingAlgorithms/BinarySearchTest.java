package com.whg.grokkingAlgorithms;

import static com.whg.grokkingAlgorithms.ch01.BinarySearch.binarySearch;
import static com.whg.grokkingAlgorithms.ch01.BinarySearch.recursionBinarySearch;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    @Before
    public void before() {
        System.out.println("BinarySearchTest before");
    }

    @Test
    public void test() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertTrue(binarySearch(array, 1) == 0);
        assertTrue(binarySearch(array, 3) == 2);
        assertTrue(binarySearch(array, 5) == 4);
        assertTrue(binarySearch(array, 7) == 6);
        assertTrue(binarySearch(array, 9) == 8);
        assertTrue(binarySearch(array, 10) == -1);

        assertTrue(recursionBinarySearch(array, 1) == 0);
        assertTrue(recursionBinarySearch(array, 3) == 2);
        assertTrue(recursionBinarySearch(array, 5) == 4);
        assertTrue(recursionBinarySearch(array, 7) == 6);
        assertTrue(recursionBinarySearch(array, 9) == 8);
        assertTrue(recursionBinarySearch(array, 10) == -1);
    }

    @After
    public void after() {
        System.out.println("BinarySearchTest after");
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(array, 1));
        System.out.println(binarySearch(array, 3));
        System.out.println(binarySearch(array, 5));
        System.out.println(binarySearch(array, 7));
        System.out.println(binarySearch(array, 9));
        System.out.println(binarySearch(array, 10));

        System.out.println("\n ------------------ \n");

        System.out.println(recursionBinarySearch(array, 1));
        System.out.println(recursionBinarySearch(array, 3));
        System.out.println(recursionBinarySearch(array, 5));
        System.out.println(recursionBinarySearch(array, 7));
        System.out.println(recursionBinarySearch(array, 9));
        System.out.println(recursionBinarySearch(array, 10));
    }

}
