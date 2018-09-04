package com.whg.dataStructure;

import java.util.EmptyStackException;

public interface Stack<E> extends List<E> {

    @SuppressWarnings("unchecked")
    default void push(E... elements) {
        for (E e : elements) {
            add(e);
        }
    }

    default E pop() {
        E e = peek();
        remove(e);
        return e;
    }

    default E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return get(size() - 1);
    }

}
