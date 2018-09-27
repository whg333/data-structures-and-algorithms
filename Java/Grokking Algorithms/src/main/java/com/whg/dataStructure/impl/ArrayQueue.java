package com.whg.dataStructure.impl;

import java.util.Arrays;

import com.whg.dataStructure.Queue;

public class ArrayQueue<E> extends ArrayList<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 8;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return "ArrayQueue [array=" + Arrays.toString(array) + ", size=" + size + ", capacity=" + array.length + "]";
    }

}
