package com.whg.dataStructure.impl;

import java.util.Arrays;
import java.util.Iterator;

import com.whg.dataStructure.Stack;

public class ArrayStack<E> extends ArrayList<E> implements Stack<E> {

    private static final int DEFAULT_CAPACITY = 2;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return "ArrayStack [array=" + Arrays.toString(array) + ", size=" + size + ", capacity=" + array.length + "]";
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseItr();
    }

}
