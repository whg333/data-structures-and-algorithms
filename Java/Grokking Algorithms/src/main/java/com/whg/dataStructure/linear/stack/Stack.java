package com.whg.dataStructure.linear.stack;

import java.util.Iterator;

import com.whg.dataStructure.linear.list.List;

public interface Stack<E> extends List<E> {

    @SuppressWarnings("unchecked")
    default void push(E... elements) {
        for (E e : elements) {
            addLast(e);
        }
    }

    default E pop() {
        return removeLast();
    }

    default E peek() {
        return getLast();
    }

    @Override
    default E set(int index, E e) {
        throw new UnsupportedOperationException("set");
    }

    @Override
    default Iterator<E> reverseIterator() {
        throw new UnsupportedOperationException("reverseIterator");
    }

}
