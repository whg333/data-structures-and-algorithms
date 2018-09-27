package com.whg.dataStructure;

public interface Container {

    void clear();

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

}
