package com.whg.dataStructure.collection.queue;

import java.util.Arrays;

import com.whg.dataStructure.collection.list.ArrayList;

public class ArrayQueue<E> extends ArrayList<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 2;

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
