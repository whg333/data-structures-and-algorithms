package com.whg.dataStructure.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import com.whg.dataStructure.Collection;
import com.whg.dataStructure.Entry;
import com.whg.dataStructure.List;
import com.whg.dataStructure.Map;

public class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 8;

    private LinkedList<Entry<K, V>>[] array;
    protected int size;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        array = new LinkedList[capacity];
    }

    @Override
    public V put(K k, V v) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(v);
        Entry<K, V> oldEntry = getEntry(k);
        if (oldEntry == null) {
            Entry<K, V> newEntry = new Entry<>(k, v);
            int hash = hash(k);
            if (array[hash] == null) {
                LinkedList<Entry<K, V>> list = new LinkedList<>();
                list.add(newEntry);
                array[hash] = list;
            } else {
                array[hash].add(newEntry);
            }
            size++;
            return null;
        } else {
            V old = oldEntry.value();
            oldEntry.value(v);
            size++;
            return old;
        }
    }

    @Override
    public V remove(K k) {
        Objects.requireNonNull(k);
        int hash = hash(k);
        Iterator<Entry<K, V>> itr = array[hash].iterator();
        V old = null;
        while (itr.hasNext()) {
            Entry<K, V> entry = itr.next();
            if (entry.key().equals(k)) {
                old = entry.value();
                itr.remove();
                break;
            }
        }

        if (array[hash].isEmpty()) {
            array[hash] = null;
        }
        size--;
        return old;
    }

    @Override
    public V get(K k) {
        Entry<K, V> entry = getEntry(k);
        return entry == null ? null : entry.value();
    }

    private Entry<K, V> getEntry(K k) {
        Objects.requireNonNull(k);
        int hash = hash(k);
        if (array[hash] == null) {
            return null;
        }
        for (Entry<K, V> entry : array[hash]) {
            if (entry.key().equals(k)) {
                return entry;
            }
        }
        return null;
    }

    private int hash(K k) {
        return Objects.hashCode(k) % array.length;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
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
        for (LinkedList<Entry<K, V>> list : array) {
            if (list == null) {
                continue;
            }
            for (Entry<K, V> entry : list) {
                entryies.add(entry);
            }
        }
        return entryies;
    }

    @Override
    public String toString() {
        return "HashMap [array=" + Arrays.toString(array) + ", size=" + size + ", capacity=" + array.length + "]";
    }

}
