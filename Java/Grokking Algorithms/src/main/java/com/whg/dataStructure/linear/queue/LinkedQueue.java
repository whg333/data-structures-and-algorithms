package com.whg.dataStructure.linear.queue;

import java.util.Arrays;

import com.whg.dataStructure.linear.list.LinkedList;

public class LinkedQueue<E> extends LinkedList<E> implements Queue<E> {

    public LinkedQueue() {
        super();
    }

    @Override
    public String toString() {
        return "LinkedQueue [data=" + Arrays.toString(toArray()) + ", size=" + size + "]";
    }

}
