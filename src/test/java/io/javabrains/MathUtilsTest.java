package io.javabrains;

import io.javabrains.MathUtils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {
	private MathUtils math = new MathUtils();
	
	@BeforeEach
	void setUp() {
		math = new MathUtils();
	}
	@Test
	void test() {
		int expected = 2;
		int actual = math.addition(1, 1);
		assertEquals(expected,actual,"The addition method should add two number");
	}
	
	//									Assert Methods
	//	assertEquals(expected,actual)	 - 		assertArrayEquals(expectedArray,actualArray)
	//	assertIterableEquals(expectedArray,actualArray) Verifies each item in the iterable are equal in positions.
	
	@Test
	void testArea() {
		assertEquals(314.15926535897932384626433832795,math.circleArea(10),
				"Should give the area of circle with given radius.");
	}
	
	@Test
	void testDivision() {
		assertEquals(10,math.division(20, 2));
		
		assertThrows(ArithmeticException.class,()->math.division(1, 0),
				"Divide cannot completed because of denominator is zero.");
	}
	

}
