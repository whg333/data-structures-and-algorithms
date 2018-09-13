package com.whg.dataStructure.impl;

import com.whg.dataStructure.Iterator;
import com.whg.dataStructure.List;

public class LinkedList<E> implements List<E> {

    protected Node<E> head;
    protected int size;

    public LinkedList() {
        head = new Node<>(null, null);
    }

    @Override
    public boolean add(int index, E e) {
        rangeCheckforAdd(index);
        head.next = new Node<>(e, head);
        size++;
        return true;
    }

    private void rangeCheckforAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    @Override
    public E remove(int index) {
        Node<E> oldNode = getNode(index);
        oldNode.prev.next = oldNode.next;
        if (oldNode.next != null) {
            oldNode.next.prev = oldNode.prev;
            oldNode.next = null;
        }
        --size;
        return oldNode.value;
    }

    @Override
    public E get(int index) {
        return getNode(index).value;
    }

    @Override
    public E set(int index, E e) {
        Node<E> oldNode = getNode(index);
        E old = oldNode.value;
        oldNode.value = e;
        return old;
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);
        Node<E> curr = head.next;
        for (int i = 0; curr != null; curr = curr.next, i++) {
            if (i == index) {
                return curr;
            }
        }
        throw new IllegalArgumentException("Can not found index=" + index);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public void clear() {
        if (head.next != null) {
            head.next.prev = null;
            head.next = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        Iterator<E> itr = iterator();
        for (int i = 0; itr.hasNext(); i++) {
            array[i] = itr.next();
        }
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        Node<E> currNode = head.next;

        @Override
        public boolean hasNext() {
            return currNode != null;
        }

        @Override
        public E next() {
            E curr = currNode.value;
            currNode = currNode.next;
            return curr;
        }

    }

    private static class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;

        public Node(E value, Node<E> prev) {
            this.value = value;
            this.prev = prev;
        }

    }

}
