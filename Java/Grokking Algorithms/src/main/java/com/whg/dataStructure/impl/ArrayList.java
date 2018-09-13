package com.whg.dataStructure.impl;

import java.util.Arrays;

import com.whg.dataStructure.Iterator;
import com.whg.dataStructure.List;

public class ArrayList<E> implements List<E> {

    private static final int CAPACITY = 16;

    protected E[] array;
    protected int size;

    public ArrayList() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean add(int index, E e) {
        rangeCheckforAdd(index);
        if (size + 1 > array.length) {
            array = Arrays.copyOf(array, array.length + (array.length >> 1));
        }
        if (index != size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = e;
        size++;
        return true;
    }

    private void rangeCheckforAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    @Override
    public E remove(int index) {
        E old = get(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null; // clear to let GC do its work
        return old;
    }

    @Override
    public E set(int index, E e) {
        E old = get(index);
        array[index] = e;
        return old;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return array[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
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
        return "ArrayList [array=" + Arrays.toString(array) + ", size=" + size + "]";
    }

    @Override
    public E[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        int index;

        @Override
        public boolean hasNext() {
            return index < size - 1;
        }

        @Override
        public E next() {
            return get(index++);
        }

    }

}
