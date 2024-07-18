package com.io.unittest.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Run Different Test Classes at the same time with respect to their order.
@RunWith(Suite.class)
@Suite.SuiteClasses({
	AssertEasyTest.class,
	AssertTest.class,
	ParameterTest.class
}
)
public class SuiteTest {

	
}
