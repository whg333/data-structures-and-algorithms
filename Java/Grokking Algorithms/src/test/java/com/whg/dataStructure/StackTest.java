package com.whg.dataStructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.whg.dataStructure.impl.ArrayStack;

public class StackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new ArrayStack<>();
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

        assertTrue(stack.peek() == 8);
        assertTrue(stack.size() == 2);

        stack.clear();
        System.out.println(stack);
        assertTrue(stack.isEmpty());
        assertTrue(stack.size() == 0);
    }

}
