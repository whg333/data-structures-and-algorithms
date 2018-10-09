package com.whg.dataStructure.collection.list;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 2;

    protected E[] array;
    protected int size;

    @Override
    public List<E> newInstance() {
        return new ArrayList<E>(isEmpty() ? DEFAULT_CAPACITY : size);
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        array = (E[]) new Object[capacity];
    }

    public ArrayList(E[] array) {
        this.array = array;
        this.size = array.length;
    }

    @Override
    public boolean add(int index, E e) {
        checkRangeforAdd(index);
        if (size + 1 > array.length) { // grow capacity
            array = Arrays.copyOf(array, array.length + (array.length >> 1));
        }
        if (index != size) { // move array element which after index
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = e;
        size++;
        return true;
    }

    private void checkRangeforAdd(int index) {
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
        checkRange(index);
        return array[index];
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
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
        return "ArrayList [array=" + Arrays.toString(array) + ", size=" + size + ", capacity=" + array.length + "]";
    }

    @Override
    public E[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        int index = 0;
        int lastIndex = -1;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            lastIndex = index;
            return array[index++];
        }

        @Override
        public void remove() {
            ArrayList.this.remove(lastIndex);
            index = lastIndex;
        }

    }

    @Override
    public Iterator<E> reverseIterator() {
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
            ArrayList.this.remove(lastIndex);
        }

    }

}
