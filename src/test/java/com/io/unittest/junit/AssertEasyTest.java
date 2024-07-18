package com.io.unittest.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.io.javabrains.Calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class AssertEasyTest {

	private Calculator calculator = new Calculator();
	
	@Test
	@Parameters({"2,10,20","3,2,6","1,0,0","2,-5,-10"})
	public void testMultiply(int a,int b,int total) throws Exception {
		assertEquals(total,calculator.multiply(a, b));
	}
}
