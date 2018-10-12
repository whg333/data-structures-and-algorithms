package com.whg.dataStructure.set;

import java.util.Arrays;

import com.whg.dataStructure.nolinear.map.LinkedHashMap;

public class LinkedHashSet<E> extends HashSet<E> {

    public LinkedHashSet() {
        map = new LinkedHashMap<>();
    }

    @Override
    public String toString() {
        return "LinkedHashSet [data=" + Arrays.toString(toArray()) + ", size=" + size() + "]";
    }

}
