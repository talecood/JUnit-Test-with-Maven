package com.io.unittest.assertj;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.ArgumentMatchers.contains;


public class CustomerListAssertjTest {
static class Item {
		
		private Integer ID;
		
		private String name;
		
		public Item(int i, String string) {
			this.ID =i;
			this.name = string;
		} 	

		public Integer getID() {
			return ID;
		}

		public void setID(Integer iD) {
			ID = iD;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	@Test
	public void testLists() throws Exception{
		
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1, "john"));
		items.add(new Item(2, "jennifer"));
		items.add(new Item(3,"marc"));
		items.add(new Item(4,"marc"));
		items.add(new Item(5,"jennifer"));
		
		assertThat(items)
			.extracting("name")
			.contains("john");
			
		assertThat(items)
			.extracting("name","ID")
			.contains(
					tuple("john",1),
					tuple("jennifer",2),
					tuple("marc",3)
					);
		
		assertThat(extractProperty("ID",Integer.class).from(items));
	}
}
