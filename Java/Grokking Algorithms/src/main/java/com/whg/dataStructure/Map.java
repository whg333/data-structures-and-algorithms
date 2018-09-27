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
        Iterator<V> itr = values().iterator();
        while (itr.hasNext()) {
            if (itr.next().equals(v)) {
                return true;
            }
        }
        return false;
    }

    default Collection<K> keys() {
        List<K> keys = new ArrayList<>(size());
        Iterator<Entry<K, V>> itr = entries().iterator();
        while (itr.hasNext()) {
            keys.add(itr.next().key());
        }
        return keys;
    }

    default Collection<V> values() {
        List<V> values = new ArrayList<>(size());
        Iterator<Entry<K, V>> itr = entries().iterator();
        while (itr.hasNext()) {
            values.add(itr.next().value());
        }
        return values;
    }

    Collection<Entry<K, V>> entries();
}
