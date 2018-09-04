package com.whg.dataStructure.impl;

import java.util.Arrays;

import com.whg.dataStructure.Stack;

public class ArrayStack<E> extends ArrayList<E> implements Stack<E> {

    private static final int CAPACITY = 8;

    public ArrayStack() {
        super(CAPACITY);
    }

    public ArrayStack(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return "ArrayStack [array=" + Arrays.toString(array) + ", size=" + size + "]";
    }

}
