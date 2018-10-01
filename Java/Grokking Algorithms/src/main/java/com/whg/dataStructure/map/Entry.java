package com.whg.dataStructure.map;

public class Entry<K, V> {

    private K k;
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

    public V value(V v) {
        V old = this.v;
        this.v = v;
        return old;
    }

    @Override
    public String toString() {
        return "Entry [k=" + k + ", v=" + v + "]";
    }

}
