package com.io.unittest.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertTest {

	@Test
	public void testAssertions()throws Exception{
		
		Dummy d1 = null;
		Dummy d2 = d1;
		
		assertSame(d1, d2); //Are the objects same?
		assertNull(d1); //Is the object null?
	//	assertNotNull(d1);//Is the object NOT null?
		assertTrue(d1==d2);
	}
	
	private static class Dummy {
		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Dummy(int id) {
			super();
			this.id = id;
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.id == ((Dummy)obj).getId();
		}
	}
}
