package com.io.unittest.mock;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class BehaviorTest {

	@Test
	public void testBehavior() throws Exception{
		
		IDummyCustomerService customerService = Mockito.mock(IDummyCustomerService.class);
		
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");
		
		verify(customerService).addCustomer("istanbul");
		verify(customerService).addCustomer("ankara");
		
	}
	
	@Test
	public void testHowManyTimesReturned()throws Exception{
		IDummyCustomerService customerService = Mockito.mock(IDummyCustomerService.class);
		
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");
		customerService.addCustomer("istanbul");
		customerService.addCustomer("istanbul");
		
		//3 Times addcustomer("istanbul")
		verify(customerService,times(3)).addCustomer("istanbul"); //verify(object_name,times(parameter)).method_name()
		verify(customerService,times(1)).addCustomer("ankara");// Default is times(1)
		verify(customerService,never()).removeCustomer(anyString()); //The removeCustomer() method is not called for any string.
		
		verify(customerService,never()).addCustomer("izmir");//The addCustomer method has never been used with the "izmir" parameter.
		
		verify(customerService,atLeast(2)).addCustomer("istanbul");//The "Istanbul" parameter is used at least 2 times in the addCustomer method.
	}
	
	@Test
	public void controlTestOrder() throws Exception{
		IDummyCustomerService customerService = Mockito.mock(IDummyCustomerService.class);
		
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");
		customerService.updateCustomer("izmir");
		
		InOrder inOrder = inOrder(customerService); // We can give mock objects as much we want.
		
		inOrder.verify(customerService).addCustomer("istanbul");//1
		inOrder.verify(customerService).addCustomer("ankara");//2
		inOrder.verify(customerService).updateCustomer("izmir");//3
	}
	
	@Test
	public void testNoMoreControls()throws Exception{
		IDummyCustomerService customerService = Mockito.mock(IDummyCustomerService.class);
		IDummyCustomerService customerService2 = Mockito.mock(IDummyCustomerService.class);

		
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");
		
		verify(customerService).addCustomer("istanbul");
		verify(customerService).addCustomer("ankara");
		
		//verifyNoMoreInteractions(customerService); //No other verify methods, just the two on top.
		verifyNoInteractions(customerService2);//Do not use that mock object
		
	}
}
