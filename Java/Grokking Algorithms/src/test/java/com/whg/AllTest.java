package com.whg;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.whg.dataStructure.ListTest;
import com.whg.dataStructure.QueueTest;
import com.whg.dataStructure.StackTest;
import com.whg.grokkingAlgorithms.BinarySearchTest;
import com.whg.grokkingAlgorithms.QuickSortTest;
import com.whg.grokkingAlgorithms.SortUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ BinarySearchTest.class, QuickSortTest.class, SortUtilTest.class, ListTest.class, StackTest.class, QueueTest.class })
public class AllTest {

}
