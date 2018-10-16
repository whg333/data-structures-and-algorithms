package com.whg.dataStructure.nolinear.map;

import com.whg.dataStructure.Collection;
import com.whg.dataStructure.Container;
import com.whg.dataStructure.linear.list.ArrayList;
import com.whg.dataStructure.linear.list.List;
import com.whg.dataStructure.nolinear.map.HashMap.Entry;
import com.whg.dataStructure.set.HashSet;
import com.whg.dataStructure.set.Set;

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

    default Set<K> keySet() {
        Set<K> keySet = new HashSet<>(size());
        for (Entry<K, V> entry : entries()) {
            keySet.add(entry.key());
        }
        return keySet;
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
