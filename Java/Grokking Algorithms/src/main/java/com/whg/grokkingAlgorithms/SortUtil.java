package com.whg.grokkingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortUtil {

    private static Random random = new Random();

    public static <T extends Number> T[] bubbleSort(T[] array) {
        return bubbleSort(Arrays.asList(array)).toArray(array);
    }

    public static <T extends Number> List<T> bubbleSort(List<T> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            // size-1是因为倒数第二排好序后最后一项自然也就排好序了
            // -i是因为外循环每次都确保最大值已经往后排好序了，不需要再次检查后面排好序的了
            for (int j = 0; j < size - 1 - i; j++) {
                if (compare(list.get(j), list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
        return list;
    }

    public static <T extends Number> T[] selectionSort(T[] array) {
        return selectionSort(Arrays.asList(array)).toArray(array);
    }

    public static <T extends Number> List<T> selectionSort(List<T> list) {
        int size = list.size();
        // size-1是因为倒数第二排好序后最后一项自然也就排好序了
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            // 往后查找，每次都从i+1之后对比查找最小值
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
        return insertionSort(Arrays.asList(array)).toArray(array);
    }

    public static <T extends Number> List<T> insertionSort(List<T> list) {
        int size = list.size();
        for (int i = 1; i < size; i++) {
            int insertIndex = i;
            // 往前查找，发现前面有较大的值则插入交换
            for (int j = i - 1; j >= 0; j--) {
                if (compare(list.get(j), list.get(insertIndex)) > 0) {
                    swap(list, insertIndex, j);
                    insertIndex = j;
                }
            }
        }
        return list;
    }

    public static <T extends Number> T[] mergeSort(T[] array) {
        return mergeSort(Arrays.asList(array)).toArray(array);
    }

    public static <T extends Number> List<T> mergeSort(List<T> list) {
        int size = list.size();
        if (size <= 1) {
            return list;
        }

        int middleIndex = (int) Math.floor(size >> 1);
        List<T> left = list.subList(0, middleIndex);
        List<T> right = list.subList(middleIndex, size);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static <T extends Number> List<T> merge(List<T> left, List<T> right) {
        int leftSize = left.size(), rightSize = right.size();
        List<T> result = new ArrayList<>(leftSize + rightSize);
        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }
        while (leftIndex < leftSize) {
            result.add(left.get(leftIndex++));
        }
        while (rightIndex < rightSize) {
            result.add(right.get(rightIndex++));
        }
        return result;
    }

    public static <T extends Number> T[] quickSort(T[] array) {
        List<T> list = Arrays.asList(array);
        quickSort(list, 0, array.length - 1);
        return list.toArray(array);
    }

    public static <T extends Number> void quickSort(List<T> list, int left, int right) {
        int size = list.size();
        if (size <= 1) {
            return;
        }

        int partIndex = partition(list, left, right);
        if (left < partIndex - 1) {
            quickSort(list, left, partIndex - 1);
        }
        if (partIndex < right) {
            quickSort(list, partIndex, right);
        }
    }

    public static <T extends Number> int partition(List<T> list, int left, int right) {
        // 随机选择基准值就能达到快速排序的平均情况（也是最佳情况）而不是最糟情况
        int pivotIndex = /* (int)Math.floor((left + right) >> 1); */ left + random.nextInt(right - left);
        T pivot = list.get(pivotIndex);

        int leftIndex = left, rightIndex = right;
        while (leftIndex <= rightIndex) {
            while (compare(list.get(leftIndex), pivot) < 0) {
                leftIndex++;
            }
            while (compare(list.get(rightIndex), pivot) > 0) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                if (leftIndex != rightIndex) {
                    // System.out.println("bf:" + Arrays.toString(list.toArray()));
                    swap(list, leftIndex, rightIndex);
                    // System.out.println("af:" + Arrays.toString(list.toArray()));
                }
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static <T extends Number> int compare(T a, T b) {
        return Long.valueOf(a.longValue()).compareTo(b.longValue());
    }

    public static <T extends Number> void swap(List<T> list, int from, int to) {
        list.set(from, list.set(to, list.get(from)));
    }

}
