package com.io.unittest.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collection;
import java.util.List;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.io.javabrains.Calculator;

@RunWith(Parameterized.class)
public class ParameterTest{

	private Calculator calculator = new Calculator();
	
	@Parameterized.Parameters
	public static Collection<Object> data(){
		return Arrays.asList(new Object[][] {
			{10,2,20},
			{20,2,40},
			{5,10,50},
			{3,7,21}});			
	}
	private int a;
	private int b;
	private int total;

	
	
	public ParameterTest(int a, int b, int total) {
		this.a = a;
		this.b = b;
		this.total = total;
	}
	
	@Test
	public void testMultiply()throws Exception {
		assertEquals(total,calculator.multiply(a, b));
	}
}
