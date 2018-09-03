package com.whg.dataStructure.impl;

import java.util.Arrays;

import com.whg.dataStructure.IStack;

public class ArrayStack<E> implements IStack<E>{
	
	private static final int DEFAULT_SIZE = 8; 
	
	private final int initCapacity;
	private int capacity;
	private E[] array;
	
	public ArrayStack() {
		this(DEFAULT_SIZE);
	}
	
	public ArrayStack(int initCapacity) {
		this.initCapacity = initCapacity;
		initArray(initCapacity);
		this.capacity = initCapacity;
	}
	
	@Override
	public void add(int index, E e) {
		if(index >= capacity){
			capacity *= 2;
			array = Arrays.copyOf(array, capacity);
		}
		System.arraycopy(array, index, array, index+1, size()-index);
		array[index] = e;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		return null;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return array[index];
	}

	@Override
	public E set(int index, E e) {
		checkIndex(index);
		E old = array[index];
		array[index] = e;
		return old;
	}
	
	private void checkIndex(int index){
		if(index < 0 || index >= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public void clear() {
		initArray(initCapacity);
	}
	
	@SuppressWarnings("unchecked")
	private void initArray(int initCapacity){
		array = (E[])new Object[initCapacity];
	}

	@Override
	public int size() {
		return array.length;
	}

}
