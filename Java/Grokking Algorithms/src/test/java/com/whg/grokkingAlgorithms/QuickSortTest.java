package com.whg.grokkingAlgorithms;

import static com.whg.grokkingAlgorithms.ch04.QuickSort.quickSort;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
    @Before
    public void before() {
        System.out.println("QuickSortTest before");
    }

    @Test
    public void test() {
        assertTrue(Arrays.equals(quickSort(new Integer[] {3, 5, 2, 1, 4}), new Integer[] {1, 2, 3, 4, 5}));
        assertTrue(Arrays.equals(quickSort(new Integer[] {10, 5, 2, 3}), new Integer[] {2, 3, 5, 10}));

        assertTrue(
            Arrays.equals(quickSort(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}), new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}));
        assertTrue(
            Arrays.equals(quickSort(new Integer[] {8, 7, 6, 5, 4, 3, 2, 1}), new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}));
        assertTrue(
            Arrays.equals(quickSort(new Integer[] {7, 8, 3, 5, 4, 6, 1, 2}), new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}));
    }

    @After
    public void after() {
        System.out.println("QuickSortTest after");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new Integer[] {3, 5, 2, 1, 4})));
        System.out.println(Arrays.toString(quickSort(new Integer[] {10, 5, 2, 3})));

        System.out.println(Arrays.toString(quickSort(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(quickSort(new Integer[] {8, 7, 6, 5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(quickSort(new Integer[] {7, 8, 3, 5, 4, 6, 1, 2})));
    }

}
