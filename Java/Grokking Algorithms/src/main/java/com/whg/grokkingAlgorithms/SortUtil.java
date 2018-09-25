package com.whg.grokkingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortUtil {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new Integer[] { 3, 5, 2, 1, 4 })));
        System.out.println(Arrays.toString(bubbleSort(new Integer[] { 5, 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(bubbleSort(new Integer[] { 1, 2, 3, 4, 5 })));

        System.out.println(Arrays.toString(selectionSort(new Integer[] { 3, 5, 2, 1, 4 })));
        System.out.println(Arrays.toString(selectionSort(new Integer[] { 5, 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(selectionSort(new Integer[] { 1, 2, 3, 4, 5 })));
    }

    public static <T extends Number> T[] bubbleSort(T[] array) {
        return bubbleSort(new ArrayList<>(Arrays.asList(array))).toArray(array);
    }

    public static <T extends Number> List<T> bubbleSort(List<T> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (compare(list.get(j), list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
        return list;
    }

    public static <T extends Number> T[] selectionSort(T[] array) {
        return selectionSort(new ArrayList<>(Arrays.asList(array))).toArray(array);
    }

    public static <T extends Number> List<T> selectionSort(List<T> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (compare(list.get(minIndex), list.get(j)) > 0) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(list, i, minIndex);
            }
        }
        return list;
    }

    public static <T extends Number> T[] insertionSort(T[] array) {
        return insertionSort(new ArrayList<>(Arrays.asList(array))).toArray(array);
    }

    public static <T extends Number> List<T> insertionSort(List<T> list) {
        int size = list.size();
        return list;
    }

    public static <T extends Number> int compare(T a, T b) {
        return Long.valueOf(a.longValue()).compareTo(b.longValue());
    }

    public static <T extends Number> void swap(List<T> list, int from, int to) {
        list.set(from, list.set(to, list.get(from)));
    }

}
