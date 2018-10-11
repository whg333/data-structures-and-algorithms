package com.whg.dataStructure.linear.queue;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whg.dataStructure.linear.queue.ArrayQueue;
import com.whg.dataStructure.linear.queue.LinkedQueue;
import com.whg.dataStructure.linear.queue.Queue;

public class QueueTest {

    @Before
    public void before() {
        System.out.println("QueueTest before");
    }

    @Test
    public void test() {
        testQueue(new ArrayQueue<>());
        System.out.println("\n ------------------ \n");
        testQueue(new LinkedQueue<>());
    }

    private void testQueue(Queue<String> queue) {
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

        Iterator<String> itr = queue.iterator();
        assertTrue(itr.hasNext());
        assertTrue(itr.next().equals("Jack"));
        assertTrue(itr.hasNext());
        assertTrue(itr.next().equals("Camila"));
        assertTrue(!itr.hasNext());

        dequeueEle = queue.poll();
        System.out.println(queue);
        assertTrue(dequeueEle.equals("Jack"));

        assertTrue(queue.peek().equals("Camila"));
        assertTrue(queue.size() == 1);
        itr = queue.iterator();
        assertTrue(itr.hasNext());

        queue.clear();
        System.out.println(queue);
        assertTrue(queue.isEmpty());
        assertTrue(queue.size() == 0);
        itr = queue.iterator();
        assertTrue(!itr.hasNext());
    }

    @After
    public void after() {
        System.out.println("QueueTest after");
    }

}
