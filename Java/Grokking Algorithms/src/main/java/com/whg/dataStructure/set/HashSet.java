package com.whg.dataStructure.set;

import java.util.Arrays;
import java.util.Iterator;

import com.whg.dataStructure.nolinear.map.HashMap;
import com.whg.dataStructure.nolinear.map.Map;

public class HashSet<E> implements Set<E> {

    private static final int DEFAULT_CAPACITY = 8;

    protected Map<E, Object> map;

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
        return map.remove(e) == NONE;
    }

    @Override
    public boolean contains(E e) {
        return map.containsKey(e);
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

}
