package com.whg.dataStructure;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whg.dataStructure.impl.HashMap;

public class MapTest {

    @Before
    public void before() {
        System.out.println("MapTest before");
    }

    @Test
    public void test() {
        testMap(new HashMap<>());
    }

    private void testMap(Map<Integer, Integer> map) {
        System.out.println(map);
        assertTrue(map.isEmpty());

        map.put(5, 5);
        System.out.println(map);
        assertTrue(map.get(5) == 5);
        assertTrue(map.size() == 1);

        map.put(0, 0);
        map.put(7, 7);
        System.out.println(map);
        assertTrue(map.size() == 3);
        assertTrue(!map.isEmpty());

        map.put(15, 15);
        System.out.println(map);
        assertTrue(map.size() == 4);

        Integer popEle = map.remove(7);
        System.out.println(map);
        assertTrue(popEle == 7);
        popEle = map.remove(0);
        System.out.println(map);
        assertTrue(popEle == 0);

        assertTrue(map.hasKey(5));
        assertTrue(map.hasValue(5));
        assertTrue(map.hasKey(15));
        assertTrue(map.hasValue(15));
        assertTrue(!map.hasKey(7));
        assertTrue(!map.hasValue(7));

        Collection<Integer> keys = map.keys();
        assertTrue(keys.has(5));
        assertTrue(keys.has(15));
        Collection<Integer> values = map.values();
        assertTrue(values.has(5));
        assertTrue(values.has(15));

        map.put(5, 15);
        System.out.println(map);
        assertTrue(map.size() == 2);

        assertTrue(map.hasKey(5));
        assertTrue(!map.hasValue(5));
        assertTrue(map.hasKey(15));
        assertTrue(map.hasValue(15));

        keys = map.keys();
        assertTrue(keys.has(5));
        assertTrue(keys.has(15));
        values = map.values();
        assertTrue(!values.has(5));
        assertTrue(values.has(15));

        for (int i = 0; i < 10; i++) {
            map.put(20 + i, 20 + i);
        }
        System.out.println(map);
        assertTrue(map.size() == 12);

        map.clear();
        System.out.println(map);
        assertTrue(map.isEmpty());
        assertTrue(map.size() == 0);
        Iterator<Integer> itr = map.keys().iterator();
        assertTrue(!itr.hasNext());
        itr = map.values().iterator();
        assertTrue(!itr.hasNext());
    }

    @After
    public void after() {
        System.out.println("MapTest after");
    }

}
