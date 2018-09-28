package com.whg.dataStructure;

import com.whg.dataStructure.impl.ArrayList;

public interface Map<K, V> extends Container {

    V put(K k, V v);

    V remove(K k);

    V get(K k);

    default boolean hasKey(K k) {
        return get(k) != null;
    }

    default boolean hasValue(V v) {
        for (V value : values()) {
            if (value.equals(v)) {
                return true;
            }
        }
        return false;
    }

    default Collection<K> keys() {
        List<K> keys = new ArrayList<>(size());
        for (Entry<K, V> entry : entries()) {
            keys.add(entry.key());
        }
        return keys;
    }

    default Collection<V> values() {
        List<V> values = new ArrayList<>(size());
        for (Entry<K, V> entry : entries()) {
            values.add(entry.value());
        }
        return values;
    }

    Collection<Entry<K, V>> entries();
}
