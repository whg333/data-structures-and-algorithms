package com.whg.dataStructure;

import java.util.Iterator;

public interface Collection<E> extends Container, Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean contains(E e);

    @SuppressWarnings("unchecked")
    default E[] toArray() {
        E[] array = (E[]) new Object[size()];
        Iterator<E> itr = iterator();
        for (int i = 0; itr.hasNext(); i++) {
            array[i] = itr.next();
        }
        return array;
    }

    @Override
    Iterator<E> iterator();

}
