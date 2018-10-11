package com.whg.dataStructure.linear;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.whg.dataStructure.linear.list.JavaListTest;
import com.whg.dataStructure.linear.list.ListTest;
import com.whg.dataStructure.linear.queue.QueueTest;
import com.whg.dataStructure.linear.stack.StackTest;

@RunWith(Suite.class)
@SuiteClasses({ JavaListTest.class, ListTest.class, QueueTest.class, StackTest.class, })
public class LinearTest {

}
