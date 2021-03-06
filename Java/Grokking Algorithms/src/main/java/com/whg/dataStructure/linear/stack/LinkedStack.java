package com.whg.dataStructure.linear.stack;

import java.util.Arrays;
import java.util.Iterator;

import com.whg.dataStructure.linear.list.LinkedList;

public class LinkedStack<E> extends LinkedList<E> implements Stack<E> {

    public LinkedStack() {
        super();
    }

    @Override
    public String toString() {
        return "LinkedStack [data=" + Arrays.toString(toArray()) + ", size=" + size + "]";
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseItr();
    }

}
