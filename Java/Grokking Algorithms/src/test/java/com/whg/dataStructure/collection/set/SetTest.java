package com.whg.dataStructure.collection.set;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SetTest {

    @Before
    public void before() {
        System.out.println("SetTest before");
    }

    @Test
    public void test() {
        testSet(new HashSet<>());
    }

    private void testSet(Set<Integer> set) {
        System.out.println(set);
        assertTrue(set.isEmpty());

        assertTrue(set.add(5));
        System.out.println(set);
        assertTrue(set.contains(5));
        assertTrue(set.size() == 1);

        assertTrue(set.add(0));
        assertTrue(set.add(7));
        System.out.println(set);
        assertTrue(set.size() == 3);
        assertTrue(!set.isEmpty());

        assertTrue(set.add(15));
        assertTrue(!set.add(15));
        System.out.println(set);
        assertTrue(set.size() == 4);

        assertTrue(set.remove(7));
        assertTrue(!set.remove(7));
        System.out.println(set);
        assertTrue(set.remove(0));
        assertTrue(!set.remove(0));
        System.out.println(set);
        assertTrue(set.size() == 2);

        assertTrue(set.contains(5));
        assertTrue(set.contains(15));
        assertTrue(!set.contains(7));

        assertTrue(!set.add(5));
        System.out.println(set);
        assertTrue(set.size() == 2);

        assertTrue(set.contains(5));
        assertTrue(set.contains(15));

        for (int i = 0; i < 10; i++) {
            set.add(20 + i);
        }
        System.out.println(set);
        assertTrue(set.size() == 12);
        Iterator<Integer> itr = set.iterator();
        assertTrue(itr.hasNext());

        set.clear();
        System.out.println(set);
        assertTrue(set.isEmpty());
        assertTrue(set.size() == 0);
        itr = set.iterator();
        assertTrue(!itr.hasNext());
    }

    @After
    public void after() {
        System.out.println("SetTest after");
    }

}
