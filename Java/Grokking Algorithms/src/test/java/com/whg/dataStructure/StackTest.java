package com.whg.dataStructure;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whg.dataStructure.impl.ArrayStack;

public class StackTest {

    @Before
    public void before() {
        System.out.println("StackTest before");
    }

    @Test
    public void test() {
        testStack(new ArrayStack<>());
    }

    private void testStack(Stack<Integer> stack) {
        System.out.println(stack);
        assertTrue(stack.isEmpty());

        stack.push(5, 8);
        System.out.println(stack);
        assertTrue(stack.peek() == 8);

        stack.push(11);
        System.out.println(stack);
        assertTrue(stack.size() == 3);
        assertTrue(!stack.isEmpty());

        stack.push(15);
        System.out.println(stack);

        stack.pop();
        Integer popEle = stack.pop();
        System.out.println(stack);
        assertTrue(popEle == 11);

        Iterator<Integer> itr = stack.iterator();
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 8);
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 5);
        assertTrue(!itr.hasNext());

        assertTrue(stack.peek() == 8);
        assertTrue(stack.size() == 2);

        itr = stack.iterator();
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 8);
        assertTrue(stack.has(8));
        itr.remove();
        System.out.println(stack);
        assertTrue(!stack.has(8));
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 5);
        assertTrue(!itr.hasNext());
        assertTrue(stack.has(5));

        stack.clear();
        System.out.println(stack);
        assertTrue(stack.isEmpty());
        assertTrue(stack.size() == 0);
        itr = stack.iterator();
        assertTrue(!itr.hasNext());
    }

    @After
    public void after() {
        System.out.println("StackTest after");
    }

}
