package com.whg.dataStructure;

import java.util.Iterator;

public interface Collection<E> extends Container, Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean contains(E e);

    @Override
    Iterator<E> iterator();

    E[] toArray();

}
