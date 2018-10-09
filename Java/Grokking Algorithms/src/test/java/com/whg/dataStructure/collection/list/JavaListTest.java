package com.whg.dataStructure.collection.list;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whg.dataStructure.collection.EmptyCollectionException;

public class JavaListTest {

    private List<Integer> list;

    @Before
    public void before() {
        System.out.println("ListTest before");
        list = new LinkedList<>();
    }

    @Test
    public void test() {
        testList(new ArrayList<>());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException2() {
        list.get(-1);
    }

    @Test(expected = EmptyCollectionException.class)
    public void testGetException3() {
        list.getFirst();
    }

    @Test(expected = EmptyCollectionException.class)
    public void testGetException4() {
        list.getLast();
    }

    @Test(expected = EmptyCollectionException.class)
    public void testRemoveException() {
        list.removeFirst();
    }

    @Test(expected = EmptyCollectionException.class)
    public void testRemoveException2() {
        list.removeLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddException() {
        list.add(1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddException2() {
        list.add(-1, 1);
    }

    private void testList(ArrayList<Integer> list) {
        System.out.println(list);
        assertTrue(list.isEmpty());

        list.add(1);
        list.add(2);
        System.out.println(list);
        assertTrue(list.size() == 2);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { 1, 2 }));

        list.add(3);
        list.add(4);
        System.out.println(list);
        assertTrue(list.size() == 4);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { 1, 2, 3, 4 }));

        list.add(0, 0);
        list.add(0, -1);
        System.out.println(list);
        assertTrue(list.size() == 6);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { -1, 0, 1, 2, 3, 4 }));

        list.add(0, -2);
        list.add(list.size(), 5);
        System.out.println(list);
        assertTrue(list.size() == 8);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { -2, -1, 0, 1, 2, 3, 4, 5 }));
        assertTrue(list.contains(2));
        assertTrue(list.indexOf(2) == 4);
        assertTrue(list.get(4) == 2);
        assertTrue(list.contains(-2));
        assertTrue(list.lastIndexOf(-2) == 0);
        assertTrue(list.get(0) == -2);
        assertTrue(list.contains(5));
        assertTrue(list.indexOf(5) == 7);
        assertTrue(list.get(7) == 5);
        assertTrue(!list.contains(6));
        assertTrue(list.lastIndexOf(6) == -1);
        assertTrue(list.get(0) == -2);
        assertTrue(list.get(list.size() - 1) == 5);

        list.remove(Integer.valueOf(-1));
        System.out.println(list);
        list.remove(Integer.valueOf(-2));
        System.out.println(list);
        list.add(6);
        System.out.println(list);
        list.remove(Integer.valueOf(6));
        System.out.println(list);
        assertTrue(list.lastIndexOf(5) == 5);
        assertTrue(list.size() == 6);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { 0, 1, 2, 3, 4, 5 }));

        list.remove(4);
        list.remove(0);
        System.out.println(list);
        assertTrue(list.size() == 4);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { 1, 2, 3, 5 }));

        list.remove(0);
        list.remove(list.size() - 1);
        System.out.println(list);
        assertTrue(list.size() == 2);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { 2, 3 }));

        Iterator<Integer> itr = list.iterator();
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 2);
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 3);
        assertTrue(!itr.hasNext());

        Collections.reverse(list);
        assertTrue(list.indexOf(2) == 1);
        assertTrue(list.lastIndexOf(2) == 1);
        assertTrue(list.indexOf(3) == 0);
        assertTrue(list.lastIndexOf(3) == 0);
        assertTrue(list.size() == 2);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { 3, 2 }));

        list.clear();
        System.out.println(list);
        assertTrue(list.isEmpty());
        assertTrue(list.size() == 0);
        itr = list.iterator();
        assertTrue(!itr.hasNext());

        list.add(3);
        System.out.println(list);
        assertTrue(list.lastIndexOf(3) == 0);
        assertTrue(list.lastIndexOf(1) == -1);

        list.set(0, 1);
        System.out.println(list);
        assertTrue(list.lastIndexOf(3) == -1);
        assertTrue(list.lastIndexOf(1) == 0);

        list.add(4);
        System.out.println(list);
        assertTrue(list.lastIndexOf(3) == -1);
        assertTrue(list.lastIndexOf(1) == 0);
        assertTrue(list.lastIndexOf(4) == 1);
        assertTrue(list.lastIndexOf(2) == -1);

        list.set(1, 2);
        System.out.println(list);
        assertTrue(list.lastIndexOf(3) == -1);
        assertTrue(list.lastIndexOf(1) == 0);
        assertTrue(list.lastIndexOf(4) == -1);
        assertTrue(list.lastIndexOf(2) == 1);
        assertTrue(list.indexOf(3) == -1);
        assertTrue(list.indexOf(1) == 0);
        assertTrue(list.indexOf(4) == -1);
        assertTrue(list.indexOf(2) == 1);

        assertTrue(list.size() == 2);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { 1, 2 }));

        itr = list.iterator();
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 1);
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 2);
        assertTrue(!itr.hasNext());

        itr = list.iterator();
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 1);
        assertTrue(list.contains(1));
        itr.remove();
        assertTrue(!list.contains(1));
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 2);
        assertTrue(!itr.hasNext());
        assertTrue(list.contains(2));

        list.add(list.size(), 1);
        assertTrue(list.size() == 2);
        assertTrue(Arrays.equals(list.toArray(), new Integer[] { 2, 1 }));

        Collections.reverse(list);
        itr = list.iterator();
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 1);
        assertTrue(list.contains(1));
        itr.remove();
        assertTrue(!list.contains(1));
        assertTrue(itr.hasNext());
        assertTrue(itr.next() == 2);
        assertTrue(!itr.hasNext());
        assertTrue(list.contains(2));

        list.clear();
        System.out.println(list);
        itr = list.iterator();
        assertTrue(!itr.hasNext());
    }

    @After
    public void after() {
        list = null;
        System.out.println("ListTest after");
    }

}
