package com.whg.dataStructure.map;

import java.util.Arrays;

import com.whg.dataStructure.collection.Collection;
import com.whg.dataStructure.collection.list.ArrayList;
import com.whg.dataStructure.collection.list.LinkedList;
import com.whg.dataStructure.collection.list.List;

public class LinkedHashMap<K, V> extends HashMap<K, V> {

    private LinkedList<K> list = new LinkedList<>();

    @Override
    public void clear() {
        super.clear();
        list.clear();
    }

    @Override
    public V put(K k, V v) {
        V old = super.put(k, v);
        if (old == null) {
            list.add(k);
        }
        return old;
    }

    @Override
    public V remove(K k) {
        V old = super.remove(k);
        if (old != null) {
            list.remove(k);
        }
        return old;
    }

    @Override
    public Collection<Entry<K, V>> entries() {
        List<Entry<K, V>> entries = new ArrayList<>(size);
        for (K k : list) {
            entries.add(getEntry(k));
        }
        return entries;
    }

    @Override
    public String toString() {
        return "LinkedHashMap [array=" + Arrays.toString(array) + ", size=" + size + ", capacity=" + array.length + "]";
    }

}
