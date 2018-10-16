package com.whg.dataStructure.nolinear.map;

import java.util.Arrays;

import com.whg.dataStructure.Collection;
import com.whg.dataStructure.linear.list.ArrayList;
import com.whg.dataStructure.linear.list.List;
import com.whg.dataStructure.nolinear.map.HashMap.Entry;

public class ListMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 8;

    protected List<K> keys;
    protected List<V> values;

    public ListMap() {
        this(DEFAULT_CAPACITY);
    }

    public ListMap(int capacity) {
        keys = new ArrayList<>(capacity);
        values = new ArrayList<>(capacity);
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public V put(K k, V v) {
        int index = keys.indexOf(k);
        if (index < 0) {
            keys.add(k);
            values.add(v);
            return null;
        }
        return values.set(index, v);
    }

    @Override
    public V remove(K k) {
        int index = keys.indexOf(k);
        if (index < 0) {
            return null;
        }
        keys.remove(index);
        return values.remove(index);
    }

    @Override
    public V get(K k) {
        int index = keys.indexOf(k);
        if (index < 0) {
            return null;
        }
        return values.get(index);
    }

    @Override
    public Collection<Entry<K, V>> entries() {
        int size = keys.size();
        List<Entry<K, V>> entries = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            entries.add(new Entry<>(keys.get(i), values.get(i)));
        }
        return entries;
    }

    @Override
    public String toString() {
        return "ListMap [array=" + Arrays.toString(entries().toArray()) + ", size=" + size() + "]";
    }

}
