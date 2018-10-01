package com.whg;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.whg.dataStructure.collection.list.JavaListTest;
import com.whg.dataStructure.collection.list.ListTest;
import com.whg.dataStructure.collection.queue.QueueTest;
import com.whg.dataStructure.collection.set.SetTest;
import com.whg.dataStructure.collection.stack.StackTest;
import com.whg.dataStructure.map.MapTest;
import com.whg.grokkingAlgorithms.BinarySearchTest;
import com.whg.grokkingAlgorithms.QuickSortTest;
import com.whg.grokkingAlgorithms.SortUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ BinarySearchTest.class, QuickSortTest.class, SortUtilTest.class, JavaListTest.class, ListTest.class, StackTest.class, QueueTest.class,
        MapTest.class, SetTest.class })
public class AllTest {

}
