package com.whg.dataStructure;

public interface Collection<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean has(E e);

    void clear();

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

    Iterator<E> iterator();

}
