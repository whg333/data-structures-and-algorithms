package com.whg.dataStructure.impl;

import java.util.Arrays;

import com.whg.dataStructure.Iterator;
import com.whg.dataStructure.Stack;

public class ArrayStack<E> extends ArrayList<E> implements Stack<E> {

    private static final int DEFAULT_CAPACITY = 8;

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
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        int index = isEmpty() ? -1 : size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public E next() {
            return get(index--);
        }

    }

}
