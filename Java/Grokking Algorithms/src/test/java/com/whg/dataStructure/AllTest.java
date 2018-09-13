package com.whg.dataStructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.whg.dataStructure.impl.ArrayQueue;
import com.whg.dataStructure.impl.ArrayStack;

public class AllTest {

    @Test
    public void testStack() {
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

        stack.clear();
        System.out.println(stack);
        assertTrue(stack.isEmpty());
        assertTrue(stack.size() == 0);
        itr = stack.iterator();
        assertTrue(!itr.hasNext());
    }

    @Test
    public void testQueue() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        System.out.println(queue);
        assertTrue(queue.isEmpty());

        queue.offer("John", "Jack");
        System.out.println(queue);
        assertTrue(queue.peek().equals("John"));

        queue.offer("Camila");
        System.out.println(queue);
        assertTrue(queue.size() == 3);
        assertTrue(!queue.isEmpty());

        String dequeueEle = queue.poll();
        System.out.println(queue);
        assertTrue(dequeueEle.equals("John"));

        dequeueEle = queue.poll();
        System.out.println(queue);
        assertTrue(dequeueEle.equals("Jack"));

        assertTrue(queue.peek().equals("Camila"));
        assertTrue(queue.size() == 1);

        queue.clear();
        System.out.println(queue);
        assertTrue(queue.isEmpty());
        assertTrue(queue.size() == 0);
    }

}
