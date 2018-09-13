package com.whg.dataStructure;

import java.util.Objects;

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
    default boolean has(E e) {
        return indexOf(e) >= 0;
    }

    default int indexOf(E e) {
        Objects.requireNonNull(e);
        int size = size();
        for (int i = 0; i < size; i++) {
            if (e.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    default int lastIndexOf(E e) {
        Objects.requireNonNull(e);
        int lastIndex = size() - 1;
        for (int i = lastIndex; i >= 0; i--) {
            if (e.equals(get(i))) {
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

    E[] toArray();

}
