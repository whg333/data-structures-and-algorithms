package com.whg.dataStructure.collection.queue;

import com.whg.dataStructure.collection.list.List;

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
