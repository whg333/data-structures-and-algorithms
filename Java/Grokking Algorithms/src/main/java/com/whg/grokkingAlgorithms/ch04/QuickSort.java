package com.whg.grokkingAlgorithms.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {
	
	private static Random random = new Random();

	public static void main(String[] args) {
		System.out.println(Arrays.toString(quickSort(new Integer[]{3, 5, 2, 1, 4})));
		System.out.println(Arrays.toString(quickSort(new Integer[]{10, 5, 2, 3})));
		
		System.out.println(Arrays.toString(quickSort(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8})));
		System.out.println(Arrays.toString(quickSort(new Integer[]{8, 7, 6, 5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(quickSort(new Integer[]{7, 8, 3, 5, 4, 6, 1, 2})));
	}
	
	public static <T extends Number> T[] quickSort(T[] array){
		return quickSort(new ArrayList<>(Arrays.asList(array))).toArray(array);
	}
	
	public static <T extends Number> List<T> quickSort(List<T> list){
		int size = list.size();
		if(size <= 1){
			return list;
		}
		
		//随机选择基准值就能达到快速排序的平均情况（也是最佳情况）而不是最糟情况
		int randomIndex = random.nextInt(size);
		T pivot = list.remove(randomIndex);
		List<T> less = new ArrayList<>(size);
		List<T> greater = new ArrayList<>(size);
		for(T t:list){
			if(t.longValue() <= pivot.longValue()){
				less.add(t);
			}else{
				greater.add(t);
			}
		}
		
		List<T> result = new ArrayList<>(size);
		result.addAll(quickSort(less));
		result.add(pivot);
		result.addAll(quickSort(greater));
		return result;
	}
	
}
