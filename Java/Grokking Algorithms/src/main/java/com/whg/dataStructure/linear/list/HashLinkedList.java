package com.whg.dataStructure.linear.list;

import java.util.Arrays;

import com.whg.dataStructure.nolinear.map.HashMap;
import com.whg.dataStructure.nolinear.map.Map;

public class HashLinkedList<E> extends LinkedList<E> {

    protected Map<Integer, E> map;

    @Override
    public List<E> newInstance() {
        return new HashLinkedList<E>();
    }

    public HashLinkedList() {
        super();
        map = new HashMap<>();
    }

    @Override
    public boolean add(int index, E e) {
        int size = size();
        boolean result = super.add(index, e);
        for (int i = size - 1; i >= index; i--) {
            map.put(i + 1, map.get(i));
        }
        map.put(index, e); // add current index element
        return result;
    }

    @Override
    public E remove(int index) {
        E old = super.remove(index);
        for (int i = index; i < size; i++) {
            map.put(i, map.get(i + 1));
        }
        map.remove(size); // remove the last element
        return old;
    }

    @Override
    public E get(int index) {
        return map.get(index);
    }

    @Override
    public String toString() {
        return "HashLinkedList [data=" + Arrays.toString(toArray()) + ", size=" + size + ", map=" + map.toString() + "]";
    }

}
