package com.whg.dataStructure.set;

import com.whg.dataStructure.Collection;

public interface Set<E> extends Collection<E> {

    final Object NONE = new Object();

    @Override
    default boolean add(E e) {
        throw new UnsupportedOperationException("add");
    }

    @Override
    default boolean remove(E e) {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    default void clear() {
        throw new UnsupportedOperationException("clear");
    }

}
