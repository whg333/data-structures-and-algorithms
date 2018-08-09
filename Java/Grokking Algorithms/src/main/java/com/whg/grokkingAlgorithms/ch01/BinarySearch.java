package com.whg.grokkingAlgorithms.ch01;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
	
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
	
	@SuppressWarnings("unchecked")
	public static <T extends Number> int binarySearch(List<T> list, T t){
		return binarySearch((T[])list.toArray(), t);
	}

	public static <T extends Number> int binarySearch(T[] array, T t){
		int low = 0;
		int high = array.length - 1;
		
		while(high >= low){
			int mid = (low + high) / 2;
			long guess = array[mid].longValue();
			long target = t.longValue();
			
			if(guess == target){
				return mid;
			}else if(guess > target){
				high = mid - 1;
			}else{
				low = mid +1;
			}
		}
		
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Number> int recursionBinarySearch(List<T> list, T t){
		return recursionBinarySearch((T[])list.toArray(), t, 0);
	}
	
	public static <T extends Number> int recursionBinarySearch(T[] array, T t){
		return recursionBinarySearch(array, t, 0);
	}
	
	/** 递归分而治之的二分查找，需要把偏移量offset加上 */
	public static <T extends Number> int recursionBinarySearch(T[] array, T t, int offset){
		int low = 0;
		int high = array.length - 1;
		
		if(low > high){
			return -1;
		}
		
		int mid = (low + high) / 2;
		long guess = array[mid].longValue();
		long target = t.longValue();
		
		if(guess == target){
			return offset + mid;
		}else if(guess > target){
			high = mid - 1;
			return recursionBinarySearch(Arrays.copyOfRange(array, low, high + 1), t, 0);
		}else{
			low = mid +1;
			//只有当猜的数小于的时候，数组往右缩小范围，需要把偏移量加上
			return recursionBinarySearch(Arrays.copyOfRange(array, low, high + 1), t, offset + low);
		}
	}
	
}
