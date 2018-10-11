package com.whg.dataStructure.linear.stack;

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

}
