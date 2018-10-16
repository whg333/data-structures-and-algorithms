package com.whg.dataStructure.set;

import java.util.Arrays;
import java.util.Iterator;

import com.whg.dataStructure.linear.list.ArrayList;
import com.whg.dataStructure.linear.list.List;

public class ListSet<E> implements Set<E> {

    private static final int DEFAULT_CAPACITY = 8;

    private final List<E> list;

    public ListSet() {
        this(DEFAULT_CAPACITY);
    }

    public ListSet(int capacity) {
        list = new ArrayList<>(capacity);
    }

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        list.add(e);
        return true;
    }

    @Override
    public boolean remove(E e) {
        if (!contains(e)) {
            return false;
        }
        return list.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "ListSet [data=" + Arrays.toString(toArray()) + ", size=" + size() + "]";
    }

}
