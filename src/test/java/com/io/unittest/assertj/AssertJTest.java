package com.io.unittest.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.assertj.core.api.Condition;
import org.junit.Test;

public class AssertJTest {

	@Test
	public void testStrings() throws Exception{
		
		String text1 = "Istanbul";
		
		//Different AssertJ Methods To Test
		assertThat(text1)
			.describedAs("One of the assertThat() methods don't work properly.") //To change Error Messages.
			.isEqualTo("Istanbul")
			.startsWith("Ist")
			.endsWith("bul")
			.contains("tan")
			.isNotNull()
			.doesNotContain("Goktug")
			.containsOnlyOnce("tan")
			;
	}
	
	List <String> cities = new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir","Bursa"));
	List <String> turkishCities = new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir","Bursa"));
	List <String> abroadCities = new ArrayList<String>(Arrays.asList("Berlin","Barcelona","London","Paris"));
	
	
	@Test
	public void testNormalLists()throws Exception{
		assertThat(cities)
			.describedAs("One of the assertThat() methods dont work properly.")
			.contains("Ankara") //Does the list includes "Ankara"?
			.doesNotContain("Mugla")//Does not the list includes "Mugla"?
			.containsExactly("Istanbul","Ankara","Izmir","Bursa")//Does the list containsEXACTLY("Istanbul","Ankara","Izmir","Bursa")?
			.doesNotHaveDuplicates()//Does the list has duplicated items? (Should Not)
			;
		
		//Only Turkish Cities on that list
		List <String> cities2 = new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir","Bursa"));
		
		assertThat(cities2)
			.have(turkishCities()); //Overrided .have() method.
		
		
		//Only abroad cities on that list.
		List <String> cities3 = new ArrayList<String>(Arrays.asList("Berlin","Barcelona","London","Paris"));
		
		assertThat(cities3)
			.have(abroadCities());
		
		
		//2 Turkish and 3 Abroad Cities on that list
		List <String> cities4 = new ArrayList<String>(Arrays.asList("Berlin","Istanbul","London","Ankara","Barcelona"));
		
		assertThat(cities4)
			.haveExactly(2, turkishCities())
			.haveExactly(3, abroadCities());
	}


	private Condition<? super String> abroadCities() {
		// TODO Auto-generated method stub
				return new Condition<String>() {
					@Override
					public boolean matches(String s) {
						return abroadCities.contains(s);
					}
				};
			}


	private Condition<? super String> turkishCities() {
		// TODO Auto-generated method stub
		return new Condition<String>() {
			@Override
			public boolean matches(String s) {
				return turkishCities.contains(s);
			}
		};
	}
}
