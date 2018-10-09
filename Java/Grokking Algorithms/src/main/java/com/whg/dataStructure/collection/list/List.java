package com.whg.dataStructure.collection.list;

import java.util.Iterator;
import java.util.Objects;

import com.whg.dataStructure.collection.Collection;
import com.whg.dataStructure.collection.EmptyCollectionException;

public interface List<E> extends Collection<E> {

    default boolean addFirst(E e) {
        Objects.requireNonNull(e);
        return add(0, e);
    }

    default boolean addLast(E e) {
        Objects.requireNonNull(e);
        return add(size(), e);
    }

    @Override
    default boolean add(E e) {
        Objects.requireNonNull(e);
        return add(size(), e);
    }

    boolean add(int index, E e);

    @Override
    default boolean remove(E e) {
        return Objects.nonNull(remove(indexOf(e)));
    }

    default E removeFirst() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return remove(0);
    }

    default E removeLast() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return remove(size() - 1);
    }

    E remove(int index);

    @Override
    default boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    default int indexOf(E e) {
        Objects.requireNonNull(e);
        Iterator<E> itr = iterator();
        for (int i = 0; itr.hasNext(); i++) {
            if (e.equals(itr.next())) {
                return i;
            }
        }
        return -1;
    }

    default int lastIndexOf(E e) {
        Objects.requireNonNull(e);
        Iterator<E> reverseItr = reverseIterator();
        for (int i = size() - 1; reverseItr.hasNext(); i--) {
            if (e.equals(reverseItr.next())) {
                return i;
            }
        }
        return -1;
    }

    default E getFirst() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return get(0);
    }

    default E getLast() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return get(size() - 1);
    }

    E get(int index);

    E set(int index, E e);

    default List<E> reverse() {
        List<E> list = newInstance();
        Iterator<E> itr = reverseIterator();
        while (itr.hasNext()) {
            list.add(itr.next());
        }
        return list;
    }

    List<E> newInstance();

    Iterator<E> reverseIterator();

}
