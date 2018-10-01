package com.whg.dataStructure.collection.list;

import java.util.Arrays;
import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int size;

    @Override
    public List<E> newInstance() {
        return new LinkedList<E>();
    }

    public LinkedList() {

    }

    @Override
    public boolean add(int index, E e) {
        rangeCheckforAdd(index);
        Node<E> newNode = isHead(index) ? linkHead(e) : linkBefore(index, e);
        checkLinkTail(index, newNode);

        size++;
        return true;
    }

    private Node<E> linkHead(E e) {
        boolean hasHead = head != null; // same as !isEmpty()
        Node<E> newNode = new Node<>(e, null, hasHead ? head : null);
        if (hasHead) {
            head.prev = newNode;
        }
        head = newNode;
        return newNode;
    }

    private Node<E> linkBefore(int index, E e) {
        Node<E> prevNode = getNode(index - 1);
        Node<E> newNode = new Node<>(e, prevNode, prevNode.next);
        if (prevNode.next != null) {
            prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;
        return newNode;
    }

    private void checkLinkTail(int index, Node<E> newNode) {
        if (isTail(index)) {
            tail = newNode;
        }
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> oldNode = isHead(index) ? unlinkHead() : unlinkBefore(index);
        checkUnlinkTail(index + 1, oldNode); // tail is index + 1

        E value = oldNode.value;
        oldNode.clear();

        --size;
        return value;
    }

    private Node<E> unlinkHead() {
        Node<E> oldNode = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return oldNode;
    }

    private Node<E> unlinkBefore(int index) {
        Node<E> prevNode = getNode(index - 1);
        Node<E> oldNode = prevNode.next;
        if (oldNode.next != null) {
            oldNode.next.prev = prevNode;
        }
        prevNode.next = oldNode.next;
        return oldNode;
    }

    private void checkUnlinkTail(int index, Node<E> oldNode) {
        if (isTail(index)) {
            tail = oldNode.prev;
        }
    }

    private boolean isHead(int index) {
        return index == 0;
    }

    private boolean isTail(int index) {
        return index == size;
    }

    @Override
    public E set(int index, E e) {
        Node<E> oldNode = getNode(index);
        E old = oldNode.value;
        oldNode.value = e;
        return old;
    }

    @Override
    public E get(int index) {
        return getNode(index).value;
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
        Iterator<Node<E>> itrNode = iteratorNode();
        while (itrNode.hasNext()) {
            itrNode.next().clear();
        }
        head = null;
        tail = null;
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
        E[] array = (E[])new Object[size];
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

        @Override
        public void remove() {
            itrNode.remove();
        }

    }

    private Iterator<Node<E>> iteratorNode() {
        return new ItrNode();
    }

    private class ItrNode implements Iterator<Node<E>> {

        Node<E> currNode = head;
        int index = 0;
        int lastIndex = -1;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public Node<E> next() {
            Node<E> next = currNode;
            currNode = currNode.next;
            lastIndex = index++;
            return next;
        }

        @Override
        public void remove() {
            LinkedList.this.remove(lastIndex);
            index = lastIndex;
        }

    }

    @Override
    public Iterator<E> reverseIterator() {
        return new ReverseItr();
    }

    private class ReverseItr implements Iterator<E> {

        Iterator<Node<E>> reverseItrNode = reverseIteratorNode();

        @Override
        public boolean hasNext() {
            return reverseItrNode.hasNext();
        }

        @Override
        public E next() {
            return reverseItrNode.next().value;
        }

        @Override
        public void remove() {
            reverseItrNode.remove();
        }

    }

    private Iterator<Node<E>> reverseIteratorNode() {
        return new ReverseItrNode();
    }

    private class ReverseItrNode implements Iterator<Node<E>> {

        Node<E> currNode = tail;
        int index = size() - 1;
        int lastIndex = -1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Node<E> next() {
            Node<E> next = currNode;
            currNode = currNode.prev;
            lastIndex = index--;
            return next;
        }

        @Override
        public void remove() {
            LinkedList.this.remove(lastIndex);
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

        /** clear to let GC do its work */
        void clear() {
            value = null;
            prev = null;
            next = null;
        }

    }

}
