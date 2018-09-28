package com.whg.dataStructure;

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

    public void value(V v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Entry [k=" + k + ", v=" + v + "]";
    }

}
