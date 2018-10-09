package com.whg.dataStructure.map;

import com.whg.dataStructure.Container;
import com.whg.dataStructure.collection.Collection;
import com.whg.dataStructure.collection.list.ArrayList;
import com.whg.dataStructure.collection.list.List;
import com.whg.dataStructure.map.HashMap.Entry;

public interface Map<K, V> extends Container {

    V put(K k, V v);

    V remove(K k);

    V get(K k);

    default boolean containsKey(K k) {
        return get(k) != null;
    }

    default boolean containsValue(V v) {
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
