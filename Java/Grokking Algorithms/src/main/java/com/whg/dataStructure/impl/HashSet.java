package com.whg.dataStructure.impl;

import java.util.Arrays;
import java.util.Iterator;

import com.whg.dataStructure.Map;
import com.whg.dataStructure.Set;

public class HashSet<E> implements Set<E> {

    private static final Object NONE = new Object() {
        @Override
        public String toString() {
            return "NONE";
        }
    };
    private static final int DEFAULT_CAPACITY = 8;

    private final Map<E, Object> map;

    public HashSet() {
        this(DEFAULT_CAPACITY);
    }

    public HashSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, NONE) == null;
    }

    @Override
    public boolean remove(E e) {
        return map.remove(e) != null;
    }

    @Override
    public boolean has(E e) {
        return map.hasKey(e);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keys().iterator();
    }

    @Override
    public String toString() {
        return "HashSet [data=" + Arrays.toString(toArray()) + ", size=" + size() + "]";
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size()];
        Iterator<E> itr = iterator();
        for (int i = 0; itr.hasNext(); i++) {
            array[i] = itr.next();
        }
        return array;
    }

}
