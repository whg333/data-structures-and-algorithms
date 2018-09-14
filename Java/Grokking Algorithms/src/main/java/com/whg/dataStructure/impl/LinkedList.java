package com.whg.dataStructure.impl;

import java.util.Arrays;

import com.whg.dataStructure.Iterator;
import com.whg.dataStructure.List;

public class LinkedList<E> implements List<E> {

    protected Node<E> head;
    protected int size;

    public LinkedList() {
        head = new Node<>(null, null, null);
    }

    @Override
    public boolean add(int index, E e) {
        rangeCheckforAdd(index);
        Node<E> prevNode = index == 0 ? head : getNode(index - 1);
        Node<E> newNode = new Node<>(e, prevNode, prevNode.next);
        if (prevNode.next != null) {
            prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;
        size++;
        return true;
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
        Iterator<Node<E>> itrNode = iteratorNode();
        for (int i = 0; itrNode.hasNext(); i++) {
            Node<E> next = itrNode.next();
            if (i == index) {
                return next;
            }
        }
        throw new IllegalArgumentException("Can not found index=" + index);
    }

    private void rangeCheckforAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
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

    @Override
    public String toString() {
        return "LinkedList [data=" + Arrays.toString(toArray()) + ", size=" + size + "]";
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

        ItrNode itrNode = new ItrNode();

        @Override
        public boolean hasNext() {
            return itrNode.hasNext();
        }

        @Override
        public E next() {
            return itrNode.next().value;
        }

    }

    private Iterator<Node<E>> iteratorNode() {
        return new ItrNode();
    }

    private class ItrNode implements Iterator<Node<E>> {

        Node<E> currNode = head;

        @Override
        public boolean hasNext() {
            return currNode.next != null;
        }

        @Override
        public Node<E> next() {
            currNode = currNode.next;
            return currNode;
        }

    }

    private static class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;

        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

    }

}
