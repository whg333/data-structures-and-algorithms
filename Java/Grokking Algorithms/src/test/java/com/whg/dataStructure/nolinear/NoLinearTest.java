package com.whg.dataStructure.nolinear;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.whg.dataStructure.nolinear.map.JavaMapTest;
import com.whg.dataStructure.nolinear.map.LinkedHashMapTest;
import com.whg.dataStructure.nolinear.map.MapTest;
import com.whg.dataStructure.nolinear.tree.AdelsonVelskiiLandiTreeTest;
import com.whg.dataStructure.nolinear.tree.BinarySearchTreeTest;

@RunWith(Suite.class)
@SuiteClasses({ MapTest.class, LinkedHashMapTest.class, JavaMapTest.class, BinarySearchTreeTest.class, AdelsonVelskiiLandiTreeTest.class, })
public class NoLinearTest {

}
