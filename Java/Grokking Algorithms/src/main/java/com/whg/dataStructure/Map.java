package com.whg.dataStructure;

public interface Map<K, V> extends Container {

    boolean put(K k, V v);

    boolean remove(K k);

    V get(K k);

    boolean hasKey(K k);

    boolean hasValue(V v);

    Set<K> keys();

    Collection<V> values();
}
