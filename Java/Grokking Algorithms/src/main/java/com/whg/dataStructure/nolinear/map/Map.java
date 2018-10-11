package com.whg.dataStructure.nolinear.map;

import com.whg.dataStructure.Collection;
import com.whg.dataStructure.Container;
import com.whg.dataStructure.linear.list.ArrayList;
import com.whg.dataStructure.linear.list.List;
import com.whg.dataStructure.nolinear.map.HashMap.Entry;

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
