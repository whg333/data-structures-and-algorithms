package com.whg.dataStructure.nolinear.map;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whg.dataStructure.Collection;

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

        assertTrue(map.containsKey(5));
        assertTrue(map.containsValue(5));
        assertTrue(map.containsKey(15));
        assertTrue(map.containsValue(15));
        assertTrue(!map.containsKey(7));
        assertTrue(!map.containsValue(7));

        Collection<Integer> keys = map.keySet();
        assertTrue(keys.contains(5));
        assertTrue(keys.contains(15));
        Collection<Integer> values = map.values();
        assertTrue(values.contains(5));
        assertTrue(values.contains(15));

        map.put(5, 15);
        System.out.println(map);
        assertTrue(map.size() == 2);

        assertTrue(map.containsKey(5));
        assertTrue(!map.containsValue(5));
        assertTrue(map.containsKey(15));
        assertTrue(map.containsValue(15));

        keys = map.keySet();
        assertTrue(keys.contains(5));
        assertTrue(keys.contains(15));
        values = map.values();
        assertTrue(!values.contains(5));
        assertTrue(values.contains(15));

        for (int i = 0; i < 10; i++) {
            map.put(20 + i, 20 + i);
        }
        System.out.println(map);
        assertTrue(map.size() == 12);
        keys = map.keySet();
        System.out.println(Arrays.toString(keys.toArray()));
        assertTrue(!Arrays.equals(keys.toArray(), new Integer[] { 5, 15, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 }));
        values = map.values();
        System.out.println(Arrays.toString(values.toArray()));
        assertTrue(!Arrays.equals(values.toArray(), new Integer[] { 15, 15, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 }));

        map.clear();
        System.out.println(map);
        assertTrue(map.isEmpty());
        assertTrue(map.size() == 0);
        Iterator<Integer> itr = map.keySet().iterator();
        assertTrue(!itr.hasNext());
        itr = map.values().iterator();
        assertTrue(!itr.hasNext());
    }

    @After
    public void after() {
        System.out.println("MapTest after");
    }

}
