package com.whg.grokkingAlgorithms;

import static com.whg.grokkingAlgorithms.SortUtil.bubbleSort;
import static com.whg.grokkingAlgorithms.SortUtil.insertionSort;
import static com.whg.grokkingAlgorithms.SortUtil.mergeSort;
import static com.whg.grokkingAlgorithms.SortUtil.quickSort;
import static com.whg.grokkingAlgorithms.SortUtil.selectionSort;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortUtilTest {

    @Before
    public void before() {
        System.out.println("SortUtilTest before");
    }

    @Test
    public void test() {
        assertTrue(Arrays.equals(bubbleSort(new Integer[] { 3, 5, 2, 1, 4 }), new Integer[] { 1, 2, 3, 4, 5 }));
        assertTrue(Arrays.equals(bubbleSort(new Integer[] { 5, 4, 3, 2, 1 }), new Integer[] { 1, 2, 3, 4, 5 }));
        assertTrue(Arrays.equals(bubbleSort(new Integer[] { 1, 2, 3, 4, 5 }), new Integer[] { 1, 2, 3, 4, 5 }));

        assertTrue(Arrays.equals(selectionSort(new Integer[] { 3, 5, 2, 1, 4 }), new Integer[] { 1, 2, 3, 4, 5 }));
        assertTrue(Arrays.equals(selectionSort(new Integer[] { 5, 4, 3, 2, 1 }), new Integer[] { 1, 2, 3, 4, 5 }));
        assertTrue(Arrays.equals(selectionSort(new Integer[] { 1, 2, 3, 4, 5 }), new Integer[] { 1, 2, 3, 4, 5 }));

        assertTrue(Arrays.equals(insertionSort(new Integer[] { 3, 5, 1, 4, 2 }), new Integer[] { 1, 2, 3, 4, 5 }));
        assertTrue(Arrays.equals(insertionSort(new Integer[] { 5, 4, 3, 2, 1 }), new Integer[] { 1, 2, 3, 4, 5 }));
        assertTrue(Arrays.equals(insertionSort(new Integer[] { 1, 2, 3, 4, 5 }), new Integer[] { 1, 2, 3, 4, 5 }));

        assertTrue(Arrays.equals(mergeSort(new Integer[] { 6, 3, 5, 1, 4, 2, 8, 7 }), new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        assertTrue(Arrays.equals(mergeSort(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }), new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        assertTrue(Arrays.equals(mergeSort(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }), new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }));

        assertTrue(Arrays.equals(quickSort(new Integer[] { 3, 5, 1, 6, 4, 7, 2 }), new Integer[] { 1, 2, 3, 4, 5, 6, 7 }));
        assertTrue(Arrays.equals(quickSort(new Integer[] { 7, 6, 5, 4, 3, 2, 1 }), new Integer[] { 1, 2, 3, 4, 5, 6, 7 }));
        assertTrue(Arrays.equals(quickSort(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }), new Integer[] { 1, 2, 3, 4, 5, 6, 7 }));

        assertTrue(Arrays.equals(quickSort(new Integer[] { 3, 5, 2, 1, 4 }), new Integer[] { 1, 2, 3, 4, 5 }));
        assertTrue(Arrays.equals(quickSort(new Integer[] { 10, 5, 2, 3 }), new Integer[] { 2, 3, 5, 10 }));

        assertTrue(Arrays.equals(quickSort(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }), new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        assertTrue(Arrays.equals(quickSort(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }), new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        assertTrue(Arrays.equals(quickSort(new Integer[] { 7, 8, 3, 5, 4, 6, 1, 2 }), new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
    }

    @After
    public void after() {
        System.out.println("SortUtilTest after");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new Integer[] { 3, 5, 2, 1, 4 })));
        System.out.println(Arrays.toString(bubbleSort(new Integer[] { 5, 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(bubbleSort(new Integer[] { 1, 2, 3, 4, 5 })));

        System.out.println(Arrays.toString(selectionSort(new Integer[] { 3, 5, 2, 1, 4 })));
        System.out.println(Arrays.toString(selectionSort(new Integer[] { 5, 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(selectionSort(new Integer[] { 1, 2, 3, 4, 5 })));

        System.out.println(Arrays.toString(insertionSort(new Integer[] { 3, 5, 1, 4, 2 })));
        System.out.println(Arrays.toString(insertionSort(new Integer[] { 5, 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(insertionSort(new Integer[] { 1, 2, 3, 4, 5 })));

        System.out.println(Arrays.toString(mergeSort(new Integer[] { 6, 3, 5, 1, 4, 2, 8, 7 })));
        System.out.println(Arrays.toString(mergeSort(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(mergeSort(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 })));

        System.out.println(Arrays.toString(quickSort(new Integer[] { 3, 5, 1, 6, 4, 7, 2 })));
        System.out.println(Arrays.toString(quickSort(new Integer[] { 7, 6, 5, 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(quickSort(new Integer[] { 1, 2, 3, 4, 5, 6, 7 })));
    }

}
