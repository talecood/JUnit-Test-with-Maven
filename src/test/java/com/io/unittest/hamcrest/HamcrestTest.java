package com.io.unittest.hamcrest;

import junit.framework.Assert;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.CombinableMatcher.either;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

public class HamcrestTest {

	@Test
	public void testBasicPairing() {
		String txt1 = "Goktug";
		String txt2 = "Tabak";
		
		assertEquals("Goktug",txt1);
		
		assertThat(txt1,is(equalTo("Goktug")));
		
		assertThat(txt1,containsString("ug")); //Is the string parameters exist in txt1?
		
		assertThat(txt1,anyOf(containsString("ug"),containsString("ir")));//If txt1 includes ANYOF parameters -> True
	}
	
	@Test
	public void ListsTest() throws Exception{
		List<String> cities = new ArrayList<>(Arrays.asList("Istanbul","Ankara","Izmir"));
		
		assertThat(cities,hasItem("Istanbul")); //Is there any "Istanbul" item in cities List?
		
		assertThat(cities,hasItems("Istanbul","Ankara"));//Are there "Istanbul" and "Ankara" items in cities list?(Plural)
		
		assertThat(cities,allOf(hasItems("Istanbul","Ankara"),not(hasItem("Bursa"))));//Are there "Istanbul" and "Ankara" items but not "Bursa" item same time in cities List?
		
		 assertThat(cities, either(hasItems("Istanbul", "Izmir")).or(not(hasItem("Bursa"))));//Like || Operator.
	}
}
