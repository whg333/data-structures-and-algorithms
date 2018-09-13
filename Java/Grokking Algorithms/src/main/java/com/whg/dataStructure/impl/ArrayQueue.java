package com.whg.dataStructure.impl;

import java.util.Arrays;

import com.whg.dataStructure.Queue;

public class ArrayQueue<E> extends ArrayList<E> implements Queue<E> {

    private static final int CAPACITY = 2;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return "ArrayQueue [array=" + Arrays.toString(array) + ", size=" + size + "]";
    }

}
