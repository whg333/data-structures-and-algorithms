package com.whg.dataStructure.collection.stack;

import com.whg.dataStructure.collection.list.List;

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

}
