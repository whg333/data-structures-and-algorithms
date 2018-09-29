package com.whg;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.whg.dataStructure.JavaListTest;
import com.whg.dataStructure.ListTest;
import com.whg.dataStructure.MapTest;
import com.whg.dataStructure.QueueTest;
import com.whg.dataStructure.SetTest;
import com.whg.dataStructure.StackTest;
import com.whg.grokkingAlgorithms.BinarySearchTest;
import com.whg.grokkingAlgorithms.QuickSortTest;
import com.whg.grokkingAlgorithms.SortUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ BinarySearchTest.class, QuickSortTest.class, SortUtilTest.class, JavaListTest.class, ListTest.class, StackTest.class, QueueTest.class,
        MapTest.class, SetTest.class })
public class AllTest {

}
