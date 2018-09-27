package com.whg.dataStructure;

public interface Collection<E> extends Container {

    boolean add(E e);

    boolean remove(E e);

    boolean has(E e);

    Iterator<E> iterator();

    Iterator<E> reverseIterator();

}
