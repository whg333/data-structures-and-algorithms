package com.whg.dataStructure.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import com.whg.dataStructure.collection.Collection;
import com.whg.dataStructure.collection.list.ArrayList;
import com.whg.dataStructure.collection.list.LinkedList;
import com.whg.dataStructure.collection.list.List;

public class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 8;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    protected LinkedList<Entry<K, V>>[] array;
    protected int size;

    protected final float loadFactor;

    public HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int capacity, float loadFactor) {
        this.array = new LinkedList[capacity];
        this.loadFactor = loadFactor;
    }

    @Override
    public V put(K k, V v) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(v);
        Entry<K, V> oldEntry = getEntry(k);
        if (oldEntry != null) {
            // if found then replace and return old value
            V old = oldEntry.value();
            oldEntry.value(v);
            return old;
        }

        addNewEntry(k, v);
        return null;
    }

    private void addNewEntry(K k, V v) {
        checkThreshold(size + 1);

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
    }

    private void checkThreshold(int size) {
        float threshold = 1f * size / array.length;
        if (threshold <= loadFactor) {
            return;
        }

        Collection<Entry<K, V>> entries = entries();
        clear();
        // grow capacity and rehash
        array = Arrays.copyOf(array, array.length + (array.length >> 1));
        for (Entry<K, V> entry : entries) {
            put(entry.key(), entry.value());
        }
    }

    @Override
    public V remove(K k) {
        Objects.requireNonNull(k);
        int hash = hash(k);
        if (array[hash] == null) {
            return null;
        }

        Iterator<Entry<K, V>> itr = array[hash].iterator();
        V old = null;
        boolean removed = false;
        while (itr.hasNext()) {
            Entry<K, V> entry = itr.next();
            if (entry.key().equals(k)) {
                old = entry.value();
                itr.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            if (array[hash].isEmpty()) {
                array[hash] = null;
            }
            size--;
        }
        return old;
    }

    @Override
    public V get(K k) {
        Entry<K, V> entry = getEntry(k);
        return entry == null ? null : entry.value();
    }

    protected Entry<K, V> getEntry(K k) {
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
        List<Entry<K, V>> entryies = new ArrayList<>(size);
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

    public static class Entry<K, V> {

        private final K k;
        private V v;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K key() {
            return k;
        }

        public V value() {
            return v;
        }

        public void value(V v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return "Entry [k=" + k + ", v=" + v + "]";
        }

    }

}
