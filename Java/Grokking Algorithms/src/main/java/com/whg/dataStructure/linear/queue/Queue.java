package com.whg.dataStructure.linear.queue;

import com.whg.dataStructure.linear.list.List;

public interface Queue<E> extends List<E> {

    @SuppressWarnings("unchecked")
    default void offer(E... elements) {
        for (E e : elements) {
            addLast(e);
        }
    }

    default E poll() {
        return removeFirst();
    }

    default E peek() {
        return getFirst();
    }

}
