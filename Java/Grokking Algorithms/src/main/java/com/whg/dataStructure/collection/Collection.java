package com.whg.dataStructure.collection;

import java.util.Iterator;

import com.whg.dataStructure.Container;

public interface Collection<E> extends Container, Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean has(E e);

    @Override
    Iterator<E> iterator();

    E[] toArray();

}
