package com.whg.dataStructure.linear.stack;

import java.util.Arrays;
import java.util.Iterator;

import com.whg.dataStructure.linear.list.List;

public class FixedArrayStack<E> implements Stack<E> {

    private static final int DEFAULT_CAPACITY = 8;

    private final E[] array;
    private final int capacity;
    private int size;

    public FixedArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public FixedArrayStack(int capacity) {
        this.array = (E[])new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean add(int index, E e) {
        checkIndexForAdd(index);
        if (isFull()) {
            throw new UnsupportedOperationException("is full");
        }
        array[size++] = e;
        return true;
    }

    private void checkIndexForAdd(int index) {
        if (index != size) {
            throw new UnsupportedOperationException("index must equals " + size);
        }
    }

    private boolean isFull() {
        return size >= capacity - 1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E old = get(index);
        array[--size] = null; // clear to let GC do its work
        return old;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    private void checkIndex(int index) {
        if (index != size - 1) {
            throw new UnsupportedOperationException("index must equals " + (size - 1) + "!");
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null; // clear to let GC do its work
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "FixedArrayStack [array=" + Arrays.toString(array) + ", size=" + size + ", capacity=" + capacity + "]";
    }

    @Override
    public List<E> newInstance() {
        return new FixedArrayStack<>();
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseItr();
    }

    protected class ReverseItr implements Iterator<E> {

        int index = size() - 1;
        int lastIndex = -1;

        public ReverseItr() {

        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public E next() {
            lastIndex = index;
            return array[index--];
        }

        @Override
        public void remove() {
            FixedArrayStack.this.remove(lastIndex);
        }

    }

}
