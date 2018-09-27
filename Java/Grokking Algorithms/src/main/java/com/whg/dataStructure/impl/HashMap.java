package com.whg.dataStructure.impl;

import java.util.Objects;

import com.whg.dataStructure.Collection;
import com.whg.dataStructure.Entry;
import com.whg.dataStructure.List;
import com.whg.dataStructure.Map;

public class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 8;

    private Entry<K, V>[] array;
    protected int size;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        array = (Entry<K, V>[]) new Object[capacity];
    }

    @Override
    public V put(K k, V v) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(v);
        V old = get(k);
        if (old == null) {
            array[hash(k)] = new Entry<>(k, v);
        } else {
            array[hash(k)].value(v);
        }
        size++;
        return old;
    }

    @Override
    public V remove(K k) {
        V old = get(k);
        array[hash(k)] = null;
        size--;
        return old;
    }

    @Override
    public V get(K k) {
        int hash = hash(k);
        return array[hash] == null ? null : array[hash].value();
    }

    private int hash(K k) {
        return Objects.hashCode(k) % array.length;
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
    public Collection<Entry<K, V>> entries() {
        List<Entry<K, V>> entryies = new ArrayList<>(array.length);
        for (Entry<K, V> entry : array) {
            if (entry == null) {
                continue;
            }
            entryies.add(entry);
        }
        return entryies;
    }

}
