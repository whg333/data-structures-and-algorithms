package com.whg;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.whg.dataStructure.linear.LinearTest;
import com.whg.dataStructure.nolinear.NoLinearTest;
import com.whg.dataStructure.set.SetTest;
import com.whg.grokkingAlgorithms.BinarySearchTest;
import com.whg.grokkingAlgorithms.QuickSortTest;
import com.whg.grokkingAlgorithms.SortUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ BinarySearchTest.class, QuickSortTest.class, SortUtilTest.class, LinearTest.class, NoLinearTest.class, SetTest.class, })
public class AllTest {

}
