package com.io.unittest.javabrains.mathutils;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.*;

import com.io.javabrains.MathUtils;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
	private MathUtils math = new MathUtils();
	TestInfo testinfo;
	TestReporter testreporter;

	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all.");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("This needs to run after all.");
	}
	
	@Tag("Math")
	@Nested
	class AddTest{
		@Test
		@DisplayName("Testing Addition Method for Positive") // Changes name of method in Console
		void testOfPositiveAddition() {
			int expected = 2;
			int actual = math.addition(1, 1);
			assertEquals(expected,actual,"Should be returned "+expected+" but returned "+actual);
			assertEquals(29,math.addition(2, 27));
		}
		
		@Test
		@DisplayName("Testing addition Method for Negative")
		void testOfNegativeAddition() {
			assertAll(
					() -> assertEquals(-5,math.addition(-10, 5)),
					() -> assertEquals(-15,math.addition(-20, 5)),
					() -> assertEquals(-90,math.addition(-30,-60))
					);
		}
	}

	@BeforeEach
	void setUp(TestInfo testinfo,TestReporter testreporter) {
		this.testinfo = testinfo;
		this.testreporter = testreporter;
		//System.out.println("Running "+testinfo.getDisplayName()+" with tags "+testinfo.getTags());
		testreporter.publishEntry("Running "+testinfo.getDisplayName()+" with tags "+testinfo.getTags());
		math = new MathUtils();
	}

	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up..");
	}
	
	//									Assert Methods
	//	assertEquals(expected,actual)	 - 		assertArrayEquals(expectedArray,actualArray)
	//	assertIterableEquals(expectedArray,actualArray) Verifies each item in the iterable are equal in positions.
	
	@Tag("Math")
//  @RepeatedTest(3) //Runs the test 3 times.
	void testArea(/*RepetitionInfo repetitionInfo*/) {
		// repetitionInfo. Methods.
		
		assertEquals(314.15926535897932384626433832795,math.circleArea(10),
				"Should give the area of circle with given radius.");
	}
	@Tag("Math")
	@Test
	void testDivision() {
		assumeTrue(1==0);
		
		assertThrows(ArithmeticException.class, () -> math.division(1, 0), 
				"Divide should throw ArithmeticException when denominator is zero");
	}
	

	@Test
	@Disabled // Skips the test
	@DisplayName("This test should be skipped")
	void testDisabled() {
		fail("This test should be disabled");
	}
	
	@Tag("Math")
	@Test
	@DisplayName("Multiplication Method")
	void Should_Return_Multiplication_of_Parameters() {
		assertAll(
				//If one of tests fail all of the test fails.
				() -> assertEquals(4,math.multiplication(2,2)),
				() -> assertEquals(10,math.multiplication(5, 2)),
				() -> assertEquals(-5,math.multiplication(-1,5)),
				() -> assertEquals(25,math.multiplication(5, 5))
				);
	}
	
	

}
